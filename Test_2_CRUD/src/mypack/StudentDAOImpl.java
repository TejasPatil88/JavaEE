package mypack;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO
{
	@Autowired
	HibernateTemplate template;

	@Override
	public List<Student> getStudent()
	{
		List<Student>mylist=(List<Student>) template.find("from Student s");
		return mylist;
	}
	@Override
	public void delete(int id)
	{
		template.delete(template.get(Student.class, id));
	}
	@Override
	public void update(Student student,int id)
	{
		template.bulkUpdate("update Student s set s.name=?, s.role=? where p.id=?",student.getName(),student.getRole(),id);
		//template.update(template.get(Student.class, id)); --> for updating a single record.
	}
	
	@Override
	public Student getStudent(int id)
	{
		Student temp=(Student)template.find("from Student s where s.id=?",id).get(0);
		return temp;
	}
	@Override
	public void addStudent(Student s) {
		template.save(s);
		
	}
}
