package com.helloxyy.top.smart.ext.core;

import com.helloxyy.top.smart.ext.core.api.BizInstance;
import com.helloxyy.top.smart.ext.core.api.ExtensionCallback;

public class ExtensionInvoker<Ext> {

    private Class<Ext> extClass;

    public ExtensionInvoker(Class<Ext> extClass) {
        this.extClass = extClass;
    }

    public <T extends BizInstance, R> R execute(T request, ExtensionCallback<Ext, R> callback) {

        String bizCode = request.getBizCode();

        Ext point = ExtensionMappingBuilder
            .getInstance()
            .getExtPoint(this.extClass, bizCode);

        return callback.apply(point);

    }
}
