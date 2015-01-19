/*the file class*/
import java.io.*;

class showfile
{
String msg="";
int n=0;

 showfile getfile(String sout) throws IOException
 {
 InputStream  f=null;
 try{
  f=new FileInputStream(sout);
  n=f.available();
  }catch(Exception e){}
 for(int i=0;i<n;i++)
 { msg+=(char)f.read();  }
  f.close();
 return this;
 }

}
/*end of class*/
