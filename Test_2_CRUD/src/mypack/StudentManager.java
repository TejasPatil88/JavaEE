package mypack;

import java.util.List;

public interface StudentManager
{
	void addStudent(Student p);
	List<Student> getStudent();
	void delete(int id);
	void update(Student student,int id);
	Student getStudent(int id);
}
