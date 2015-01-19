import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
class ttcps
{
	public static void main(String args[])throws IOException
	{
		ServerSocket s=null;
		try
		{
			//s=new ServerSocket(600);
			s=new ServerSocket(600);
			Socket c;
			c=s.accept();
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			BufferedReader p=new BufferedReader(new InputStreamReader(c.getInputStream()));
			PrintWriter out=new PrintWriter(c.getOutputStream(),true);
			String msg=new String("");
			String msg1=new String("");
			System.out.println("connected to client"+c);
			while(true)
			{
				msg1+="\t";
				msg=p.readLine();
				msg1+=msg;
				System.out.println("client"+msg);
				if(msg.equals("exit"))
				{
					out.write("exit");
					break;
				}
			}
			s.close();
			p.close();
			br.close();
			c.close();
			sframe sf=new sframe("data check",msg1);
		}
		catch(Exception e)
		{
			System.out.println("error in"+e);
		}
	}
}
