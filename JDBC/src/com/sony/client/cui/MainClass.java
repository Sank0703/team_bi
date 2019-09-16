package com.sony.client.cui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainClass {

	public static void main(String[] args) {
		PreparedStatement preparedStatement=null;
		Connection connection=null;
		ResultSet resultSet=null;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			connection=DriverManager.getConnection("jdbc:oracle:thin:@INSISCILT-4060:1521:XE","sanket","sanket123");
			/*preparedStatement=connection.prepareStatement("INSERT INTO LOGIN VALUES(?,?,?)");
			preparedStatement.setString(1,"Raju");
			preparedStatement.setString(2,"pass");
			preparedStatement.setString(3,"e");
			int rowAffected=preparedStatement.executeUpdate();
					/*	if(rowAffected>0)
			{
				System.out.println("record inserted");
			}
			preparedStatement=connection.prepareStatement("SELECT * FROM LOGIN");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				System.out.println("username:"+resultSet.getString(1)+"\npassword:"+resultSet.getString(2));
			}
			preparedStatement=connection.prepareStatement("UPDATE LOGIN SET USER_ID=? WHERE PASSWD=?");
			preparedStatement.setString(1,"SONU");
			preparedStatement.setString(2,"pass");
			int rowAffected=preparedStatement.executeUpdate();
			if(rowAffected>0)
			{
				System.out.println("record updated");
			}*/
			preparedStatement=connection.prepareStatement("DELETE FROM LOGIN WHERE PASSWD=?");
			preparedStatement.setString(1,"pass");
			int rowAffected=preparedStatement.executeUpdate();
			if(rowAffected>0)
			{
				System.out.println("record deleted");
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(preparedStatement!=null && !preparedStatement.isClosed())
				{
					preparedStatement.close();
				}
				if(connection !=null&& !connection.isClosed())
				{
					connection.close();
				}
				if(resultSet!=null&& !resultSet.isClosed())
				{
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
