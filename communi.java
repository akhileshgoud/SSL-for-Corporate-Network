import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.rmi.*;
import java.awt.event.*;
public class communi extends JFrame implements ActionListener
{
	Container cp=null;
	JLabel jltitle=new JLabel("REQUESTING THE SERVER FOR COMMUNICATION",JLabel.CENTER);
	Font f=new Font("Times Roman",Font.BOLD,25);
	JPanel jp=new JPanel();
	JLabel l1=new JLabel("DOMAIN NAME:");
	JTextField t1=new JTextField(15);
	JLabel l2=new JLabel("IDENTITY");
	JPasswordField t2=new JPasswordField("",20);
	//JTextField t2=new JTextField(15);
	JButton b1=new JButton("ENTER");
	JButton b2=new JButton("CANCEL");
	public communi(String tit)
	{
		super(tit);
		cp=getContentPane();
		cp.setLayout(new BorderLayout());
		jltitle.setFont(f);
		cp.add(jltitle,BorderLayout.NORTH);
		jp.setLayout(null);
		l1.setBounds(80,100,100,30);
		jp.add(l1);
		t1.setBounds(250,100,300,30);
		jp.add(t1);
		l2.setBounds(80,150,100,30);
		jp.add(l2);
		t2.setBounds(250,150,300,30);
		jp.add(t2);
		b1.setBounds(270,250,100,25);
		jp.add(b1);
		b2.setBounds(370,250,100,25);
		jp.add(b2);
		cp.add(jp,BorderLayout.CENTER);
		b1.addActionListener(this);
		b2.addActionListener(this);
		setVisible(true);
		setSize(800,600);
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
				System.out.println("S1"+s1);
				System.out.println("S2"+s2);
				//String s="rmi://198.126.30.8/sse";
				//String s="rmi://192.100.100.25/sse";
				String s="rmi://localhost/sse";
				System.out.println(".........sse...."+s);
				serint ser1=(serint)Naming.lookup(s);
				System.out.println(".........ser1........"+ser1);
				ser1.check(s1,s2);
			}
			catch(Exception e)
			{
				System.out.println("ERROR DURING CONECTION ...communi"+e);
			}
		}
		if(a.equals("CANCEL"))
		{
			this.dispose();
		}
	}
	public static void main(String args[])
	{
		new communi("samp");
		System.out.println("communi");
	}
}
