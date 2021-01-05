import java.sql.*;
public class jdb4 
{
	public static void main(String args[])
	{
		String ss="jdbc:mysql://localhost:3306/db1";
		try(Connection con=DriverManager.getConnection(ss,"root","tjs@88"))
		{
System.out.println("Implementation class is\t"+con.getClass());
PreparedStatement pst=con.prepareStatement("select * from employee");
ResultSet rs=pst.executeQuery();
while(rs.next())
{
	int  no=rs.getInt("Employee_id");
	String First_name=rs.getString("First_Name");
	String Last_name=rs.getString("Last_Name");
	int salary=rs.getInt("Salary");
	//String loc=rs.getString("loc");
	System.out.println(no+"\t"+First_name+"\t"+Last_name);
}

} 
catch(Exception ee)
{
	System.out.println(ee);
}
}
}






						