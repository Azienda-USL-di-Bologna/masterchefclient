package it.bologna.ausl.masterchefclient;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author utente
 */
public class SendToParerParams extends JobParams{

    private final JSONObject jsonData;
    private JSONArray identityFiles;
    
    public SendToParerParams(JSONObject jsonData) {
        this.jsonData = jsonData;
    }
    
     public SendToParerParams(String xmlDocument, String command) {
        jsonData = new JSONObject();
        identityFiles = new JSONArray();
        
        jsonData.put("xmlDocument", xmlDocument);
        jsonData.put("command", command);
        jsonData.put("identityFiles", identityFiles);
        
    }
     
    public void addIdentityFile(JSONObject identityFile) {
        identityFiles.add(identityFile);
    }
    
    public String getXmlDocument() {
        return (String) jsonData.get("xmlDocument");
    }
    
    public String getCommand() {
        return (String) jsonData.get("command");
    }
    
    public static SendToParerParams parse(JSONObject params) {
        SendToParerParams sdp = new SendToParerParams(params);
        return sdp;
    }
    
    
    @Override
    public JSONObject getData() {
        return jsonData;
    }

    @Override
    public String getJobType() {
        return "SendToParer";
    }
    
    @Override
    public String toString() {
        return jsonData.toJSONString();
    }
    
}
