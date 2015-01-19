import java.io.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.rmi.server.*;
import javax.swing.*;
import java.awt.*;
public class server extends UnicastRemoteObject implements serint
{
	String res=new String("");
	server() throws RemoteException
	{
		System.out.println("Constructor........");
	}
	public void check(String dn,String id)
	{
		try
		{
			//String s="rmi://198.126.30.8/cce";
			//String s="rmi://192.100.100.25/cce";
			String s="rmi://localhost/cce";
			servin ser=(servin)Naming.lookup(s);
			System.out.println("ser:"+ser);
			res=ser.commun(dn,id);
			System.out.println(res);
			sframe f=new sframe("Data Check",res);
			if(res.equals("EXISTS"))
			{
				communi c=new communi("TO CLIENT");
				c.setVisible(true);
				c.setSize(500,600);  
			}
		}
		catch(Exception e)
		{
			System.out.println("E----server"+e);
		}
	}
	public static void main(String args[])
	{
		try
		{
			server ser=new server();
			//Naming.rebind("sse",ser);
			Naming.rebind("sse",ser);
		}
		catch(Exception e1)
		{
			System.out.println("there is error..server"+e1);
		}
	} 
}


                






