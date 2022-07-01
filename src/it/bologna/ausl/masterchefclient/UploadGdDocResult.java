package it.bologna.ausl.masterchefclient;

import org.json.simple.JSONObject;
/**
 *
 * @author Giuseppe De Marco (gdm)
 */
public class UploadGdDocResult extends JobResult {
    
    public UploadGdDocResult(JSONObject uploadGdDocResult) {
        res = uploadGdDocResult;
    }
}
