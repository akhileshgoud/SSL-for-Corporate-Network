import java.io.*;
import java.net.*;
public class fserver
{
	public static void main(String args[]) throws IOException
	{
		ServerSocket ser=null;
		Socket cln=null;
		PrintWriter out=null;
		BufferedReader br=null;
		BufferedReader in=null;
		try
		{
			//InetAddress ia=InetAddress.getByName("198.126.30.8");
			//InetAddress ia=InetAddress.getByName("192.100.100.25");
			InetAddress ia=InetAddress.getByName("127.0.0.1");
			ser=new ServerSocket(95,5,ia);
			cln=ser.accept();
		}
catch(Exception e){System.out.println("error:--"+e);}
String a;
StringBuffer sb=new StringBuffer(700);
sb.append("welcome ravi:__________________");
try
{
in=new BufferedReader(new InputStreamReader(System.in));
br=new BufferedReader(new InputStreamReader(cln.getInputStream()));
out=new PrintWriter(cln.getOutputStream(),true);
RandomAccessFile fout=new RandomAccessFile("temp.txt","rw");
System.out.println("file created");
while(true)
{System.out.println("loop entered");
String s=br.readLine();
System.out.println(s);
/*if((a=br.readLine())!=null)
{
System.out.println(a);
sb.append("\n");
sb.append(a);
sb.append("\t\n");
//fout.writeBytes(a);
}*/
}
//System.out.println("THE FILE HAS:-\n"+sb);
}
catch(Exception e3)
{System.out.println("error/:"+e3);
}
//System.out.println(sb);
try
{
in.close();
br.close();
cln.close();
}
catch(Exception e4){}
}
}


