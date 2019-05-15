package com.javatpoint.dao;
import java.sql.*;
public class DB {
public static Connection getCon(){
	Connection con=null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:mysql://10.179.12.67:3306/ZakirTest","system","oracle");
	}catch(Exception ex){System.out.println(ex);}
	return con;
}
}
