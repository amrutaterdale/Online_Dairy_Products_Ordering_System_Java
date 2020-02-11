package finale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import finale.product;




public class daolayer {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/final", "root", "root");
		return con;
	}
	
	public static Map<String, String> savereguser(reguser r) throws ClassNotFoundException, SQLException {

		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement("insert into reguser(fname,password,email,gender) values(?,?,?,?)");

		String name = r.getFname();
		String password = r.getPassword();
		String email = r.getEmail();
		String gender = r.getGender();

		ps.setObject(1, name);
		ps.setObject(2, password);
		ps.setObject(3, email);
		ps.setObject(4, gender);

		int status = ps.executeUpdate();

		Map<String, String> map = new HashMap<>();

		if (status == 1) {
			map.put("msg", "done");

		} else {
			map.put("msg", "sorry");
		}
		return map;
	}
	
	public static ArrayList<reguser> getRegAllData() throws SQLException, ClassNotFoundException
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from reguser;");
		
		ResultSet rs=ps.executeQuery();
		ArrayList<reguser>list=new ArrayList<>();
		
		while(rs.next())
		{
			reguser r=new reguser();
			r.setFname(rs.getString(1));
			r.setPassword(rs.getString(2));
			r.setEmail(rs.getString(3));
			r.setGender(rs.getString(4));
			
			list.add(r);
		}
		return list;
	}
	
	public static ArrayList<product> getAllProduct() throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from product");
		ResultSet rs=ps.executeQuery();
		
		ArrayList<product>li=new ArrayList<>();
		 while(rs.next())
		 {
			 product p=new product();
			 p.setId(rs.getInt(1));
			 p.setProd_name(rs.getString(2));
			 p.setCompany(rs.getString(3));
			 p.setQuantity(rs.getString(4));
			 p.setRate(rs.getString(5));
			 
			 li.add(p);
		 }
		 
		 return li;
		
		
	}
	
	public static Map<String, String> addproduct(product p) throws ClassNotFoundException, SQLException {

		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement("insert into product(prod_name,company,quantity,rate) values(?,?,?,?)");

		String prod_name = p.getProd_name();
		String company= p.getCompany();
		String quantity = p.getQuantity();
		String rate = p.getRate();

		ps.setObject(1, prod_name);
		ps.setObject(2,company);
		ps.setObject(3,quantity);
		ps.setObject(4,rate);

		int status = ps.executeUpdate();

		Map<String, String> map = new HashMap<>();

		if (status == 1) {
			map.put("msg", "done");

		} else {
			map.put("msg", "sorry");
		}
		return map;
	}
	
	public static Map<String, String> deleteproduct(product p) throws ClassNotFoundException, SQLException {
		
		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement("delete from product where id=?");

		ps.setObject(1, p.getId());

		int status = ps.executeUpdate();

		Map<String, String> mp = new HashMap<>();

		if (status == 1) {
			mp.put("msg", "done");
		} else {
			mp.put("msg", "sorry");
		}

		return mp;

	}
	
	public static Map<String, String> updateproduct(product p) {

		Map<String, String> map=new HashMap<String, String>();
		
		try {
			Connection con = getConnection();

			PreparedStatement ps = con.prepareStatement("update product set prod_name=?,company=?,quantity=?,rate=? where id=?");

			ps.setString(1, p.getProd_name());
			ps.setString(2, p.getCompany());
			ps.setString(3, p.getQuantity());
			ps.setString(4, p.getRate());
			ps.setInt(5, p.getId());

			int status = ps.executeUpdate();

			if (status == 1)
			{
				map.put("msg", "done");
			}
			else
			{
				map.put("msg", "sorry");
			}

		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return map;
	}
	
	public static Map<String, String> saveorderedproduct(purchase p) throws ClassNotFoundException, SQLException {

		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement("insert into purchase(id,prod_name,company,pur_qty,rate,quantity) values(?,?,?,?,?,?)");
        
		int id=p.getId();
		String prod_name = p.getProd_name();
		String company= p.getCompany();
		String pur_qty = p.getPur_qty();
		String rate = p.getRate();
		String quantity=p.getQuantity();
		
		
		ps.setObject(1, id);
        ps.setObject(2, prod_name);
		ps.setObject(3,company);
		ps.setObject(4,pur_qty);
		ps.setObject(5,rate);
		ps.setObject(6, quantity);

		int status = ps.executeUpdate();

		Map<String, String> map = new HashMap<>();

		if (status == 1) {
			map.put("msg", "done");

		} else {
			map.put("msg", "sorry");
		}
		return map;
	}
	

	public static ArrayList<purchase> getpurchaseList() throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from purchase");
		ResultSet rs=ps.executeQuery();
		
		ArrayList<purchase>li=new ArrayList<>();
		 while(rs.next())
		 {
			 purchase p=new purchase();
			 p.setId(rs.getInt(1));
			 p.setProd_name(rs.getString(2));
			 p.setCompany(rs.getString(3));
			 p.setPur_qty(rs.getString(4));
			 p.setRate(rs.getString(5));
			 p.setQuantity(rs.getString(6));
			 
			 li.add(p);
		 }
		 
		 return li;
		
		
	}
	
public static Map<String, String> deletepurchase(purchase p) throws ClassNotFoundException, SQLException {
		
		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement("delete from purchase where id=?");

		ps.setObject(1, p.getId());

		int status = ps.executeUpdate();

		Map<String, String> mp = new HashMap<>();

		if (status == 1) {
			mp.put("msg", "done");
		} else {
			mp.put("msg", "sorry");
		}

		return mp;

	}

public static Map<String,String> deleteactivity() throws ClassNotFoundException, SQLException
{
	Connection con=getConnection();
	PreparedStatement ps=con.prepareStatement("delete from purchase");
	int rs=ps.executeUpdate();
	System.out.println("delete purchase");
	Map<String, String> mp = new HashMap<>();

	if (rs == 1) {
		mp.put("msg", "done");
	} else {
		mp.put("msg", "sorry");
	}

	return mp;
}

public static Map<String, String> updatequantity(product p) {

	Map<String, String> map=new HashMap<String, String>();
	
	try {
		Connection con = getConnection();
		
		PreparedStatement ps = con.prepareStatement("update product set quantity=? where id=?");
		System.out.println("update");

		ps.setString(1, p.getQuantity());
		ps.setInt(2, p.getId());

		int status = ps.executeUpdate();

		if (status == 1)
		{
			map.put("msg", "done");
		}
		else
		{
			map.put("msg", "sorry");
		}

	} 
	catch (Exception ex)
	{
		ex.printStackTrace();
	}

	return map;
}

}
