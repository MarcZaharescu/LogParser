package databaseService;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 *  The DAO class where it implements the methods defined in the ManageInterface
 */
public class ManageEvents implements ManageInterface<EventEntity> {
    private static SessionFactory factory;

    /**
     *  Constructor initiating the session factory object with the aid of the HibernateUtil class
     */
    public ManageEvents() {
        factory = HibernateUtil.getSessionFactory();
    }

    /** Add method that persists an event to the database
     *
     * @param ee EventEntity object
     */
    public void add(EventEntity ee) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(ee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            System.err.println("Session has failed to create the event with the following event: " + ee + " " + e);
        } finally {
            session.close();
        }
    }

    /** Method to return all the persisted events. Used only for testing purposes.
     *
     * @return list of all the entity events
     */
    public List<EventEntity> findAll() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List<EventEntity> events = (List<EventEntity>) session.createQuery("FROM EventEntity").list();
            tx.commit();


            return events;

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            System.err.println("Session has failed to read events. " + e);
        } finally {
            session.close();
        }

        return null;
    }

    /** Method delete all the events in the database
     *
     *
     */
    public void deleteAll(){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.createQuery("DELETE FROM EventEntity").executeUpdate();
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            System.err.println("Session has failed to delete events. " + e);
        } finally {
            session.close();
        }

    }

}