package com.helloxyy.top.demo.plugin.biz2.extension;

import com.helloxyy.top.demo.solution.delivery.DeliveryExtension;
import com.helloxyy.top.demo.solution.delivery.request.DeliveryRequest;

/**
 * Created by lihao on 17/12/13.
 *
 * @author lihao
 * @date 2020/3/17
 */
public class Biz2DeliveryExtensionImpl implements DeliveryExtension {

    public String getTransportMethod(DeliveryRequest item) {
        return item.getDeliveryName() + " Transport for  biz2";
    }

    public String getReceiveMethod(DeliveryRequest item) {
        return item.getDeliveryName() + " ReceiveMethod for  biz2";

    }
}
