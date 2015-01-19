import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.rmi.*;
import java.awt.event.*;
public class client extends JFrame implements ActionListener
{
	Container cp=getContentPane();
	JLabel jltitle=new JLabel("CERTIFICATE ISSUED BY DEPT OF NSIC-COMPUTERS",JLabel.CENTER);
	JLabel l=new JLabel("");
	JScrollPane jsp=null;
	Font f=new Font("Times Roman",Font.BOLD,25);
	JPanel jp=new JPanel();
	JLabel l1=new JLabel("ENTER DOMAIN NAME:");
	JTextField t1=new JTextField(15);
	JLabel l7=new JLabel("IDENTITY");
	JPasswordField t2=new JPasswordField("",20);
	JLabel l2=new JLabel("LOCATION:");
	//JTextField t2=new JTextField(15);
	JLabel l3=new JLabel("PHONE NUMBER:");
	JTextField t3=new JTextField(15);
	JLabel l4=new JLabel("NATURE OF BUSINESS");
	JTextField t4=new JTextField(15);
	JLabel l5=new JLabel("AUTHORISED PERSON:");
	JLabel l6=new JLabel("IDENTITY");
	JTextField t5=new JTextField(15);
	JTextField t6=new JTextField(15);
	JButton b1=new JButton("GET");
	JButton b2=new JButton("EXIT");
	//Panel p1=new Panel();
	//nel p2=new Panel();Panel p3=new Panel();
	JTextArea ta=new JTextArea(15,15);
	public client()
	{
		setTitle("VIEW CERTIFICATE");
		cp.setLayout(new BorderLayout());
		jltitle.setFont(f);
		cp.add(jltitle,BorderLayout.NORTH);
		jp.setLayout(null);
		jp.add(l);
		l1.setBounds(80,100,100,30);
		jp.add(l1);
		t1.setBounds(250,100,300,30);
		jp.add(t1);
		l7.setBounds(80,150,100,30);
		jp.add(l7);
		l2.setBounds(80,200,100,30);
		jp.add(l2);
		t2.setBounds(250,150,300,30);
		jp.add(t2);
		l3.setBounds(80,250,110,30);
		jp.add(l3);
		t3.setBounds(250,300,300,30);
		//jp.add(t3);
		l4.setBounds(80,300,110,30);
		jp.add(l4);
		t4.setBounds(250,250,300,30);
		//jp.add(t4);
		l5.setBounds(80,350,150,30);
		jp.add(l5);
		t5.setBounds(250,300,300,30);
		//jp.add(t5);
		l6.setBounds(80,380,190,30);
		jp.add(l6);
		ta.setBounds(250,200,300,200);
		jp.add(ta);
		jp.add(b1);
		jp.add(b2);
		cp.add(jp,BorderLayout.CENTER);
		b1.setBounds(400,400,100,25);
		b1.addActionListener(this);
		b2.setBounds(500,400,100,25);
		b2.addActionListener(this);
		setSize(800,600);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e1)
	{
		String a=e1.getActionCommand();
		if(a.equals("GET"))
		{
			try
			{
				//String s="rmi://198.126.30.8/cce";
				//String s="rmi://192.100.100.25/cce";
				String s="rmi://localhost/cce";
				servin ser=(servin)Naming.lookup(s);
				//String res=ser.certify(s1,s2,s3,s4,s5);
				String s1=t1.getText();
				String res=ser.getcert(s1);
				System.out.println(res);
				ta.append(res);
			}
			catch(Exception e4)
			{
				System.out.println("error+--"+e4);
			}
		}
		if(a.equals("EXIT"))
			this.dispose();
	}               
	public static void main(String args[])
	{
		new client();
	}
}





