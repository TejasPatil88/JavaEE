package mypack;

// Generated 12 Aug, 2016 2:03:15 PM by Hibernate Tools 3.2.2.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name = "employee", catalog = "project")
public class Employee implements java.io.Serializable {

	private int id;
	private String name;
	private String desig;
	private Integer salary;

	public Employee() {
	}

	public Employee(int id) {
		this.id = id;
	}

	public Employee(int id, String name, String desig, Integer salary) {
		this.id = id;
		this.name = name;
		this.desig = desig;
		this.salary = salary;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name", length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "desig", length = 40)
	public String getDesig() {
		return this.desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	@Column(name = "salary", precision = 6, scale = 0)
	public Integer getSalary() {
		return this.salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

}
