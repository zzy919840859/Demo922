package com.csi.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MySessionListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session被添加了"+httpSessionBindingEvent.getName()+"---"+
                httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session进行了移除操作"+httpSessionBindingEvent.getName()+"---"+
                httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session被覆盖换了"+httpSessionBindingEvent.getName()+"---"+
                httpSessionBindingEvent.getValue());
    }
}
