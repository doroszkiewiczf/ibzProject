package ibz.edu.spring.service;

import java.util.ArrayList;

import ibz.edu.hib.model.Lecturer;

public interface LecturerService {
	
	public ArrayList<Lecturer> listLecturers();
	public long createLecturer(Lecturer lecturer);
	public Lecturer get(int id);
}
