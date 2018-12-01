package ibz.edu.hib.dao;

import java.util.ArrayList;

import ibz.edu.hib.model.Lecturer;

public interface LecturerDAO {

	public ArrayList<Lecturer> listLecturers();
	public long createLecturer(Lecturer lecturer);
	public Lecturer get(int id);
}
