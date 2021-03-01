import java.sql.*;
public class jdb1 
{
	public static void main(String args[])
	{
		String ss="jdbc:mysql://localhost:3306/db1";
		try(Connection con=DriverManager.getConnection(ss,"root","tjs@88"))
		{
System.out.println("Implementation class is\t"+con.getClass()); 
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from dept");
while(rs.next())
{
	int no=rs.getInt("deptid");
	String name=rs.getString("deptname");
//	String add=rs.getString("loc");
	System.out.println(no+"\t"+name+"\t");
}
}
catch(Exception ee)
{
	System.out.println(ee);
}
}
}	


					