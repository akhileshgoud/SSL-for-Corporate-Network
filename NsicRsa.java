import java.io.*;
// import java.lang.Math;
import java.sql.*;


public class NsicRsa
{long p=17,q=23;
// long p=34589, q=60089;
 long n=0,fun=0;
 static long e,d ;
 String  yorn="n";
 byte barray[]=new byte[10];
 int fsize=0;
  String msg=null;
  static long keyvalue;

  //Connect cnr=new Connect();

  public NsicRsa(String fname,String type,String filetosave)
  {
   n=p*q;
   fun=(p-1)*(q-1);
   E e1=new E();
   e=e1.getE(fun);
   EAlg ea=new EAlg();
   long d=ea.getD(e,fun);

   System.out.println("the public key is:{"+e+","+n+"}");
   System.out.println("the private key is:{"+d+","+n+"}");
   System.out.println("the file name is:"+fname);

   /* entering the text*/


    /* try{
		   String str="insert into EDATA values(?,?,?,?)";
		   PreparedStatement ps=cnr.con.prepareStatement(str);
		   ps.setString(1,fname+"");
		   ps.setString(2,filetosave+"");
		   ps.setString(3,e+"");
		   ps.setString(4,n+"");
		   int i=ps.executeUpdate();
           System.out.println("Data inserted.."+i);
        }catch(Exception ex){System.out.println("the values con't be stored...");}*/

	SaveFile sc=new SaveFile();

    if(type.equals("Encrypt"))
    {


    showfile sf=new showfile();
    try{
        showfile sff=sf.getfile(fname);
        this.msg=sff.msg;
        barray=msg.getBytes();
    }catch(Exception ex){System.out.println("error ");}


    System.out.print("the barraylength string is:"+barray.length);   


    keyvalue=e;
    System.out.print("the Encrypted string is:");

    Encrypt enc=new Encrypt();

    fsize=msg.length();
    long edata[]=new long[fsize];
            for(int z=0;z<barray.length;z++)
            {
                    edata[z]=enc.getEncrypt(n,barray[z],e);
            }
            sc.saveCipher(edata,filetosave);
    }
    if(type.equals("Decrypt"))
    {
            keyvalue=d;
            System.out.println("The Decyted string is");
            Decrypt dec=new Decrypt();

            int ddata[]=null;
            System.out.println(fname);

            try{
            InputStream fis=new FileInputStream(fname);
            DataInputStream dis=new DataInputStream(fis);

            int size=dis.available();
            size=size/8;
            System.out.println("the size of the file is:"+size);
            ddata=new int[size];

            for(int s=0;s<size;s++)
            {
                ddata[s]=dec.getDecrypt(n,dis.readLong(),d);
            }
            }catch(IOException ioex){System.out.println("Error in file");}

            sc.saveFile(ddata,filetosave);
    }
  }
  public long getKey()
  {
        return keyvalue;
  }

 public static void main(String args[])
 {        

        NsicRsa rs= new NsicRsa("d:\\ssl\\data","Encrypt","temp.rsa");
        NsicRsa rs1= new NsicRsa("d:\\ssl\\nsicSecurity\\temp.rsa","Decrypt","temp.java");
 }
}
