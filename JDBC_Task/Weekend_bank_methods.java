package Sql;
import java.sql.*;

public class Weekend_bank_methods {
		String sql;
		void create(Connection c, Statement s) throws SQLException
		{
			sql = "create table customer_details"
					+ "(cus_id int auto_increment,"
					+ "cus_name varchar(50) not null,"
					+ "cus_age int not null,"
					+ "primary key(cus_id)"
					+ ");";
			s.executeUpdate(sql);
			System.out.println("table Created .....");
		}	
		
		
		
		void display(Connection c1, Statement s1) throws SQLException
		{
			sql = "Select * from customer_details";
			ResultSet rs=s1.executeQuery(sql);
			while(rs.next())
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			c1.close();
			System.out.println("task completed ....");
		}
		void insert(Connection c, PreparedStatement ps,String cus_name,int cus_age) throws SQLException
		{
			ps.setString(1, cus_name);
			ps.setInt(2, cus_age);
			
			ps.executeUpdate();
			
		}
		
		
	}




