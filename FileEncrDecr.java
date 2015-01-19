import java.io.*;
import java.math.BigInteger;
import java.security.SecureRandom;

class Rsa
{
  protected BigInteger n, d, e, m;
            
  public Rsa()
  {
    BigInteger p = new BigInteger("7");
    BigInteger q = new BigInteger("19");
    n = p.multiply(q);
    m = (p.subtract(BigInteger.ONE))
                   .multiply(q.subtract(BigInteger.ONE));
    e = new BigInteger("3");
    while(m.gcd(e).intValue() > 1) e = e.add(new BigInteger("2"));
    d = e.modInverse(m);
  }

  public BigInteger encrypt(BigInteger message)
  {
     return message.modPow(e, n);
   }

  public BigInteger decrypt(BigInteger message)
  {
     return message.modPow(d, n);
   }

}

public class fencdec
{
  public static void main(String args[]) throws Exception
  {
     Rsa obj = new Rsa();

     FileInputStream fis = new FileInputStream(args[0]);
     FileOutputStream fos = new FileOutputStream(args[1]);

     char ech[] = new char[fis.available()];
     char dch[] = new char[fis.available()];
     int i;
    // char ch[] = new char[fis.available()];
     int k=0;
     while((i = fis.read())!= -1)

     {
        String s1 = String.valueOf(i);

        BigInteger bi = new BigInteger(s1);
        BigInteger bc = obj.encrypt(bi);
        int x = bc.intValue();
        ech[k]=(char)x;
       
        fos.write(x);
        BigInteger bp = obj.decrypt(bc);
        int y = bp.intValue();
        dch[k]=(char)y;
         k++;

      }

     String estr  = new String(ech);
     String dstr  = new String(dch);
     System.out.println("Encryped String :" + estr);
     System.out.println("Decryped String :" + dstr);
     fis.close();
     fos.close();
   }
}
