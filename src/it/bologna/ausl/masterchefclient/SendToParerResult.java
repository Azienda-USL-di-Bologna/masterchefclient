/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.bologna.ausl.masterchefclient;

import org.json.simple.JSONObject;

/**
 *
 * @author utente
 */
public class SendToParerResult extends JobResult{
    
    public SendToParerResult(JSONObject executeSqlResult) {
        res = executeSqlResult;
    }
   
    public String getParerResponse(){
        return (String) res.get("parerResponse");
    }
    
}
