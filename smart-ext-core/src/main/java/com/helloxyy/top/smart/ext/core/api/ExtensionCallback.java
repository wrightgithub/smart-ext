package com.helloxyy.top.smart.ext.core.api;

/**
 * User: kuhe
 * Date: 2017/7/7
 * Time: PM3:39
 */
public interface ExtensionCallback<Ext, R> {

    R apply(Ext ext);

}
