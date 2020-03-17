package com.helloxyy.top.demo.plugin.biz2.facade;

import com.helloxyy.top.demo.plugin.biz1.extension.Biz1DeliveryExtensionImpl;
import com.helloxyy.top.demo.plugin.biz2.extension.Biz2DeliveryExtensionImpl;
import com.helloxyy.top.demo.plugin.biz2.extension.Biz2PromotionExtensionImpl;
import com.helloxyy.top.demo.solution.api.TradeExtensionFacade;
import com.helloxyy.top.demo.solution.delivery.DeliveryExtension;
import com.helloxyy.top.demo.solution.promotion.PromotionExtension;
import com.helloxyy.top.smart.ext.core.api.BizCode;

/**
 * Created by lihao on 17/12/13.
 *
 * @author lihao
 * @date 2020/3/17
 */
@BizCode("biz2")
public class Biz2TradeExtensionFacadeImpl extends TradeExtensionFacade {
    @Override
    public DeliveryExtension getDeliveryExtension() {
        return new Biz2DeliveryExtensionImpl();
    }

    @Override
    public PromotionExtension getPromotionExtension() {
        return new Biz2PromotionExtensionImpl();
    }
}
