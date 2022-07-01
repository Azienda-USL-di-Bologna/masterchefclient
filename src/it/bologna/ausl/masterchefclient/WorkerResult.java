package it.bologna.ausl.masterchefclient;

import it.bologna.ausl.masterchefclient.exceptions.MasterChefClientException;
import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */
public class WorkerResult {
private JSONObject res;

    public WorkerResult(JSONObject result) {
        res = result;
    }

    public String getJobType() {
        return (String) res.get("jobType");
    }

    public String getJobN() {
        return (String) res.get("jobN");
    }

    public String getBag() {
        return (String) res.get("bag");
    }

    public JobResult getRes() throws MasterChefClientException {
        try {
            JSONObject resJSON = (JSONObject) res.get("res");
            Class<JobResult> jobResultClass = (Class<JobResult>) Class.forName("it.bologna.ausl.masterchefclient." + getJobType() + "Result");
            Constructor<JobResult> jobResultConstructor = jobResultClass.getConstructor(JSONObject.class);
            JobResult jobResultInstance = jobResultConstructor.newInstance(resJSON);
            return jobResultInstance;
        }
        catch (Exception ex) {
            throw new MasterChefClientException("Errore nel reperimento del risultato del job", ex);
        } 
    }
    
    @Override
    public String toString() {
        return res.toJSONString();
    }
}