package com.helloxyy.top.demo.plugin.biz1.extension;

import com.helloxyy.top.demo.solution.promotion.PromotionExtension;
import com.helloxyy.top.demo.solution.promotion.request.PromotionRequest;

/**
 * Created by lihao on 17/12/13.
 *
 * @author lihao
 * @date 2020/3/17
 */
public class Biz1PromotionExtensionImpl implements PromotionExtension {
    @Override
    public long getDiscount(PromotionRequest item) {
        return 10;
    }
}
