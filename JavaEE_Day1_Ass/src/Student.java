/*1) create a table "Student"
	rollno,name,age
write a java program to accept rollno,name,age from user and insert a row.
after inserting that row try to view using a query.
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class Student
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String ss="jdbc:mysql://localhost:3306/db1";
		try(Connection con=DriverManager.getConnection(ss,"root","tjs@88"))
		{
System.out.println("Implementation class is\t"+con.getClass());
System.out.println("Enter the Roll_No of Student : ");
int n=sc.nextInt();
System.out.println("Enter the Name of Student : ");
String s=sc.next();
System.out.println("Enter the Age of Student : ");
int a=sc.nextInt();
PreparedStatement st=con.prepareStatement("insert into student values(?,?,?)");
st.setInt(1, n);
st.setString(2, s);;
st.setInt(3, a);
int mod=st.executeUpdate();

if(mod>0)
{
	System.out.println("Records are successfully added");
}

ResultSet rs=st.executeQuery("select * from student");
while(rs.next())
{
	int no=rs.getInt("Roll_no");
	String name=rs.getString("Name");
    int age=rs.getInt("Age");
	System.out.println(no+"\t"+name+"\t"+age);
}

		}
catch(Exception ee)
		{
	System.out.println(ee);
		}
	}
}








						