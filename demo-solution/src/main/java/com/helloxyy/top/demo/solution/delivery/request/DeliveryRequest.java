package com.helloxyy.top.demo.solution.delivery.request;

import com.helloxyy.top.smart.ext.core.api.BizInstance;

/**
 * Created by lihao on 17/12/13.
 *
 * @author lihao
 * @date 2020/3/17
 */

public class DeliveryRequest extends BizInstance {

    private String deliveryName;

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }
}
