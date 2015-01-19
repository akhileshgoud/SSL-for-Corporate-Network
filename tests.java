import java.io.*;
import java.net.*;
import javax.swing.*;
public class tests
{
	public static void main(String args[]) throws IOException
	//fserver(String s)
	{
		ServerSocket ser=null;
		BufferedReader br=null;
		try
		{
			ser=new ServerSocket(95);
		}
		catch(Exception e)
		{
			System.out.println("ERROR:"+e);
		}
		Socket cln=null;
		try
		{
			cln=ser.accept();
			System.out.println("connected to"+cln);
			br=new BufferedReader(new InputStreamReader(cln.getInputStream()));
		}
		catch(Exception e1)
		{
			System.out.println("WRONG:"+e1);
		}
		String a;
		StringBuffer sb=new StringBuffer(700);
		sb.append("Krisp's  welcome :__________________");
		try
		{
			if((a=br.readLine())!=null)
			{
				sb.append("\n");
				sb.append(a);
				sb.append("\t\n");
			}
		}
		catch(Exception e3)
		{
			System.out.println(e3);
		}
		if(sb!=null)
		{
			System.out.println(sb);
			String s4="U HAVE RECIEVED A NEW FILE ,STORED IN TEMP.DOC";
			sframe sf=new sframe("NEW FILE",s4);
			tests ts=new tests();
		}
		ser.close();
		cln.close();
	}
}



