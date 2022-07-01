package it.bologna.ausl.masterchefclient;

import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */

/*
INPUT
{
    'user': username
    'query': query
}
*/
public class ExecuteSqlParams extends JobParams {
private JSONObject jsonData;

    public ExecuteSqlParams(JSONObject jsonData) {
        this.jsonData = jsonData;
    }

    public ExecuteSqlParams(String user, String query) {
        jsonData = new JSONObject();
        jsonData.put("user", user);
        jsonData.put("query", query);
    }

    public static ExecuteSqlParams parse(JSONObject params) {
        ExecuteSqlParams esp = new ExecuteSqlParams(params);
        return esp;
    }
    
    @Override
    public JSONObject getData() {
        return jsonData;
    }

    @Override
    public String getJobType() {
        return "ExecuteSql";
    }

    @Override
    public String toString() {
        return jsonData.toJSONString();
    }
}
