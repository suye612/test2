package com.chinaedu.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DS {
private static DataSource ds=null;
private DS(){
	
}
public static DataSource getDs(){
	if(ds==null){
		try {
			Context  cx=new InitialContext();
			 ds = (DataSource) cx.lookup("java:comp/env/jdbc/goods");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return ds;
	}else{
		return ds;
	}
}
}
