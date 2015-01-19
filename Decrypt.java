/*decryption*/
public class Decrypt
{
 static long x;
public int getDecrypt(long n,long m,long d)
 {
  x=1;
  ToBinary tb=new ToBinary();
  ToBinary tb1=tb.getBinary((long)d);
  int tsize=tb1.size;
  int b[]=new int[tsize];
  b=tb.a;       /* 'a' consist of array of binary codes*/
  for(int k=tsize-1;k>=0;k--)
  {
    x=(x*x)%n;
    if(b[k]==1)
      x=(x*m)%n;
  }
  System.out.print((char)x);
  return (int)x;
 }
}

