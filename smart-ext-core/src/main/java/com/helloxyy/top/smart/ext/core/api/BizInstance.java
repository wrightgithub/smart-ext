package com.helloxyy.top.smart.ext.core.api;

/**
 * 业务身份
 *
 * @author yuyunxu
 */
public abstract class BizInstance {

    private String bizCode;

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getBizCode() {
        return bizCode;
    }
}
