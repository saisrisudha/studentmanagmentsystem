package com.studentms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class sample {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
    	Scanner ms=new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        String url="jdbc:mysql://localhost:3306/studentms";
        String username="root";
        String password="270819";
        
        Connection bs=DriverManager.getConnection(url,username,password);
        System.out.println("***Student Data***");
        System.out.println("Enter student id:");
        int sid=ms.nextInt();
        System.out.println("Enter student name:");
        
        ms.nextLine();
        String sname=ms.nextLine(); 
        
        System.out.println("Enter student class");
        int sclass=ms.nextInt();
        
        System.out.println("Enter student grade");
        ms.nextLine();
        String sgrade=ms.nextLine();
        
        String query="insert into student values(?,?,?,?)";
        PreparedStatement pst=bs.prepareStatement(query);
        
        pst.setInt(1, sid);
        pst.setString(2, sname);
        pst.setInt(3, sclass);
        pst.setString(4, sgrade);
        int count=pst.executeUpdate();
        
        System.out.println(count+" row(s) effected");
        bs.close();
        ms.close();

	}

}
