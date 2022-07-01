package it.bologna.ausl.primuscommanderclient;

import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */

public class PrimusCommand {
    protected final JSONObject json;

    public PrimusCommand(PrimusCommandParams params) {
        json = new JSONObject();
        json.put("command", params.getCommand());
        json.put("params", params.getJSON());
    }
    
    public JSONObject getJSON() {
        return json;
    }
}
