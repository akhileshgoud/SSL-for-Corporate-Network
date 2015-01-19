
/* saving the cipher into a file*/

import java.io.*;

class SaveFile
{
 OutputStream out=null;

 public void saveCipher(long bytefile[],String fname)
 {
 try{
  out=new FileOutputStream(fname);
  DataOutputStream dos=new DataOutputStream(out);
  for(int i=0;i<bytefile.length;i++)
  dos.writeLong(bytefile[i]);
  System.out.println(fname+" is created");
  }catch(Exception e){}
 }

 public void saveFile(int filedata[],String fname)
 {
 try{
  out=new FileOutputStream(fname);
  for(int i=0;i<filedata.length;i++)
  out.write(filedata[i]);
  System.out.println(fname+" is created");
  }catch(Exception e){}
 }
}
/* end of the savingfile class*/
