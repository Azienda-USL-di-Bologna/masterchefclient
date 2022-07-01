package it.bologna.ausl.masterchefclient;

import it.bologna.ausl.masterchefclient.utils.UtilityFunctions;
import java.io.File;
import java.io.IOException;
import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */
public class JasperParams extends JobParams {
private JSONObject jsonData;

    public JasperParams(JSONObject jsonData) {
        this.jsonData = jsonData;
    }

    public JasperParams(String templatePath, String data, String alignment) {
        jsonData = new JSONObject();
        jsonData.put("templatePath", templatePath);
        jsonData.put("data", data);
        jsonData.put("alignment", alignment);
    }
    
        public JasperParams(String templatePath, File data, String alignment) throws IOException {
        jsonData = new JSONObject();
        jsonData.put("templatePath", templatePath);
        jsonData.put("data", UtilityFunctions.readFileToString(data));
        jsonData.put("alignment", alignment);
    }
    
     public static JasperParams parse(JSONObject params) {
        JasperParams jp = new JasperParams(params);
        return jp;
    }    
        
    @Override
    public JSONObject getData() {
        return jsonData;
    }

    @Override
    public String getJobType() {
        return "Jasper";
    }

    @Override
    public String toString() {
        return jsonData.toJSONString();
    }
}
