package it.bologna.ausl.masterchefclient;

import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */
public class ReporterResult extends JobResult {

    public ReporterResult(JSONObject reporterResult) {
        res = reporterResult;
    }
    
    public String getPdf() {
        return (String) res.get("pdf");
    }
    
    @Override
    public String toString() {
        return res.toJSONString();
    }
}
