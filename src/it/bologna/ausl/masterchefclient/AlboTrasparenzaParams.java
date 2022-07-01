package it.bologna.ausl.masterchefclient;

import org.json.simple.JSONObject;
/**
 *
 * @author utente
 */
public class AlboTrasparenzaParams extends JobParams {

/*
 "params": {
 "idDoc": "idDoc",
 "articolazione": "articolazione",
 "oggettoPub": "oggettoPub",
 "registro": "registro",
 "numero": "numero",
 "dataDoc": "dataDoc",
 "dataEsecutivita": "dataEsecutivita",
 "dataAdozione": "dataAdozione",
 "validita": "validita",
 "anno": "anno",
 "tipoProvvedimento":"tipoProvvedimento", 
 "contenuto":"contenuto", 
 "eventualeSpesaPrevista":"eventualeSpesaPrevista", 
 "estremiDocumentiRelativi":"estremiDocumentiRelativi",
 }
*/
    
private final JSONObject jsonData;


    public AlboTrasparenzaParams(JSONObject jsonData) {
        this.jsonData = jsonData;
    }

    public AlboTrasparenzaParams(String idDoc, String articolazione, String oggettoPub, 
            String registro, String numero, String dataDoc, String dataEsecutivita, 
            String dataAdozione, String validita, String anno, String tipoProvvedimento, 
            String contenuto, String eventualeSpesaPrevista, String estremiDocumentiRelativi) {
        jsonData = new JSONObject();
        jsonData.put("idDoc", idDoc);
        jsonData.put("articolazione", articolazione);
        jsonData.put("oggettoPub", oggettoPub);
        jsonData.put("numRegistro", numero);
        jsonData.put("registro", registro);
        jsonData.put("numero", numero);
        jsonData.put("dataDoc", dataDoc);
        jsonData.put("dataEsecutivita", dataEsecutivita);
        jsonData.put("dataAdozione", dataAdozione);
        jsonData.put("validita", validita);
        jsonData.put("anno", anno);
        jsonData.put("tipoProvvedimento", tipoProvvedimento);
        jsonData.put("contenuto", contenuto);
        jsonData.put("eventualeSpesaPrevista", eventualeSpesaPrevista);
        jsonData.put("estremiDocumentiRelativi", estremiDocumentiRelativi);        
    }
    
    public void setNumero(String numero) {
        jsonData.put("numero", numero);
        jsonData.put("numRegistro", numero);
    }
    
    public String getTipoProvvedimento(){
        return (String)jsonData.get("tipoProvvedimento");
    }
    
    public void setTipoProvvedimento(String tipoProvvedimento){
        jsonData.put("tipoProvvedimento", tipoProvvedimento);
    }
    
    public String getContenuto(){
        return (String)jsonData.get("contenuto");
    }
    
    public void setContenuto(String contenuto){
        jsonData.put("contenuto", contenuto);
    }
    
    public String getEventualeSpesaPrevista(){
        return (String)jsonData.get("eventualeSpesaPrevista");
    }
    
    public void setEventualeSpesaPrevista(String eventualeSpesaPrevista){
        jsonData.put("eventualeSpesaPrevista", eventualeSpesaPrevista);
    }
    
    public String getEstremiDocumentiRelativi(){
        return (String)jsonData.get("estremiDocumentiRelativi");
    }
    
    public void setEstremiDocumentiRelativi(String estremiDocumentiRelativi){
        jsonData.put("estremiDocumentiRelativi", estremiDocumentiRelativi);
    }

    public static AlboTrasparenzaParams parse(JSONObject params) {
        AlboTrasparenzaParams ap = new AlboTrasparenzaParams(params);
        return ap;
    }
    
    @Override
    public JSONObject getData() {
        return jsonData;
    }

    @Override
    public String getJobType() {
        return "AlboTrasparenza";
    }
    
    @Override
    public String toString() {
        return jsonData.toJSONString();
    }
}
