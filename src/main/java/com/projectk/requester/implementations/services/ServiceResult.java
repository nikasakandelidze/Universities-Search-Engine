package com.projectk.requester.implementations.services;

import com.projectk.entities.University;

import java.util.List;
import java.util.Map;

public class ServiceResult {
    private String viewName;
    private Map<String, Object> modelMap;
    private List<Object> sessionUserAttributes;

    public ServiceResult(String viewName, Map<String, Object> modelMap) {
        this.viewName = viewName;
        this.modelMap = modelMap;
    }

    public ServiceResult(String viewName, Map<String, Object> modelMap, List<Object> sessionUserAttributes) {
        this.viewName = viewName;
        this.modelMap = modelMap;
        this.sessionUserAttributes = sessionUserAttributes;
    }

    public List<Object> getSessionUserAttribute() {
        return sessionUserAttributes;
    }

    public void setSessionUserAttribute(List<Object> sessionUserAttribute) {
        this.sessionUserAttributes = sessionUserAttributes;
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
