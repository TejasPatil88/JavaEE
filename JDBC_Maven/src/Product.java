import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/*
 * 3) Object  Persistence inside database
 * 
create a table "Product" with
	pid number
	qty number
	cost decimal
	pname varchar
[ do not add any record ]

define a class "Product" with
	private int pid,qty;
	private double cost;
	private String pname;
		setters,getters,parameterized constructor and toString()

create 1 instance of above class , 
display it and then insert a row inside Product with the help of above instance.

	now assign "null" to the above instance.
	That means your heap based object will be soon garbage collected ,
	but you need not worry as you have saved the state of an object inside the database.

	now fire a query to read that record and with the help of it 
	initialize new object of "Product" and display it.

 */
public class Product {

	private int pid,qty;
	private double cost;
	private String pname;
	
	public Product(int pid, int qty, double cost, String pname) {
		this.pid = pid;
		this.qty = qty;
		this.cost = cost;
		this.pname = pname;
	}

	public Product() {
		
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", qty=" + qty + ", cost=" + cost + ", pname=" + pname + "]";
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public static void main(String[] args) {
		
		Product p=new Product(1,8,500,"XYZ");
		System.out.println(p.toString());
		
		Scanner sc = new Scanner(System.in);
		String ss="jdbc:mysql://localhost:3306/db2";
		try(Connection con=DriverManager.getConnection(ss,"root","tjs@88"))
		{
System.out.println("Implementation class is\t"+con.getClass());
int n=p.getPid();
int q=p.getQty();
double c=p.getCost();
String s=p.getPname();
PreparedStatement st=con.prepareStatement("insert into Product values(?,?,?,?)");
st.setInt(1, n);
st.setInt(2, q);
st.setDouble(3, c);
st.setString(4, s);
int mod=st.executeUpdate();

if(mod>0)
{
	System.out.println("Records are successfully added");
}
p=null;
ResultSet rs=st.executeQuery("select * from Product");
Product p1=new Product();
while(rs.next())
{
	p1.setPid(rs.getInt("pid"));
	p1.setQty(rs.getInt("qty"));
	p1.setCost(rs.getInt("cost"));
	p1.setPname(rs.getNString("pname"));
	System.out.println(p1.toString());
}

		}
catch(Exception ee)
		{
	System.out.println(ee);
		}
	}

}






















