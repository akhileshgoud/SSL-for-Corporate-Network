/*class for calculation of e*/
import java.math.BigInteger;
public class E
{
	GCD g=new GCD();
	long e,i;
	static long r=0;
	long getE(long fun)
	{
		for(i=fun-2;i>2;i--)
		{
			r=g.getGCD(fun,i);
			if(r==1)
			{
				e=i; break; 
			}
		}       
		return e;
	}
}
