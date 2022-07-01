package it.bologna.ausl.masterchefclient;

import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */

/*
OUTPUT
{
} 
*/
public class UpdateBabelResult extends JobResult {

    public UpdateBabelResult(JSONObject updateBabelResult) {
        res = updateBabelResult;
    }
}
