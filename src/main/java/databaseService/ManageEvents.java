package databaseService;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ManageEvents implements ManageInterface<EventEntity> {
    private static SessionFactory factory;

    public ManageEvents() {
        factory = HibernateUtil.getSessionFactory();
    }

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

}