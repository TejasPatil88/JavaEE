import java.sql.*;
public class jdb3
{
	public static void main(String args[])
	{
		String ss="jdbc:mysql://localhost:3306/db1";
		try(Connection con=DriverManager.getConnection(ss,"root","tjs@88"))
		{
System.out.println("Implementation class is\t"+con.getClass());
Statement st=con.createStatement();
int val=st.executeUpdate("update employee set salary=8888880 where Employee_id=1;");
if(val>0)
{
	System.out.println("Records updated");
}
else
{
	System.out.println("can not update records");
}	
}
catch(Exception ee)
{
	System.out.println(ee);
}
}
}








						