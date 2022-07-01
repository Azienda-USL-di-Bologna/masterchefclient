package it.bologna.ausl.masterchefclient;

import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */
public class ReporterParams extends JobParams {
    private final JSONObject jsonData;

    public ReporterParams(JSONObject jsonData) {
        this.jsonData = jsonData;
    }
    
    public ReporterParams(String templatePath, JSONObject data) {
        jsonData = new JSONObject();
        jsonData.put("templatePath", templatePath);
        jsonData.put("data", data);
    }
    
    public ReporterParams(String templateName, String templatePath, JSONObject data) {
        jsonData = new JSONObject();
        jsonData.put("templateName", templateName);
        jsonData.put("templatePath", templatePath);
        jsonData.put("data", data);
    }
    
    public ReporterParams(String templatePath, JSONObject data, String qrCodeFieldName, String qrCodeValue) {
        jsonData = new JSONObject();
        jsonData.put("templatePath", templatePath);
        jsonData.put("data", data);
        JSONObject qrCodeData = new JSONObject();
        qrCodeData.put("fieldName", qrCodeFieldName);
        qrCodeData.put("value", qrCodeValue);
        jsonData.put("qrCodeData", qrCodeData);
    }
    
    public ReporterParams(String templateName, String templatePath, JSONObject data, String qrCodeFieldName, String qrCodeValue) {
        jsonData = new JSONObject();
        jsonData.put("templateName", templateName);
        jsonData.put("templatePath", templatePath);
        jsonData.put("data", data);
        JSONObject qrCodeData = new JSONObject();
        qrCodeData.put("fieldName", qrCodeFieldName);
        qrCodeData.put("value", qrCodeValue);
        jsonData.put("qrCodeData", qrCodeData);
    }
    
     public static ReporterParams parse(JSONObject params) {
        ReporterParams rp = new ReporterParams(params);
        return rp;
    }    
        
    @Override
    public JSONObject getData() {
        return jsonData;
    }

    @Override
    public String getJobType() {
        return "Reporter";
    }

    @Override
    public String toString() {
        return jsonData.toJSONString();
    }
}
