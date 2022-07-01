package it.bologna.ausl.masterchefclient;

import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */
public class StampaUnicaJasperParams extends JobParams {
    
private JSONObject jsonData;
private JSONArray jasperList;
private JSONArray allegatiList;

    public StampaUnicaJasperParams() {
        jsonData = new JSONObject();
        jasperList = new JSONArray();
        allegatiList = new JSONArray();
        jsonData.put("jasperList", jasperList);
        jsonData.put("allegati", allegatiList);
    }

    public StampaUnicaJasperParams(JSONObject jsonData) {
        this.jsonData = jsonData;
    }
    
    
    public StampaUnicaJasperParams(String savePath) {
        this();
        jsonData.put("savePath", savePath);
    }

    public void addJasper(String reportName, JasperParams jasperParams) {
        addJasper(reportName, null, jasperParams);
    }

    public void addJasper(String reportName, String filePath, JasperParams jasperParams) {
        JSONObject jasper = new JSONObject();
        if (filePath != null) {
            jasper.put("filePath", filePath);
        }
        jasper.put("reportName", reportName);
        jasper.put("jasperParams", jasperParams.getData());
        jasperList.add(jasper);
    }

    public void addAllegato(String uidAllegato) {
        allegatiList.add(uidAllegato);
    }

    public static StampaUnicaJasperParams parse(JSONObject params) {
        StampaUnicaJasperParams sup = new StampaUnicaJasperParams(params);
        return sup;
    }
    
    @Override
    public JSONObject getData() {
        return jsonData;
    }

    @Override
    public String getJobType() {
        return "StampaUnicaJasper";
    }

    @Override
    public String toString() {
        return jsonData.toJSONString();
    }
}
