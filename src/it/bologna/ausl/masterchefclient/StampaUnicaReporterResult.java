package it.bologna.ausl.masterchefclient;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */
public class StampaUnicaReporterResult extends JobResult {
private final JSONArray reporterList;

    public StampaUnicaReporterResult(JSONObject stampaUnicaResult) {
        res = stampaUnicaResult;
        reporterList = (JSONArray) res.get("reporterList");
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
    
    public int getReporterListSize() {
        return reporterList.size();
    }
    
    public String getReporterResultReportName(int index) {
        return (String) ((JSONObject)((JSONArray) res.get("reporterList")).get(index)).get("reportName");
    }
    
    public String getReporterResultFilePath(int index) {
        return (String) ((JSONObject)((JSONArray) res.get("reporterList")).get(index)).get("filePath");
    }
    
    public String getReporterResultUuid(int index) {
        return (String) ((JSONObject)((JSONArray) res.get("reporterList")).get(index)).get("uuid");
    }
    
    public long getReporterResultSize(int index) {
        return (Long) ((JSONObject)((JSONArray) res.get("reporterList")).get(index)).get("size");
    }
    
    @Override
    public String toString() {
        return res.toJSONString();
    }
}
