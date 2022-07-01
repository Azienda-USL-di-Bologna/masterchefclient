package it.bologna.ausl.masterchefclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.bologna.ausl.ioda.iodaobjectlibrary.Document.DocumentOperationType;
import it.bologna.ausl.ioda.iodaobjectlibrary.IodaRequestDescriptor;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */
public class RemoteUpdateGdDocParams extends JobParams {

    private final JSONObject jsonData;

    public RemoteUpdateGdDocParams(JSONObject jsonData) {
        this.jsonData = jsonData;
    }

    public RemoteUpdateGdDocParams(IodaRequestDescriptor iodaRequestDescriptor, DocumentOperationType operation) throws JsonProcessingException {
        jsonData = new JSONObject();
        jsonData.put("tipoOperazione", operation.getKey());
        jsonData.put("requestDescriptor", (JSONObject) JSONValue.parse(iodaRequestDescriptor.getJSONString()));
    }

    public static RemoteUpdateGdDocParams parse(JSONObject params) {
        RemoteUpdateGdDocParams updateGdDocPar = new RemoteUpdateGdDocParams(params);
        return updateGdDocPar;
    }

    @Override
    public JSONObject getData() {
        return jsonData;
    }

    @Override
    public String getJobType() {
        return "RemoteUpdateGdDoc";
    }

}
