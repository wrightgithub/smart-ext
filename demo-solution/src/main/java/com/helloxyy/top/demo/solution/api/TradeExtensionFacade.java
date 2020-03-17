package com.helloxyy.top.demo.solution.api;

import com.helloxyy.top.demo.solution.delivery.DeliveryExtension;
import com.helloxyy.top.demo.solution.promotion.PromotionExtension;
import com.helloxyy.top.smart.ext.core.api.ExtensionFacade;

public abstract class TradeExtensionFacade implements ExtensionFacade {

    public abstract DeliveryExtension getDeliveryExtension();

    public abstract PromotionExtension getPromotionExtension();

}
