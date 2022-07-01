package it.bologna.ausl.masterchefclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.bologna.ausl.masterchefclient.errors.ErrorDetails;
import it.bologna.ausl.masterchefclient.exceptions.MasterChefClientException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */
public class WorkerResponse {
private JSONObject jsonResult;
private JSONArray resultsList;
private String jobID;
private String appID;
private String jobType;
private String jobN;
private String status;
private String error;
private ErrorDetails errorDetails;
    
    public WorkerResponse(String result) throws MasterChefClientException {
        jsonResult = (JSONObject) JSONValue.parse(result);
        if (jsonResult == null) {
            throw new MasterChefClientException("Impossibile parsare la stringa. Forse non e' una \"MasterChef response\" ?");
        }
        appID = (String) jsonResult.get("appID");
        jobID = (String) jsonResult.get("jobID");
        jobType = (String) jsonResult.get("jobType");
        jobN = (String) jsonResult.get("jobN");
        status = (String) jsonResult.get("status");
        error = (String) jsonResult.get("error");
        String errorDetailsJson = (String)jsonResult.get("errorDetails");
        if (errorDetailsJson != null && !errorDetailsJson.equals("")) {
            try {
                errorDetails = (ErrorDetails) new ObjectMapper().readValue(errorDetailsJson, Class.forName("it.bologna.ausl.masterchefclient.errors." + jobType + "ErrorDetails"));
            }
            catch (Exception ex) {
            }
        }
        if (jsonResult != null)
            resultsList = (JSONArray) jsonResult.get("results");
    }

    public int getResultSize() {
        return resultsList.size();
    }
    
    public WorkerResult getResult(int resIndex) {
        JSONObject res = (JSONObject) resultsList.get(resIndex);
        return new WorkerResult(res);
    }

    public String getAppID() {
        return appID;
    }

    public String getJobID() {
        return jobID;
    }

    public String getJobN() {
        return jobN;
    }

    /**
     * normalmente il getJobType si dovrebbe fare sul WorkerResult, ma se c'è un errore il WorkerResult non c'è e quindi si può ottenere dal WorkerResponse
     * @return 
     */
    public String getJobType() {
        return jobType;
    }

    public String getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public ErrorDetails getErrorDetails() {
        return errorDetails;
    }

    @Override
    public String toString() {
        return jsonResult.toJSONString();
    }
}