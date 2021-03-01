import java.sql.*;
import java.util.Scanner;
public class jdb5 
{
	public static void main(String args[])
	{
		String ss="jdbc:mysql://localhost:3306/db1";
		try(Connection con=DriverManager.getConnection(ss,"root","tjs@88"))
		{
System.out.println("Implementation class is\t"+con.getClass());
PreparedStatement pst=con.prepareStatement("update Employee set Salary=? where Employee_id=1");
Scanner sc=new Scanner(System.in);
System.out.println("Enter the salary to be updated : ");
int n=sc.nextInt();
pst.setInt(1,n);
	//replace 1'st question mark with "user input salary"
int mod=pst.executeUpdate();

if(mod>0)
{
	System.out.println("Records are successfully added");
}
}
catch(Exception ee)
{
	System.out.println(ee);
}
}
}








						