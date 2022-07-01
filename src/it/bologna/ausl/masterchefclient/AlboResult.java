package it.bologna.ausl.masterchefclient;

import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */

/*
OUTPUT
{
    "res": "status":"success|error",
    "url_relata":"url_relata",
    "id_pubblicazione":"id_pubblicazione",
    "uuidRelata":"uuidRelata",
    "dal":"dal",
    "al":"al"
} 
*/
public class AlboResult extends JobResult {
//private JSONObject res;

    public AlboResult(JSONObject alboResult) {
        res = alboResult;
    }

    public String getStatus() {
        return (String) res.get("status");
    }

    public String getUuidRelata() {
        return (String) res.get("uuidRelata");
    }

    public String getUrlRelata() {
        return (String) res.get("url_relata");
    }

    public String getIdPubblicazione() {
        return (String) res.get("id_pubblicazione");
    }
    
    public String getDal() {
        return (String) res.get("dal");
    }
        
    public String getAl() {
        return (String) res.get("al");
    }

    @Override
    public String toString() {
        return res.toJSONString();
    }
}
