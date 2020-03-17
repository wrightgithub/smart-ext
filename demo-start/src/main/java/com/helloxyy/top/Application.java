package com.helloxyy.top;

import com.helloxyy.top.demo.solution.delivery.DeliveryExtension;
import com.helloxyy.top.demo.solution.delivery.request.DeliveryRequest;
import com.helloxyy.top.demo.solution.promotion.PromotionExtension;
import com.helloxyy.top.demo.solution.promotion.request.PromotionRequest;
import com.helloxyy.top.smart.ext.core.ExtensionInvoker;
import com.helloxyy.top.smart.ext.core.ExtensionMappingBuilder;

/**
 * Created by lihao on 17/12/13.
 *
 * @author lihao
 * @date 2020/3/17
 */
public class Application {

    public static void main(String[] args) {

        runWithFacade();
    }

    private static void runWithFacade() {

        //构建扩展点接口与业务实现之间的关系。
        ExtensionMappingBuilder.getInstance().init("com.helloxyy.top.demo.solution", "com.helloxyy.top.demo.plugin");

        DeliveryRequest deliveryRequest = new DeliveryRequest();
        deliveryRequest.setDeliveryName("大促物流");
        deliveryRequest.setBizCode("biz1");

        ExtensionInvoker<DeliveryExtension> invoker = new ExtensionInvoker<>(DeliveryExtension.class);
        String transportMethod = invoker.execute(deliveryRequest, p -> p.getTransportMethod(deliveryRequest));
        String receiveMethod = invoker.execute(deliveryRequest, p -> p.getReceiveMethod(deliveryRequest));

        System.out.println("transportMethod = " + transportMethod);
        System.out.println("receiveMethod = " + receiveMethod);

        ExtensionInvoker<PromotionExtension> invoker2 = new ExtensionInvoker<>(PromotionExtension.class);
        PromotionRequest promotionRequest = new PromotionRequest();
        promotionRequest.setBizCode("biz2");
        Long discount = invoker2.execute(promotionRequest, p -> p.getDiscount(promotionRequest));

        System.out.println("discount = " + discount);

    }

}

