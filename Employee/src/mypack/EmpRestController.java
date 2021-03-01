package mypack;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

	  
	  
	@RestController  
	public class EmpRestController 
	{  
		@Autowired
		EmpDAO empdao;
	
	@GetMapping("/GetAllEmps")   
	 public String disp(HttpServletRequest request,HttpServletResponse response) 
	{
		 System.out.println("inside disp method");
	      List<Employee> list=empdao.getAllEmployees();
	      String json = new Gson().toJson(list);
	       return json;
	 }  
	}  










