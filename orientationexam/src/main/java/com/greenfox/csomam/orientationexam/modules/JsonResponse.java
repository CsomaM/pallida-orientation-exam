package com.greenfox.csomam.orientationexam.modules;

import java.util.List;

public class JsonResponse {

    String result;
    List<LicencePlate> data;

    public JsonResponse(String result, List<LicencePlate> data) {
        this.result = result;
        this.data = data;
    }

    public JsonResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<LicencePlate> getData() {
        return data;
    }

    public void setData(List<LicencePlate> data) {
        this.data = data;
    }
}
