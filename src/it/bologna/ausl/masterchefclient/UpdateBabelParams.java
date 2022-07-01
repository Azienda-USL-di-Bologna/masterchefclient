package it.bologna.ausl.masterchefclient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */
@JsonTypeInfo(  
    use = JsonTypeInfo.Id.NAME,  
    include = JsonTypeInfo.As.PROPERTY,  
    property = "__CLASS_TYPE__")  
@JsonSubTypes({  
    @JsonSubTypes.Type(value = UpdateBabelParams.class, name = "UpdateBabelParams"),
})
public class UpdateBabelParams extends JobParams {

    public static final String INSERT = "insert";
    public static final String UPDATE = "update";
    public static final String DELETE = "delete";
    public static final String UPDATE_MULT = "update_mult";

    public static final String UPDATE_PER_ID_ESTERNO = "update_per_idesterno";
    public static final String UPDATE_PER_ID_ESTERNO_E_ID_UTENTE = "update_per_idesterno_e_idutente";
    public static final String UPDATE_PER_GRUPPO = "update_per_gruppo";
    public static final String UPDATE_PER_GRUPPO_E_ID_UTENTE = "update_per_gruppo_e_idutente";

    public static final String UPDATE_PER_ID_SORGENTE = "update_per_idsorgente";
    public static final String UPDATE_PER_ID_SORGENTE_E_ID_UTENTE = "update_per_idsorgente_e_idutente";

    public static final String DELETE_MULT = "delete_mult";

    public static final String DELETE_PER_ID_ESTERNO = "delete_per_idesterno";
    public static final String DELETE_PER_ID_ESTERNO_E_ID_UTENTE = "delete_per_idesterno_e_idutente";
    public static final String DELETE_PER_GRUPPO = "delete_per_gruppo";
    public static final String DELETE_PER_GRUPPO_E_ID_UTENTE = "delete_per_gruppo_e_idutente";

    public static final String DELETE_PER_ID_SORGENTE = "delete_per_idsorgente";
    public static final String DELETE_PER_ID_SORGENTE_E_ID_UTENTE = "delete_per_idsorgente_e_idutente";
    
    private JSONObject jsonData;
    private JSONArray listaAttivita;

    public UpdateBabelParams() {
    }

    public UpdateBabelParams(JSONObject jsonData) {
        this.jsonData = jsonData;
    }

    public UpdateBabelParams(String idApplicazione, String tokenApplicazione, String setAttivita, String archiviazione, String accessoEsclusivo, String actionType) {
        jsonData = new JSONObject();
        listaAttivita = new JSONArray();

        if (idApplicazione != null)
            jsonData.put("idApplicazione", idApplicazione);
        if (tokenApplicazione != null)
            jsonData.put("tokenApplicazione", tokenApplicazione);
        if (setAttivita != null)
            jsonData.put("setAttivita", setAttivita);
        if (archiviazione != null)
            jsonData.put("archiviazione", archiviazione);
        if (accessoEsclusivo != null)
            jsonData.put("accessoEsclusivo", accessoEsclusivo);
        if (actionType != null)
            jsonData.put("actionType", actionType);
        jsonData.put("listaAttivita", listaAttivita);
    }

    public void addAttivita(  
            String idAttivita, 
            String idEsterno, 
            String idUtenti, 
            String idTipiAttivita, 
            String descrizioneAttivita, 
            String oggettoAttivita, 
            String datain, 
            String provenienza, 
            String priorita,
            String labelUrlCommand, 
            String urlCommand, 
            String labelUrlCommand2, 
            String urlCommand2, 
            String labelUrlCommand3, 
            String urlCommand3, 
            String noteAttivita, 
            String uuidAnteprima, 
            String customApp1, 
            String customApp2, 
            String customApp3, 
            String customApp4, 
            String customApp5, 
            String permesso,
            String idSorgente, 
            String tipoSorgente,
            String idRiferimento, 
            String tipoRiferimento,
            String gruppo,
            String updateStorico,
            String statoattivita) {
    JSONObject attivita = new JSONObject();
        if (idAttivita != null)
            attivita.put("idattivita", idAttivita);
        if (idEsterno != null)
            attivita.put("idesterno", idEsterno);
        if (idUtenti != null)
            attivita.put("idutenti", idUtenti);
        if (idTipiAttivita != null)
            attivita.put("idtipiattivita", idTipiAttivita);
        if (descrizioneAttivita != null)
            attivita.put("descrizioneattivita", descrizioneAttivita);
        if (oggettoAttivita != null)
            attivita.put("oggettoattivita", oggettoAttivita);
        if (datain != null && !datain.equals(""))
            attivita.put("datain", datain);
        if (provenienza != null)
            attivita.put("provenienza", provenienza);
        if (priorita != null)
            attivita.put("priorita", priorita);
        if (labelUrlCommand != null)
            attivita.put("labelurlcommand", labelUrlCommand);
        if (urlCommand != null)
            attivita.put("urlcommand", urlCommand);
        if (labelUrlCommand2 != null)
            attivita.put("labelurlcommand2", labelUrlCommand2);
        if (urlCommand2 != null)
            attivita.put("urlcommand2", urlCommand2);
        if (labelUrlCommand3 != null)
            attivita.put("labelurlcommand3", labelUrlCommand3);
        if (urlCommand3 != null)
            attivita.put("urlcommand3", urlCommand3);
        if (noteAttivita != null)
            attivita.put("noteattivita", noteAttivita);
        if (uuidAnteprima != null)
            attivita.put("uuidanteprima", uuidAnteprima);
        if (customApp1 != null)
            attivita.put("customapp1", customApp1);
        if (customApp2 != null)
            attivita.put("customapp2", customApp2);
        if (customApp3 != null)
            attivita.put("customapp3", customApp3);
        if (customApp4 != null)
            attivita.put("customapp4", customApp4);
        if (customApp5 != null)
            attivita.put("customapp5", customApp5);
        if (permesso != null)
            attivita.put("permesso", permesso);
        if (idSorgente != null)
            attivita.put("idsorgente", idSorgente);
        if (tipoSorgente != null)
            attivita.put("tiposorgente", tipoSorgente);
        if (idRiferimento != null)
            attivita.put("idriferimento", idRiferimento);
        if (tipoRiferimento != null)
            attivita.put("tiporiferimento", tipoRiferimento);
        if (gruppo != null)
            attivita.put("gruppo", gruppo);
        if (updateStorico != null)
            attivita.put("updatestorico", updateStorico);
         if (statoattivita != null)
            attivita.put("statoattivita", statoattivita);
        listaAttivita.add(attivita);
    }

    public JSONObject getJsonData() {
        return jsonData;
    }

    public void setJsonData(JSONObject jsonData) {
        this.jsonData = jsonData;
    }

//    @JsonIgnore
    public JSONArray getListaAttivita() {
        return (JSONArray) jsonData.get("listaAttivita");
    }

//    @JsonIgnore
    public void setListaAttivita(JSONArray listaAttivita) {
        this.listaAttivita = listaAttivita;
        jsonData.put("listaAttivita", this.listaAttivita);
    }
    
    @JsonIgnore
    public String getIdApplicazione() {
        return (String) jsonData.get("idApplicazione");
    }
    
    @JsonIgnore
    public String getTokenApplicazione() {
        return (String) jsonData.get("tokenApplicazione");
    }
    
    @JsonIgnore
    public String getSetAttivita() {
        return (String) jsonData.get("setAttivita");
    }
    
    @JsonIgnore
    public String getArchiviazione() {
        return (String) jsonData.get("archiviazione");
    }
    
    @JsonIgnore
    public String getAccessoEsclusivo() {
        return (String) jsonData.get("accessoEsclusivo");
    }
    
    @JsonIgnore
    public String getActionType() {
        return (String) jsonData.get("actionType");
    }

    @JsonIgnore
    public void addAttivita(JSONObject attivita) {
        listaAttivita.add(attivita);
    }

    @JsonIgnore
    public int getNumberAttivita() {
        return listaAttivita.size();
    }

    @JsonIgnore
    public static UpdateBabelParams parse(JSONObject params) {
        UpdateBabelParams ubp = new UpdateBabelParams(params);
        return ubp;
    }

    @Override
    @JsonIgnore
    public JSONObject getData() {
        return getJsonData();
    }

    @Override
    @JsonIgnore
    public String getJobType() {
        return "UpdateBabel";
    }
//
//    @JsonIgnore
//    public String getJsonString() throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.registerModule(new JodaModule());
//        mapper.setTimeZone(TimeZone.getDefault());
//        String writeValueAsString = mapper.writeValueAsString(this);
//        return writeValueAsString;
//    }
    
    @Override
    public String toString() {
        return jsonData.toJSONString();
    }
}
