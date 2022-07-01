package it.bologna.ausl.masterchefclient;

import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */

/*
OUTPUT
{
    'pdf': "convertedFileBase64"
    'uuidConvertedFile' : "uuidConvertedFile"
} 
    * Cose da ricordare: 
    * ritorna sempre il file convertito in base64
    * se è stato passato il parametro 'convertedFilePath' torna l'uuid su mongo del file convertito

*/

public class PdfConvertResult extends JobResult {

    public PdfConvertResult(JSONObject pdfConvertResult) {
        res = pdfConvertResult;
    }

    public String getPdf() {
        return (String) res.get("pdf");
    }

    public String getUUIDConvertedFile() {
        return (String) res.get("uuidConvertedFile");
    }
    
    public long getConvertedFileSize() {
        Long size = (Long) res.get("sizeConvertedFile");
        return size;
    }

    @Override
    public String toString() {
        return res.toJSONString();
    }
}
