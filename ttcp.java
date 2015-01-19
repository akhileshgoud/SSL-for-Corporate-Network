import java.io.*;
import java.net.*;
class ttcp
{
	//public static void main(String args[])
	ttcp(String npub,String epub,String fname)
	{
		/*String npub=new String("");
		String epub=new String("");
		String fname=new String("");*/
		System.out.println("ttcp......welcome");
		try
		{
			Socket c;
			System.out.println("Ttcp...............................");
			//c=new Socket("198.126.30.8",600);
			//c=new Socket("192.100.100.25",600);
			c=new Socket("localhost",600);
			System.out.println("Ttcp.....");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			BufferedReader p=new BufferedReader(new InputStreamReader(c.getInputStream()));
			PrintWriter out=new PrintWriter(c.getOutputStream(),true);
			String inf,msg;
			System.out.println("connected to server"+c);
			while(true)
			{
				inf=String.valueOf(npub);
				if(inf.equals("exit"))
				break;
				out.println(npub);
				out.println(epub);
				out.println(fname);
				out.println("exit");
				break;
			}
			c.close();
		}
		catch(Exception e)
		{
			System.out.println("error in"+e);
		}
	}
}
