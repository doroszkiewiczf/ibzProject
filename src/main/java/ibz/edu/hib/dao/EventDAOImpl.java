package ibz.edu.hib.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ibz.edu.hib.model.Event;

@Repository
public class EventDAOImpl implements EventDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public ArrayList<Event> listEventsFromGroup(int groupId) {
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	ArrayList<Event> eventList = null;
    	 try {
             tx = session.beginTransaction();
             Query q = session.createQuery("select e from Event e where e.groupId = :groupId");
             q.setParameter("groupId", groupId);
             eventList = (ArrayList) q.list();
             //commentList = (ArrayList)session.createQuery("FROM LecturerComment").list(); 
             for (Event event: eventList)
            	 System.out.println(event.getId());
             tx.commit();
          } catch (HibernateException e) {
             if (tx!=null) tx.rollback();
             e.printStackTrace(); 
          } finally {
             session.close(); 
          }
    	return eventList;
	}

	public long createEvent(Event event) {
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(event);
        session.getTransaction().commit();
        session.close();
        return event.getId();
	}

}
