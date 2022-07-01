package it.bologna.ausl.masterchefclient;

import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */
public class StampaUnicaReporterParams extends JobParams {
    
private JSONObject jsonData;
private JSONArray reporterList;
private JSONArray allegatiList;

    public StampaUnicaReporterParams() {
        jsonData = new JSONObject();
        reporterList = new JSONArray();
        allegatiList = new JSONArray();
        jsonData.put("reporterList", reporterList);
        jsonData.put("allegati", allegatiList);
    }

    public StampaUnicaReporterParams(JSONObject jsonData) {
        this.jsonData = jsonData;
    }

    public StampaUnicaReporterParams(String savePath) {
        this();
        jsonData.put("savePath", savePath);
    }

    public void addReporter(String reportName, ReporterParams reporterParams) {
        addReporter(reportName, null, reporterParams);
    }

    public void addReporter(String reportName, String filePath, ReporterParams reporterParams) {
        JSONObject reporter = new JSONObject();
        if (filePath != null) {
            reporter.put("filePath", filePath);
        }
        reporter.put("reportName", reportName);
        reporter.put("reporterParams", reporterParams.getData());
        reporterList.add(reporter);
    }

    public void addAllegato(String uidAllegato) {
        allegatiList.add(uidAllegato);
    }

    public static StampaUnicaReporterParams parse(JSONObject params) {
        StampaUnicaReporterParams sup = new StampaUnicaReporterParams(params);
        return sup;
    }
    
    @Override
    public JSONObject getData() {
        return jsonData;
    }

    @Override
    public String getJobType() {
        return "StampaUnicaReporter";
    }

    @Override
    public String toString() {
        return jsonData.toJSONString();
    }
}
