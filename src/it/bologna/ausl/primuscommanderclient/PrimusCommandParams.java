package it.bologna.ausl.primuscommanderclient;

import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */
public abstract class PrimusCommandParams {
    protected final JSONObject json;

    public PrimusCommandParams() {
        json = new JSONObject();
    }
    
    public final JSONObject getJSON() {
        return json;
    }
    
    public abstract String getCommand();
}
