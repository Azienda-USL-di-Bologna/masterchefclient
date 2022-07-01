package it.bologna.ausl.masterchefclient;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */

/*
OUTPUT
{
    'result': "risultato query"
} 
    * Cose da ricordare: 
    * result contiene il risultato se la query lo ritorna
    * rusult contiene il numero di righe interessate se la query non ritorna nessun risultato
*/
public class ExecuteSqlResult extends JobResult {

    public ExecuteSqlResult(JSONObject executeSqlResult) {
        res = executeSqlResult;
    }
    
    public JSONArray getResult() {
        return (JSONArray) res.get("result");
    }
}
