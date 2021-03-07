package mypack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentManagerImpl implements StudentManager
{
	@Autowired
	StudentDAO dao;

	@Override
	public void addStudent(Student s) {
		dao.addStudent(s);
		
	}

	@Override
	public List<Student> getStudent() {
		// TODO Auto-generated method stub
		return dao.getStudent();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public void update(Student student,int id) {
		// TODO Auto-generated method stub
		dao.update(student,id);
		
	}

	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return dao.getStudent(id);
	}
	
	

}
