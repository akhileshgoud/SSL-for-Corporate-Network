import java.io.*;
class eval
{
public static void main(String args[]) throws IOException
{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int p,q,n,m,e,i,j,h=0;
System.out.println("ENTER TWO NUMBERS FOR P,Q");
String s,s1;
s=br.readLine();
p=Integer.parseInt(s);
s1=br.readLine();
q=Integer.parseInt(s);
n=p*q;
m=((p-1)*(q-1));
for(i=1;i<n;i++)
{
int k=i;
for(j=2;j<k;j++)
{
if((k%j)==0)
{h=1;
break;
}
}
if(h==0)
System.out.println(k);
}
}
}


