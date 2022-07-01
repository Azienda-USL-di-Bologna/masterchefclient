package it.bologna.ausl.masterchefclient;

import it.bologna.ausl.masterchefclient.utils.UtilityFunctions;
import it.bologna.ausl.tools.Base64Coder;
import java.io.*;
import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */
public class UploadGdDocParams extends JobParams {
    
    private final JSONObject jsonData;
    private JSONObject jsonFile;
    
    public UploadGdDocParams(JSONObject jsonData) {
        this.jsonData = jsonData;
    }
     
    public UploadGdDocParams(String idApplicazione, String tokenApplicazione, String idFascicolo){
        jsonData = new JSONObject();
        jsonFile = new JSONObject();
        
        if (idApplicazione != null)
            jsonData.put("idApplicazione", idApplicazione);
        if (tokenApplicazione != null)
            jsonData.put("tokenApplicazione", tokenApplicazione);
         if (idFascicolo != null)
            jsonData.put("idFascicolo", idFascicolo);
        
        jsonData.put("file", jsonFile);
    }
    
    public void addFile(String filename, byte[] file){
        if (filename != null)
            jsonFile.put("name", filename);
        if (file != null)
            jsonFile.put("value", Base64Coder.encodeLines(file));
    }
    
    public void addFile(File file) throws FileNotFoundException, IOException{
        addFile(file.getName(), new FileInputStream(file));
    }
     
    public void addFile(String filename, InputStream file) throws IOException{
        if(file != null){
            addFile(filename, UtilityFunctions.readInputStream(file));
        }
    } 
    
     public static UploadGdDocParams parse(JSONObject params) {
        UploadGdDocParams ubp = new UploadGdDocParams(params);
        return ubp;
    }
    
    @Override
    public JSONObject getData() {
        return jsonData;
    }

    @Override
    public String getJobType() {
        return "UploadGdDoc";
    }
    
}
