package it.bologna.ausl.masterchefclient;

import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */
public class JasperResult extends JobResult {

    public JasperResult(JSONObject jaspeResult) {
        res = jaspeResult;
    }
    
    public String getPdf() {
        return (String) res.get("pdf");
    }
    
    @Override
    public String toString() {
        return res.toJSONString();
    }
}
