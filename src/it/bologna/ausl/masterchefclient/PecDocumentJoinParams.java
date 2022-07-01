package it.bologna.ausl.masterchefclient;

import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */

/*
INPUT
{
     'user': username
     'id_pec_message': id_pec_message
     'guid_documento': guid_documento
     'oggetto': oggetto
     'numero_documento': numero_documento
     'descrizione': descrizione
}
*/
public class PecDocumentJoinParams extends JobParams {
    private JSONObject jsonData;


    public enum TipoOperazione{
        INSERT, UPDATE, DELETE
    };

    public PecDocumentJoinParams(JSONObject jsonData) {
        this.jsonData = jsonData;
    }

    
    
    public PecDocumentJoinParams(String user, String idPecMessage, String guidDocumento, String oggetto, String numeroDocumento, String descrizione, String allegatiAccettati, String allegatiScartati, String tipoDocumento, TipoOperazione tipoOperazione) {
        
                
        jsonData = new JSONObject();
        jsonData.put("user", user);
        jsonData.put("id_pec_message", idPecMessage);
        jsonData.put("guid_documento", guidDocumento);
        jsonData.put("numero_documento", numeroDocumento);
        jsonData.put("tipo_operazione", tipoOperazione.name());
        
        if(oggetto!=null){
            jsonData.put("oggetto", oggetto);        
        }
        if(descrizione!=null){
            jsonData.put("descrizione", descrizione);
        }
        if(allegatiAccettati!=null){
            jsonData.put("allegati_accettati", allegatiAccettati);
        }
        if(allegatiScartati!=null){
            jsonData.put("allegati_scartati", allegatiScartati);
        }
        if(tipoDocumento!=null){
            jsonData.put("tipo_documento", tipoDocumento);
        }
    
    }
    
    public static PecDocumentJoinParams parse(JSONObject params) {
        PecDocumentJoinParams pdjp = new PecDocumentJoinParams(params);
        return pdjp;
    }

    @Override
    public JSONObject getData() {
        return jsonData;
    }

    @Override
    public String getJobType() {
        return "PecDocumentJoin";
    }

    @Override
    public String toString() {
        return jsonData.toJSONString();
    }
}
