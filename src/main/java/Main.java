import dataUtilObjects.Data;
import dataUtilObjects.Log;
import fileUtil.FileService;

import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) {

        if (args.length == 0) {
            System.err.println("There was no path specified. Please input a path");
            return;

        } else {
            final int MAX_DURATION = 4;
            String fileName = args[0];

            FileService fs = new FileService(fileName);

            Log log;
            Map<String, Data> logList = new HashMap<>();

            while ((log = fs.readLine()) != null) {
                String id = log.getId();

                if (logList.get(id) == null) {
                    logList.put(id, log.getData());
                } else {
                    int duration = (int) Math.abs(log.getData().getTimestamp() - logList.get(id).getTimestamp());

                    }

                }
            }

        }
    }


}
