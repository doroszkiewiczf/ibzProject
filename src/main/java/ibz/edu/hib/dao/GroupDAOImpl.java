package ibz.edu.hib.dao;

import java.util.ArrayList;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ibz.edu.hib.model.Group;
import ibz.edu.hib.model.Student;

@Repository
public class GroupDAOImpl implements GroupDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public long createGroup(Group group) {
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(group);
        session.getTransaction().commit();
        session.close();
        return group.getId();
	}

	public ArrayList<Group> getGroupList() {
		Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	ArrayList<Group> groupList = null;
    	 try {
             tx = session.beginTransaction();
             groupList = (ArrayList)session.createQuery("FROM Group").list(); 
             for (Group group: groupList)
            	 System.out.println(group.getName());
             tx.commit();
          } catch (HibernateException e) {
             if (tx!=null) tx.rollback();
             e.printStackTrace(); 
          } finally {
             session.close(); 
          }
		return groupList;
	}

	public Set<Group> getGroupFromStudent(int studentId) {
		Session session = sessionFactory.openSession();
    	Student student = (Student) session.get(Student.class, studentId);
        Set <Group> groupSet = student.getGroups();
        	  for(Group group : groupSet) {
        		    System.out.println(group.getName());
        		}
        session.close();
        return groupSet;
	}

}
