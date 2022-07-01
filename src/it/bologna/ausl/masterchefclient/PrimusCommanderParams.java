package it.bologna.ausl.masterchefclient;

import it.bologna.ausl.primuscommanderclient.PrimusMessage;
import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */

/**
INPUT
{
    "command": {
        "dest":["username"],
        "dest_app":"babel",
        "command": {
            "command":"showMessage",
            "params":{"foo":"bar"}
        }
    }
    "interval":"2000"
    "times": "1" // passare "0" per infinito
}
*/
public class PrimusCommanderParams extends JobParams {
private final JSONObject jsonData;

    public PrimusCommanderParams(JSONObject jsonData) {
        this.jsonData = jsonData;
    }

    public PrimusCommanderParams(String interval, String times, PrimusMessage command) {
        jsonData = new JSONObject();
        jsonData.put("interval", interval);
        jsonData.put("times", times);
        jsonData.put("command", command.getJSON());
    }
    
    public PrimusCommanderParams(String id, String interval, String times, PrimusMessage command) {
        jsonData = new JSONObject();
        jsonData.put("id", id);
        jsonData.put("interval", interval);
        jsonData.put("times", times);
        jsonData.put("command", command.getJSON());
    }

    public static PrimusCommanderParams parse(JSONObject params) {
        PrimusCommanderParams esp = new PrimusCommanderParams(params);
        return esp;
    }
    
    @Override
    public JSONObject getData() {
        return jsonData;
    }

    @Override
    public String getJobType() {
        return "PrimusCommander";
    }

    @Override
    public String toString() {
        return jsonData.toJSONString();
    }
}
