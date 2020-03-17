package com.helloxyy.top.demo.plugin.biz1.extension;

import com.helloxyy.top.demo.solution.delivery.DeliveryExtension;
import com.helloxyy.top.demo.solution.delivery.request.DeliveryRequest;

/**
 * Created by lihao on 17/12/13.
 *
 * @author lihao
 * @date 2020/3/17
 */
public class Biz1DeliveryExtensionImpl implements DeliveryExtension {

    public String getTransportMethod(DeliveryRequest item) {
        return item.getDeliveryName() + " Transport for  biz1";
    }

    public String getReceiveMethod(DeliveryRequest item) {
        return item.getDeliveryName() + " ReceiveMethod for  biz1";

    }
}
