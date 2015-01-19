import java.io.*;
import java.net.*;
public class fclient
{
	public static void main(String args[])
	//fclient(String s)
	{
		try
		{                       
			//Socket cln=new Socket("198.126.30.8",95);
			//Socket cln=new Socket("192.100.100.25",95);
			Socket  cln=new Socket("localhost",95);
			System.out.println("connected to"+cln);
			PrintWriter out=new PrintWriter(cln.getOutputStream(),true);
			String s=args[0];
			File f=new File(s);
			if(f.exists())
			{
				BufferedReader d=new BufferedReader(new FileReader(s));
				String line;
				while(true)
				{
					while((line=d.readLine())!=null)
					{
						out.write(line);
						System.out.println(line);
					}
					break;
				}
				d.close();
			}
		}
		catch(Exception e3)
		{
			System.out.println("error:"+e3);
		}

	}
}
