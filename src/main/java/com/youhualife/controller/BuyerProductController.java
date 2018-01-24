package com.youhualife.controller;

import com.youhualife.VO.ProductInfoVO;
import com.youhualife.VO.ProductVO;
import com.youhualife.VO.ResultVO;
import com.youhualife.dataobject.ProductCategory;
import com.youhualife.dataobject.ProductInfo;
import com.youhualife.service.CategoryService;
import com.youhualife.service.ProductService;
import com.youhualife.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 卖家商品controller
 * created by guo19
 * created on 2018/1/24
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        //1.查询所有上架的商品
        List<ProductInfo> productInfoList=productService.findUpAll();
        //2.查询所有上架商品的类目（一次性查出）
        //这里使用了java8的lambda表达式
        List<Integer> categoryTypeList=productInfoList.stream()
                .map(e->e.getCategoryType())
                .distinct()
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList=categoryService.findByCategoryTypeIn(categoryTypeList);
        //3.拼接出数据
        //3.1 先找到每个不重复的类别
        List<ProductVO> productVOList=new ArrayList<>();
        for (ProductCategory productCategory:productCategoryList){
            ProductVO productVO=new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            //3.2把每个类别下的全部商品加载到vo中
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo: productInfoList) {
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }
}
