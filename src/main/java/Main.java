import dataUtilObjects.Data;
import dataUtilObjects.Log;
import databaseService.EventEntity;
import databaseService.ManageEvents;
import fileUtil.FileService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    /** The main class that combines all the database and file service functionality together.
     * It holds the log event object inside a hashmap so that when another event with the same
     *  id is read it can calculate the duration of it by looking in the location with the same
     *  key id.
     *
     *  It then adds the the event inside a local file based hsqldb if the duration of the event is
     *  greater than the  set MAX_DURATION of 4ms.
     *
     * @param args The first argument represents the path of the file
     */
    public static final int MAX_DURATION = 4;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("There was no path specified. Please input a path");
            return;

        } else {

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

            List<EventEntity> allEvents = me.findAll();
            System.out.println("The following events were logged with the properties: eventId, duration(ms), host, type and alert");
            for (EventEntity eventEntity : allEvents) {
                System.out.println(eventEntity.getEventId() + ' ' + eventEntity.getDuration() + ' '+ eventEntity.getHost() + ' ' + eventEntity.getType() + ' ' + eventEntity.getAlert());
            }
        }
    }


}
