import dataUtilObjects.Data;
import dataUtilObjects.Log;
import databaseService.EventEntity;
import databaseService.ManageEvents;
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
            ManageEvents me = new ManageEvents();
            Log log;
            Map<String, Data> logList = new HashMap<>();

            while ((log = fs.readLine()) != null) {
                String id = log.getId();

                if (logList.get(id) == null) {
                    logList.put(id, log.getData());
                } else {
                    int duration = (int) Math.abs(log.getData().getTimestamp() - logList.get(id).getTimestamp());
                    if (duration >= MAX_DURATION) {
                        EventEntity ee = new EventEntity();
                        ee.setEventId(log.getId());
                        ee.setDuration(duration);
                        ee.setHost(log.getData().getHost());
                        ee.setType(log.getData().getType());
                        ee.setAlert(true);
                        me.add(ee);
                    }

                }
            }

            for (EventEntity eventEntity : me.findAll()) {
                System.out.println(eventEntity.getEventId() + ' ' + eventEntity.getDuration());
            }
        }
    }


}
