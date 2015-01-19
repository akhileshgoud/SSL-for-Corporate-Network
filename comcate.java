import java.io.*;
import java.applet.*;
import java.awt.*;
import java.rmi.*;
import java.awt.event.*;
public class comcate extends Frame implements ActionListener
{
Label l=new Label("WELCOME TO THE COMMUNICATION AREA OF SECURING WEBSERVERS");
Label l1=new Label("DOMAIN NAME:");
TextField t1=new TextField(15);
Label l2=new Label("IDENTITY");
TextField t2=new TextField(15);
Button b1=new Button("ENTER");
comcate(String tit)
{
super(tit);
add(l);
add(l1);
add(t1);
add(l2);
add(t2);
l1.setBounds(80,100,100,30);
l2.setBounds(80,150,100,30);
t1.setBounds(250,100,300,30);
t2.setBounds(250,150,300,30);
b1.setBounds(300,200,120,45);
//b2.setBounds(500,400,160,45);
add(b1);
b1.addActionListener(this);
setLayout(null);
setBackground(Color.gray);
}
public void actionPerformed(ActionEvent e1)
{
String a=e1.getActionCommand();
if(a.equals("ENTER"))
{
try
{
String s1,s2,s3;
s1=t1.getText();
s2=t2.getText();
//String s="rmi://192.165.0.9/sse";
//String s="rmi://192.100.100.25/sse";
String s="rmi://localhost/sse";
serint ser1=(serint)Naming.lookup(s);
ser1.check(s1,s2);
}
catch(Exception e)
{
System.out.println("ERROR DURING CONECTION"+e);}
}
}
}
