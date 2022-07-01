package it.bologna.ausl.masterchefclient;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */
public class AlboParams extends JobParams {

/*
    "params": {
      "idDoc": "idDoc",
      "tipoDocumento": "tipoDocumento",
      "strutturaPubblicante": "strutturaPubblicante",
      "articolazione": "articolazione",
      "oggettoPub": "oggettoPub",
      "numRegistro": "numero",
      "registro": "registro",
      "numero": "numero",
      "dataDoc": "dataDoc",
      "dataEsecutivita": "dataEsecutivita",
      "dataAdozione": "dataAdozione",
      "validita": "validita",
      "dal": "dal",
      "al": "al",
      "anno": "anno",
      "tipoProvvedimento":"tipoProvvedimento", 
      "contenuto":"contenuto", 
      "eventualeSpesaPrevista":"eventualeSpesaPrevista", 
      "estremiDocumentiRelativi":"estremiDocumentiRelativi",
      "nomeMongoRelataTemplate": "REGNUM_ANNO_Relata_[id_pubblicazione].pdf"
      "allegati": [
        "uidAllegato1",
        "uidAllegato2",
        ...
      ],
      "ops": [ {
        "op": "INTEGRA/ANNULLA",
        "ldoc": "idDoc da integrare/annullare"
      },
      ...
      ]
    }
*/
    
private final JSONObject jsonData;
private JSONArray opsList;
private JSONArray allegatiList;
public enum OpTypes {INTEGRA, ANNULLA};

    public AlboParams(JSONObject jsonData) {
        this.jsonData = jsonData;
    }

    public AlboParams(String idDoc, String tipoDocumento, String strutturaPubblicante, String articolazione, 
                      String oggettoPub, String registro, String numero, String dataDoc, 
                      String dataEsecutivita, String dataAdozione, String validita, String dal, String al, 
                      String anno, String tipoProvvedimento, String contenuto, String eventualeSpesaPrevista, 
                      String estremiDocumentiRelativi, String nomeMongoRelataTemplate) {
        jsonData = new JSONObject();
        jsonData.put("idDoc", idDoc);
        jsonData.put("tipoDocumento", tipoDocumento);
        jsonData.put("strutturaPubblicante", strutturaPubblicante);
        jsonData.put("articolazione", articolazione);
        jsonData.put("oggettoPub", oggettoPub);
        jsonData.put("numRegistro", numero);
        jsonData.put("registro", registro);
        jsonData.put("numero", numero);
        jsonData.put("dataDoc", dataDoc);
        jsonData.put("dataEsecutivita", dataEsecutivita);
        jsonData.put("dataAdozione", dataAdozione);
        jsonData.put("validita", validita);
        jsonData.put("dal", dal);
        jsonData.put("al", al);
        jsonData.put("anno", anno);
        jsonData.put("tipoProvvedimento", tipoProvvedimento);
        jsonData.put("contenuto", contenuto);
        jsonData.put("eventualeSpesaPrevista", eventualeSpesaPrevista);
        jsonData.put("estremiDocumentiRelativi", estremiDocumentiRelativi);
        
        allegatiList = new JSONArray();
        opsList  =new JSONArray();
        jsonData.put("allegati", allegatiList);
        jsonData.put("ops", opsList);
    }
    
    public void setNumero(String numero) {
        jsonData.put("numero", numero);
        jsonData.put("numRegistro", numero);
    }

    public void addOp(OpTypes operation, JSONArray docs) {
        JSONObject op = new JSONObject();
        op.put("op", operation.name().toLowerCase());
        op.put("ldoc", docs);
        opsList.add(op);
    }

    public void addAllegato(String uidAllegato) {
        allegatiList.add(uidAllegato);
    }
    
    public String getDal() {
        return (String) jsonData.get("dal");
    }
    
    public String getAl() {
        return (String) jsonData.get("al");
    }
    
    public String getNomeMongoRelataTemplate() {
        return (String) jsonData.get("nomeMongoRelata");
    }
    
    public void setNomeMongoRelataTemplate(String nomeMongoRelataTemplate) {
        jsonData.put("nomeMongoRelataTemplate", nomeMongoRelataTemplate);
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
    
    
    public static AlboParams parse(JSONObject params) {
        AlboParams ap = new AlboParams(params);
        return ap;
    }
    
    @Override
    public JSONObject getData() {
        return jsonData;
    }

    @Override
    public String getJobType() {
        return "Albo";
    }
    
    @Override
    public String toString() {
        return jsonData.toJSONString();
    }
}
