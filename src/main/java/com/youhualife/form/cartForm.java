package com.youhualife.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 购物车表单实体
 * created by guo19
 * created on 2018/1/26
 */
@Data
public class cartForm {
    @NotEmpty(message = "产品id必填")
    private String productId;

    @NotEmpty(message = "购买数量必填")
    private Integer productQuantity;

}
