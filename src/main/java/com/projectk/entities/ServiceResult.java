package com.projectk.entities;

import com.projectk.entities.University;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ServiceResult {
    private String viewName;
    private Map<String, Object> modelMap;
    private Map<String, Object> sessionUserAttributes;

    public ServiceResult(String viewName, Map<String, Object> modelMap) {
        this.viewName = viewName;
        this.modelMap = modelMap;
    }

    public ServiceResult(String viewName, Map<String, Object> modelMap, Map<String, Object> sessionUserAttributes) {
        this.viewName = viewName;
        this.modelMap = modelMap;
        this.sessionUserAttributes = sessionUserAttributes;
    }

    public Map<String, Object> getSessionUserAttributes() {
        return sessionUserAttributes;
    }

    public void setSessionUserAttributes(Map<String, Object> sessionUserAttributes) {
        this.sessionUserAttributes = this.sessionUserAttributes;
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
