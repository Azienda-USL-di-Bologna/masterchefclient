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
public class PrimusCommanderResult extends JobResult {

    public PrimusCommanderResult(JSONObject primusCommanderResult) {
        res = primusCommanderResult;
    }
}
