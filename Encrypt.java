/*encryption*/

class Encrypt
{
 static long d;
 long getEncrypt(long n,long m,long e) 
 {
  d=1;
  ToBinary tb=new ToBinary();
  ToBinary tb1=tb.getBinary((long)e);

  int tsize=tb1.size;
  int b[]=new int[tsize];
  b=tb.a;      /* 'a' value consist of array of the binary no's.*/

  for(int k=tsize-1;k>=0;k--)
  {
    d=(d*d)%n;
    if(b[k]==1)
      d=(d*m)%n;
  }
  System.out.print((char)d);
  return d;
 }
}
