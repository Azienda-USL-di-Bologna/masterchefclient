package it.bologna.ausl.masterchefclient;

import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */
public abstract class JobParams {
    public abstract JSONObject getData();
    public abstract String getJobType();
}
