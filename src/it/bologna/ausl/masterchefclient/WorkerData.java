package it.bologna.ausl.masterchefclient;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */
public class WorkerData {
private JSONObject jsonData;
private JSONArray jobList;
    
    public WorkerData(String appID, String jobID, String returnQueue) {
        jsonData = new JSONObject();
        jobList = new JSONArray();
        jsonData.put("appID", appID);
        jsonData.put("jobID", jobID);
        jsonData.put("returnQueue", returnQueue);
        jsonData.put("jobList", jobList);
    }
    
    public WorkerData(String appID, String jobID, String returnQueue, long returnQueueTimeout) {
        jsonData = new JSONObject();
        jobList = new JSONArray();
        jsonData.put("appID", appID);
        jsonData.put("jobID", jobID);
        jsonData.put("returnQueue", returnQueue);
        jsonData.put("returnQueueTimeout", returnQueueTimeout);
        jsonData.put("jobList", jobList);
    }
    
    public void addNewJob(String jobN, String bag, JobParams jobParams) {
        addNewJob(jobParams.getJobType(), jobN, bag, jobParams.getData());
    }
    
    public void addNewJob(String jobType, String jobN, String bag, JSONObject jobParams) {
        JSONObject job = new JSONObject();
        job.put("jobType", jobType);
        job.put("jobN", jobN);
        job.put("bag", bag);
        job.put("params", jobParams);
        jobList.add(job);
    }
    
    public String getStringForRedis() {
        return toString();
    }
    
    @Override
    public String toString() {
        return jsonData.toJSONString();
    }
}
