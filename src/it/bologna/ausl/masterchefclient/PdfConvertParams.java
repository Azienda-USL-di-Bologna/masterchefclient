package it.bologna.ausl.masterchefclient;

import it.bologna.ausl.masterchefclient.utils.UtilityFunctions;
import it.bologna.ausl.tools.Base64Coder;
import java.io.*;
import org.json.simple.JSONObject;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */

/*
INPUT
updatebabeljob={
    'appID':"rediscli",
    'jobID':"1",
    'jobList':[ {
        'jobN':"job1",
        'jobType':"PdfConvert",
        'params': {  
            'file': "base64File"
            'srcFileUuid': "sourceFileSuMongo"
            'convertedFilePath': "convertedFilePathSuMongo"
            'noErrorIfNotFound': "true|false"
        }
    }],
    'returnQueue':"queueName"
}
    * Cose da ricordare: 
    * se specificato 'file', il parametro 'srcFileUuid' è ignorato, altrimenti il file è preso da 'srcFileUuid' su mongo
    * se specificato 'convertedFilePath' il file convertito viene anche salvato su mongo nel percorso indicato

*/

public class PdfConvertParams extends JobParams {

private JSONObject jsonData;

    public PdfConvertParams(JSONObject jsonData) {
        this.jsonData = jsonData;
    }

    private PdfConvertParams(boolean noErrorIfNotFound) {
        jsonData = new JSONObject();
        jsonData.put("noErrorIfNotFound", noErrorIfNotFound);
    }

    public PdfConvertParams(File file, boolean noErrorIfNotFound) throws FileNotFoundException, IOException {
        this(file, null, noErrorIfNotFound);
    }

    public PdfConvertParams(byte[] file, boolean noErrorIfNotFound) {
        this(file, null, noErrorIfNotFound);
    }

    public PdfConvertParams(InputStream file, boolean noErrorIfNotFound) throws IOException {
        this(file, null, noErrorIfNotFound);
    }

    public PdfConvertParams(String srcFileUuid, boolean noErrorIfNotFound) {
        this(srcFileUuid, null, noErrorIfNotFound);
    }

    public PdfConvertParams(File file, String convertedFilePath, boolean noErrorIfNotFound) throws FileNotFoundException, IOException {
        this(new FileInputStream(file), convertedFilePath, noErrorIfNotFound);
    }

    public PdfConvertParams(byte[] file, String convertedFilePath, boolean noErrorIfNotFound) {
        this(noErrorIfNotFound);
        jsonData.put("file", Base64Coder.encodeLines(file));
        addConvertedFilePath(convertedFilePath);
    }

    public PdfConvertParams(InputStream file, String convertedFilePath, boolean noErrorIfNotFound) throws IOException {
        this(UtilityFunctions.readInputStream(file), convertedFilePath, noErrorIfNotFound);
    }

    public PdfConvertParams(String srcFileUuid, String convertedFilePath, boolean noErrorIfNotFound) {
        this(noErrorIfNotFound);
        jsonData.put("srcFileUuid", srcFileUuid);
        addConvertedFilePath(convertedFilePath);
    }

    private void addConvertedFilePath(String convertedFilePath) {
        if (convertedFilePath != null)
            jsonData.put("convertedFilePath", convertedFilePath);
    }

    public static PdfConvertParams parse(JSONObject params) {
        PdfConvertParams pcp = new PdfConvertParams(params);
        return pcp;
    }
    
    @Override
    public JSONObject getData() {
        return jsonData;
    }

    @Override
    public String getJobType() {
        return "PdfConvert";
    }

    @Override
    public String toString() {
        return jsonData.toJSONString();
    }
}
