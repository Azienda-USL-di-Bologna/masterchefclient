package it.bologna.ausl.masterchefclient;

import org.json.simple.JSONObject;

/**
 *
 * @author utente
 */

/*
OUTPUT
{
    "res": "status":"success|error",
    "id_pubblicazione":"id_pubblicazione"
} 
*/
public class AlboTrasparenzaResult extends JobResult {
//private JSONObject res;

    public AlboTrasparenzaResult(JSONObject alboTrasparenzaResult) {
        res = alboTrasparenzaResult;
    }

    public String getStatus() {
        return (String) res.get("status");
    }

    public String getIdPubblicazione() {
        return (String) res.get("id_pubblicazione");
    }
    
    @Override
    public String toString() {
        return res.toJSONString();
    }
}
