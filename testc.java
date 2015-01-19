import java.io.*;
import java.net.*;
public class testc
{
	//public static void main(String args[])throws  IOException
	testc(String s)
	{
		Socket cln=null;
		BufferedReader in=null;
		FileOutputStream fout;
		try
		{
			//cln=new Socket("198.126.30.8",95);
			//cln =new Socket("192.100.100.25",95);
			cln=new Socket("localhost",95);
			System.out.println("testc..........");
			in=new BufferedReader(new InputStreamReader(System.in));
		}
		catch(Exception e)
		{
			System.out.println("THERE IS AN ERROR DURING CONNECTION testc....."+e);
		}
		String a;
		/*try
		{
			new FileOutputStream(j);
		}
		catch(Exception e2)
		{
			System.out.println("ERROR"+e2);
		} */
		try
		{
			PrintWriter out=new PrintWriter(cln.getOutputStream());
			/*BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("ENTER THE FILE NAME");
			String s1=br.readLine();
			//fname;*/
			File f=new File(s);
			if(f.exists())
			{
				BufferedReader d=new BufferedReader(new FileReader(s));
				String line;
				while((line=d.readLine())!=null)
				{
					out.write(line);
				}
				d.close();
			}
			out.close();
			cln.close();
		}
		catch(Exception e3)
		{
			System.out.println("error=---"+e3);
		}
	}
}
