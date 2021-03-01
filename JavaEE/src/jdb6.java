import java.sql.*;
public class jdb6 
{
	public static void main(String args[])
	{
		String ss="jdbc:mysql://localhost:3306/db1";
		try(Connection con=DriverManager.getConnection(ss,"root","tjs@88"))
		{
CallableStatement cst=con.prepareCall("{ call getDept(?) }");
//cst.setInt(1, 1);
cst.execute();
String name=cst.getString(1);
System.out.println("dept.name retrieved is  "+name);
}
catch(Exception ee)
{
	System.out.println(ee);
}
}
}						