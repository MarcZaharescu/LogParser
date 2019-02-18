package databaseService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


public class ManageEventsTest {

    private ManageEvents eventManager;

    @Before
    public void init() {
        eventManager = new ManageEvents();
    }

    @Test
    @Transactional

    public void testAddEvent() {
        EventEntity ee = new EventEntity();
        ee.setEventId("111");
        ee.setType("testType");
        ee.setHost("testHost");
        ee.setDuration(123);
        ee.setAlert(true);

        eventManager.add(ee);

        List<EventEntity> ees = eventManager.findAll();

        Assert.assertEquals(ee.getEventId(), ees.get(0).getEventId());
        Assert.assertEquals(ee.getType(), ees.get(0).getType());
        Assert.assertEquals(ee.getHost(), ees.get(0).getHost());
        Assert.assertEquals(ee.getDuration(), ees.get(0).getDuration());
        Assert.assertEquals(ee.getAlert(), ees.get(0).getAlert());

        eventManager.deleteAll();
    }


    @Test
    public void testFindAllEvents() {

        EventEntity ee1 = new EventEntity();
        ee1.setEventId("123");
        ee1.setType("testType");
        ee1.setHost("testHost");
        ee1.setDuration(123);
        ee1.setAlert(true);

        EventEntity ee2 = new EventEntity();
        ee2.setEventId("321");
        ee2.setType("testType");
        ee2.setHost("testHost");
        ee2.setDuration(123);
        ee2.setAlert(true);

        eventManager.add(ee1);
        eventManager.add(ee2);

        List<EventEntity> actualEvents = eventManager.findAll();
        List<EventEntity> expectedEvents = new ArrayList<EventEntity>();
        expectedEvents.add(ee1);
        expectedEvents.add(ee2);

        Assert.assertEquals(2, actualEvents.size());
        Assert.assertEquals(expectedEvents.get(0).getEventId(), actualEvents.get(0).getEventId());
        Assert.assertEquals(expectedEvents.get(1).getEventId(), actualEvents.get(1).getEventId());

        eventManager.deleteAll();
    }


    @Test
    public void testDeleteAllEvents() {

        EventEntity ee1 = new EventEntity();
        ee1.setEventId("000");
        ee1.setType("testType");
        ee1.setHost("testHost");
        ee1.setDuration(123);
        ee1.setAlert(true);

        eventManager.add(ee1);
        List<EventEntity> actualEvents;

        actualEvents= eventManager.findAll();
        Assert.assertEquals(1, actualEvents.size());

        eventManager.deleteAll();

        actualEvents= eventManager.findAll();
        Assert.assertEquals(0, actualEvents.size());
    }
}