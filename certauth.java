import java.io.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.rmi.server.*;
public class certauth extends UnicastRemoteObject implements servin
{
	certauth() throws RemoteException
	{
		//////////
		System.out.println("Constructror");
	}
	public String commun(String dn,String id) throws RemoteException
	{
		String nchec=new String("");
		String nid=new String("");
		String ss=new String("");
		Connection con=null;
		Statement s=null;
 		String createString;
		String insertString;
		insertString="select * from ident1 where domain='"+dn+"'";
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//con = DriverManager.getConnection("jdbc:odbc:once");
			con=DriverManager.getConnection("jdbc:odbc:leodsn","scott","tiger");
			s = con.createStatement();
			ResultSet rs=s.executeQuery(insertString);
			while(rs.next())
			{
				nchec=rs.getString("domain");
				nid=rs.getString("id");
			}
			if((nchec.equals(dn))&&(nid.equals(id)))
			{
				ss="EXISTS";
				//System.out.println("THE DATA EXISTS");
			}
			else
			{
				ss="not exists";
				//System.out.println("THERE IS NO DATA FOUND");
			}
			s.close();
			con.commit();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("there is an error during commun"+e);
		}
		return(ss);
	}

	public String certify(String dn,String add,String no,String pname,String bus,String grad) throws RemoteException
	{
	System.out.println("....."+dn);
	System.out.println("....."+add);
	System.out.println("....."+no);
	System.out.println("....."+pname);
	System.out.println("....."+bus);
	System.out.println("....."+grad);
		//Connection con=null;
		Connection con;
		Statement s=null;
		String id=new String("");
		String createString;
		String insertString;
		id=dn;
		id+=no;
		insertString="insert into ident1 values('"+dn+"','"+add+"','"+no+"','"+pname+"','"+bus+"','"+id+"','"+grad+"')";
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//con=DriverManager.getConnection("jdbc:odbc:once");
				System.out.println("................................................");
			con =DriverManager.getConnection("jdbc:odbc:leodsn","scott","tiger");
				System.out.println("................................................");
			s=con.createStatement();
			s.executeUpdate(insertString);
			s.close();
			con.commit();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("there is an error during inserting"+e);
		}
		return id;
	}
	public String getcert(String dn) throws RemoteException
	{
		Connection con=null;
		Statement s=null;
		ResultSet rs=null;
		String id=new String("");
		String nchec="";
		String createString;
		String insertString;
		id=dn;
		//id+=no;
		insertString="select * from ident1 where domain='"+dn+"'";
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//con=DriverManager.getConnection("jdbc:odbc:once");
			con=DriverManager.getConnection("jdbc:odbc:leodsn","scott","tiger");
			s=con.createStatement();
			//String ss="insert into ident values('"+dn+"',"+add+"',"+no+"',"+pname+"',"+bus+"',"+id+"')";
			//s.executeUpdate(createString);
			rs=s.executeQuery(insertString);
		}
		catch(Exception e4)
		{
			System.out.println("e4"+e4);
		}
		try
		{
			String nid="";
			while(rs.next())
			{
				nchec=rs.getString("domain");
				nchec+="\t";
				nchec+=rs.getString("address");
				nchec+="\t";
				nchec+=rs.getString("phone");
				nchec+="\t";
				nchec+=rs.getString("nature");
				nchec+="\t";
				nchec+=rs.getString("authorised");
				nchec+="\n";
				nchec+=rs.getString("id");
			}
			System.out.println(nchec);
			s.close();
			con.commit();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("there is an error during inserting an string..."+e);
		}
		return nchec;
	}
	public static void main(String args[])
	{
		try
		{
			certauth cer=new certauth();
			//Naming.rebind("cce",cer);
			Naming.rebind("cce",cer);
			System.out.println("cer::"+cer);
		}
		catch(Exception e1)
		{
			System.out.println("there is error"+e1);
		}
	} 

}


                






