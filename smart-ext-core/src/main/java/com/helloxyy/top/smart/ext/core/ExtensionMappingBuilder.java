package com.helloxyy.top.smart.ext.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.helloxyy.top.smart.ext.core.api.BizCode;
import com.helloxyy.top.smart.ext.core.api.ExtensionFacade;
import com.helloxyy.top.smart.ext.core.api.ExtensionPoints;
import com.helloxyy.top.smart.ext.core.utils.Rebound;
import org.reflections.Reflections;

public class ExtensionMappingBuilder {

    private static ExtensionMappingBuilder builder = new ExtensionMappingBuilder();

    private ExtensionMappingBuilder() {
    }

    private Map<Class, Multimap<String, ExtensionPoints>> extMap
        = new HashMap<>();

    public void init(String platformPackage, String pluginPackage) {
        Reflections platformReflections = new Reflections(platformPackage);

        //find all the extension point classes
        Set<Class<? extends ExtensionPoints>> extPointClasses =
            platformReflections.getSubTypesOf(ExtensionPoints.class);

        //find all the business plugins which implements the extension point
        Reflections pluginPackageReflections=new Reflections(pluginPackage);
        Set<Class<? extends ExtensionFacade>> pluginFacades = pluginPackageReflections.getSubTypesOf(ExtensionFacade.class);
        //Rebound rebound = new Rebound(pluginPackage);
        //Set<Class<? extends ExtensionFacade>> pluginFacades = rebound.getSubClassesOf(ExtensionFacade.class);


        for (Class<? extends ExtensionPoints> pointClass : extPointClasses) {

            Multimap<String, ExtensionPoints> bizCodeExtMap = ArrayListMultimap.create();
            for (Class<? extends ExtensionFacade> facade : pluginFacades) {
                buildPluginMap(pointClass, facade, bizCodeExtMap);
            }
            extMap.put(pointClass, bizCodeExtMap);

        }

    }

    private void buildPluginMap(Class<? extends ExtensionPoints> pointClass,
        Class<? extends ExtensionFacade> facade,
        Multimap<String, ExtensionPoints> bizCodeExtMap) {

        BizCode[] annotationsByType = facade.getAnnotationsByType(BizCode.class);

        if (annotationsByType != null
            && annotationsByType.length > 0) {

            BizCode bizCode = annotationsByType[0];

            //build the biz code and associated extension implement map
            ExtensionPoints plugin = createExtInstance(facade, pointClass);

            bizCodeExtMap.put(bizCode.value(), plugin);
        }

    }

    private ExtensionPoints createExtInstance(Class<? extends ExtensionFacade> facade,
        Class<? extends ExtensionPoints> pointClass) {

        Object points = null;
        try {
            points = facade.newInstance();

            Method[] methods = facade.getDeclaredMethods();

            for (Method method : methods) {
                //find the method returns the extensionPoints object in the facade class
                if (pointClass.isAssignableFrom(method.getReturnType())) {
                    try {
                        return (ExtensionPoints)method.invoke(points);
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    public <Ext> Ext getExtPoint(Class<Ext> extClass,
        String bizCode) {

        //暂时先取第一个扩展实现
        return (Ext)extMap.get(extClass).get(bizCode).iterator().next();
    }

    public <Ext> List<Ext> getExtPoints(Class<Ext> extClass,
        String bizCode) {

        return null;
        //        return  extMap.get(extClass).get(bizCode);
    }

    public static ExtensionMappingBuilder getInstance() {
        return builder;
    }
}
