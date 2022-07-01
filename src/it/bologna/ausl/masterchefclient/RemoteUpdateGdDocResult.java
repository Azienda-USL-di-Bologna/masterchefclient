package it.bologna.ausl.masterchefclient;

import org.json.simple.JSONObject;
/**
 *
 * @author Giuseppe De Marco (gdm)
 */
public class RemoteUpdateGdDocResult extends JobResult {
    
    public RemoteUpdateGdDocResult(JSONObject updateGdDocResult) {
        res = updateGdDocResult;
    }
}
