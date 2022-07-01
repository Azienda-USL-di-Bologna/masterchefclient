package it.bologna.ausl.masterchefclient.utils;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */
public class UtilityFunctions {
    
    public static byte[] readInputStream(InputStream is) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            byte[] readData = new byte[1024];
            int bytesRead = is.read(readData);
            while (bytesRead > 0) {
                baos.write(readData, 0, bytesRead);
                bytesRead = is.read(readData);
            }
            return baos.toByteArray();
        }
        finally {
            is.close();
            baos.close();
        }
    }
    
    public static String readFileToString(File path) throws IOException {
    FileInputStream stream = new FileInputStream(path);
        try {
            FileChannel fc = stream.getChannel();
            MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
            /* Instead of using default, pass in a decoder. */
            return Charset.forName("UTF-8").decode(bb).toString();
        }
        finally {
            stream.close();
        }
    }
}
