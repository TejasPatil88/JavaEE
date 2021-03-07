package mypack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController  
@CrossOrigin("http://localhost:4200")
public class StudentController
{
	@Autowired
	StudentManager manager;
	@GetMapping(value = "crud/students",headers = "Accept=application/json")  
	 public String showStudents()
	 {
		  return new Gson().toJson(manager.getStudent());
	 }
	@GetMapping(value = "crud/search/{sid}", headers = "Accept=application/json")  
	 public Student getStud(@PathVariable int sid)
	 {
		Student s=manager.getStudent(sid);
		return s;
	 }
	@DeleteMapping(value = "crud/delete/{sid}", headers = "Accept=application/json")  
	 public void removeStud(@PathVariable int sid)
	 {
		manager.delete(sid);
	 }
	@PutMapping(value = "crud/update/{sid}",headers = "Accept=application/json")  
	 public void updateStud(@RequestBody Student student,@PathVariable int sid)
	 {
		manager.update(student,sid);
	 }
	@PostMapping(value = "crud/add", headers = "Accept=application/json")  
	 public void addStud(@RequestBody Student student)
	 {
		System.out.println("addStud called");
		manager.addStudent(student);
	 }
}
