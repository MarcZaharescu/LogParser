package fileUtil;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dataUtilObjects.Data;
import dataUtilObjects.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FileService {

    private String filePath;
    private BufferedReader br;

    public FileService(String filePath) {
        this.filePath = filePath;

        try {

            br = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            System.err.println("There was no file found at the following location: " + filePath + ". ");
        }
    }

    public Log readLine() {
        String line;

        try {
            if ((line = br.readLine()) != null) {
                return parseJson(line);
            }
        } catch (IOException e) {
            System.err.println("There was an issue reading the line. " + e);

        }

        return null;
    }

    private Log parseJson(String str) {
        JsonObject jsonObject = new JsonParser().parse(str).getAsJsonObject();
        String id = null;
        String state = null;
        String type = null;
        String host = null;
        long timestamp = 0;

        try {
            id = jsonObject.get("id").getAsString();
            state = jsonObject.get("state").getAsString();
            timestamp = jsonObject.get("timestamp").getAsLong();
            type = jsonObject.get("type").getAsString();
            host = jsonObject.get("host").getAsString();

        } catch (NullPointerException e) {
            // System.err.println("One of the following properties: id, state, timestamp, type, host has failed json parsing. " + e);
        }

        Data logData = new Data(state, type, host, timestamp);
        Log logEntry = new Log(id, logData);

        return logEntry;
    }

}

