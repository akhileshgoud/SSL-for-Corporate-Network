/* calculation of gcd of two no's */
import java.math.BigInteger;
class GCD
{
	long r=0;
	long getGCD(long a,long b)
	{
		if(a>b)
		{
			long temp =a;
			a=b;
			b=temp;
		}
		while((int)(r=b%a)!=0)
		{
			b=a;
			a=r;
		}
		return a;
	} /*end of method getGCD*/
}
