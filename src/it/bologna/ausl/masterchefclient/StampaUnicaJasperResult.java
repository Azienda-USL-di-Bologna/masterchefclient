package it.bologna.ausl.masterchefclient;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */
public class StampaUnicaJasperResult extends JobResult {
private final JSONArray jasperList;

    public StampaUnicaJasperResult(JSONObject stampaUnicaResult) {
        res = stampaUnicaResult;
        jasperList = (JSONArray) res.get("jasperList");
    }
    
    public String getPdf() {
        return (String) res.get("pdf");
    }
    
    public String getUUIDStampaUnica() {
        return (String) res.get("UUIDStampaUnica");
    }
    
    public long getSizeStampaUnica() {
        return (Long) res.get("size");
    }
    
    public int getJasperListSize() {
        return jasperList.size();
    }

    public String getJasperResultReportName(int index) {
        return (String) ((JSONObject)((JSONArray) res.get("jasperList")).get(index)).get("reportName");
    }

    public String getJasperResultFilePath(int index) {
        return (String) ((JSONObject)((JSONArray) res.get("jasperList")).get(index)).get("filePath");
    }
    
    public String getJasperResultUuid(int index) {
        return (String) ((JSONObject)((JSONArray) res.get("jasperList")).get(index)).get("uuid");
    }
    
    public long getJasperResultSize(int index) {
        return (Long) ((JSONObject)((JSONArray) res.get("jasperList")).get(index)).get("size");
    }
    
    @Override
    public String toString() {
        return res.toJSONString();
    }
}
