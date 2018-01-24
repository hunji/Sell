package com.youhualife.service.impl;

import com.youhualife.dataobject.ProductInfo;
import com.youhualife.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * created by guo19
 * created on 2018/1/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() throws Exception {
        ProductInfo model=productService.findOne("123457");
        Assert.assertEquals("123457", model.getProductId());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> productInfoList=productService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void save() throws Exception {
//        ProductInfo productInfo = new ProductInfo();
//        productInfo.setProductId("123457");
//        productInfo.setProductName("皮皮虾");
//        productInfo.setProductPrice(new BigDecimal(3.2));
//        productInfo.setProductStock(100);
//        productInfo.setProductDescription("很好吃的虾");
//        productInfo.setProductIcon("http://xxxxx.jpg");
//        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
//        productInfo.setCategoryType(2);

        ProductInfo productInfo =productService.findOne("123457");
        productInfo.setProductDescription("测试测试");
        ProductInfo result=productService.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findAll() throws Exception {
        PageRequest request=new PageRequest(0,2);
        Page<ProductInfo> productInfoPage=productService.findAll(request);
        Assert.assertNotEquals(0, productInfoPage.getTotalElements());
    }

    @Test
    public void onSale() throws Exception {
    }

    @Test
    public void offSale() throws Exception {
    }

}