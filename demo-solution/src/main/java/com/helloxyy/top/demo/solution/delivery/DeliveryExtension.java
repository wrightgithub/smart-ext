package com.helloxyy.top.demo.solution.delivery;

import com.helloxyy.top.demo.solution.delivery.request.DeliveryRequest;
import com.helloxyy.top.smart.ext.core.api.ExtensionPoints;


public interface DeliveryExtension extends ExtensionPoints {

    String getTransportMethod(DeliveryRequest item);

    String getReceiveMethod(DeliveryRequest item);

}
