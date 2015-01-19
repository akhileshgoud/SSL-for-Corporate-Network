import java.io.*;
import java.math.BigInteger;
//import java.security.SecureRandom;
class Rsa
{
	protected BigInteger n, d, e, m;
	public Rsa(long n1,long e1)
	{
		/*    BigInteger p = new BigInteger("97");
		BigInteger q = new BigInteger("83");
		n = p.multiply(q);
		m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		//    E e1=new E();
		e = new BigInteger("3");
		System.out.println(e);
		while(m.gcd(e).intValue() > 1) e = e.add(new BigInteger("2"));
		d = e.modInverse(m);
		//System.out.println(e);
		System.out.println(d);
		System.out.println(e);*/
		/*    n=new BigInteger("2078418421");
		e=new BigInteger("2078323741");*/
		d=new BigInteger("692774581");
		n=BigInteger.valueOf(n1);
		e=BigInteger.valueOf(e1);
		//    d=BigInteger.valueOf(d1);
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
	//  public static void main(String args[]) throws Exception
	fencdec(String fname,String efile,long n1,long e1)
	{
		 // long n1=143;
		// long e1=113;
		Rsa obj = new Rsa(n1,e1);
		try
		{
			FileInputStream fis = new FileInputStream(fname);//args[0]);
			FileOutputStream fos = new FileOutputStream(efile);//args[1]);
			//     FileOutputStream fos1 = new FileOutputStream(args[2]);
			//  char ech[];// = new char[fis.available()];
			// char dch[];// = new char[fis.available()];
			char ech[] = new char[fis.available()];
			char dch[] = new char[fis.available()];
			int i;
			// char ch[] = new char[fis.available()];
			int k=0;
			try
			{
				while((i = fis.read())!= -1)
				{
					String s1 = String.valueOf(i);
					BigInteger bi = new BigInteger(s1);
					BigInteger bc = obj.encrypt(bi);
					int x = bc.intValue();
					ech[k]=(char)x;
					fos.write(ech[k]);
					/*        BigInteger bp = obj.decrypt(bc);
					int y = bp.intValue();
					dch[k]=(char)y;
					fos.write(dch[k]);
					k++;*/
				}
			}
			catch(Exception e)	
			{
				System.out.println("ERROR"+e);
			}
			String estr  = new String(ech);
			String dstr  = new String(dch);
			System.out.println("Encryped String :" + estr);
			System.out.println("Decryped String :" + dstr);
			fis.close();
			fos.close();
		}
		catch(Exception e2)
		{
			System.out.println("ERROR"+e2);
		}
	}
}
