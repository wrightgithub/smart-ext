package com.helloxyy.top.demo.solution.promotion.request;

import com.helloxyy.top.smart.ext.core.api.BizInstance;

/**
 * Created by lihao on 17/12/13.
 *
 * @author lihao
 * @date 2020/3/17
 */
public class PromotionRequest extends BizInstance {
    private String promotionName;

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }
}
