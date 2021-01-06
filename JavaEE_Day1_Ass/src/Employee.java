import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/*2) create table "Employee"
	empid,empname,desig

	add 5 records manually.

   Now write a java program to accept "designation" from user and retrieve employees 
   with the given designation.
*/

public class Employee
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String ss = "jdbc:mysql://localhost:3306/db2";
		try(Connection con=DriverManager.getConnection(ss,"root","tjs@88"))
		{
			System.out.println("Implementation class is\t"+con.getClass());
			System.out.println("Enter the Designation : ");
			String s=sc.next();
			PreparedStatement st=con.prepareStatement("select * from Employee where desig=?");
			st.setString(1, s);
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				int empid=rs.getInt("empid");
				String empname=rs.getString("empname");
				String desig=rs.getString("desig");
				System.out.println(empid+"\t"+empname+"\t"+desig);
			}
		}
			
		  catch (Exception e) {
			e.printStackTrace();
		}
	}
}

















