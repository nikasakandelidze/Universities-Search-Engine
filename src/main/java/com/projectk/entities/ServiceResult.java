package com.projectk.entities;

import java.util.Map;

public class ServiceResult {
    private String viewName;
    private Map<String, Object> modelMap;

    private Object sessionUserAttribute;

    public ServiceResult(String viewName, Map<String, Object> modelMap) {
        this.viewName = viewName;
        this.modelMap = modelMap;
    }

    public ServiceResult(String viewName, Map<String, Object> modelMap, Object sessionUserAttribute) {
        this.viewName = viewName;
        this.modelMap = modelMap;
        this.sessionUserAttribute = sessionUserAttribute;
    }

    public Object getSessionUserAttribute() {
        return sessionUserAttribute;
    }

    public void setSessionUserAttribute(Object sessionUserAttribute) {
        this.sessionUserAttribute = sessionUserAttribute;
    }


    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, Object> getModelMap() {
        return modelMap;
    }

    public void setModelMap(Map<String, Object> modelMap) {
        this.modelMap = modelMap;
    }
}
