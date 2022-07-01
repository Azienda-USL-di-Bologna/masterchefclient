package it.bologna.ausl.primuscommanderclient;

import java.util.List;
import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */

public class PrimusMessage {
    private final JSONObject json;
    public PrimusMessage(List users, String app, PrimusCommand command) {
        json = new JSONObject();
        //JSONArray usersArray = new JSONArray();
        json.put("dest", users);
        json.put("dest_app", app);
        json.put("command", command.getJSON());
    }
    
    public JSONObject getJSON() {
        return json;
    }
}
