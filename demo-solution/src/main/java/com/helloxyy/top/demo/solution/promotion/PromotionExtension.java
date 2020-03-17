package com.helloxyy.top.demo.solution.promotion;

import com.helloxyy.top.demo.solution.promotion.request.PromotionRequest;
import com.helloxyy.top.smart.ext.core.api.ExtensionPoints;

/**
 * User: kuhe
 * Date: 2017/7/7
 * Time: PM4:55
 */

public interface PromotionExtension extends ExtensionPoints {

    long getDiscount(PromotionRequest item);
}
