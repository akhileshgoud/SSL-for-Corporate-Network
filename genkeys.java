import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String.*;
import java.util.*;
import java.sql.*;
public class genkeys extends JFrame implements ActionListener
{
	int p;
	int q;
	long n=0;
	long fun=0;
	static long e,d ;
	JLabel jltitle=new JLabel("Generation of keys",JLabel.CENTER);
	JLabel jlappname=new JLabel("Select Prime 1:");
	JLabel jlname=new JLabel("Select Prime 2:");
	//JLabel jltype=new JLabel("Select Prime 2:");
	//JLabel jlsize=new JLabel("Field Size:");
	JLabel jldata=new JLabel("Keys:");
	JTextField jtfappname=new JTextField("",30);
	JTextField jtffname=new JTextField("",20);
	//JTextField jtfftype=new JTextField("",20);
	//JTextField jtffsize=new JTextField("",20);
	JTextArea jta=new JTextArea(10,15);
	JButton jbadd=new JButton("Generate");
	JButton jbremove=new JButton("Clear");
	JButton jbok=new JButton("OK");
	JPanel jpbutton=new JPanel();
	JPanel jpcontrol=new JPanel();
	JPanel jpta=new JPanel();
	JScrollPane jsp=null;
	Font f=new Font("Times Roman",Font.BOLD,25);
	public genkeys()
	{
		Container cp=getContentPane();
		cp.setLayout(new BorderLayout());
		jpbutton.setLayout(new FlowLayout());
		jpcontrol.setLayout(new GridLayout(4,1));
		jpta.setLayout(new BorderLayout());
		jltitle.setFont(f);
		jpcontrol.add(jlappname);            
		jpcontrol.add(jtfappname);
		jpcontrol.add(jlname);
		jpcontrol.add(jtffname);
		// jpcontrol.add(jltype);
		//jpcontrol.add(jtfftype);
		//jpcontrol.add(jlsize);
		//jpcontrol.add(jtffsize);
		jbadd.setMnemonic('A');
		jbremove.setMnemonic('R');
		jbok.setMnemonic('O');
		jpbutton.add(jbadd);
		jbadd.addActionListener(this);
		jpbutton.add(jbremove);
		jbremove.addActionListener(this);
		jpbutton.add(jbok);
		jbok.addActionListener(this);
		jpta.add(jldata,BorderLayout.NORTH);
		jsp=new JScrollPane(jta);
		jpta.add(new JPanel(),BorderLayout.WEST);
		jpta.add(jsp,BorderLayout.CENTER);
		cp.add(jltitle,BorderLayout.NORTH);
		cp.add(jpcontrol,BorderLayout.CENTER);
		cp.add(jpbutton,BorderLayout.SOUTH);
		cp.add(new JPanel(),BorderLayout.WEST);
		cp.add(jpta,BorderLayout.EAST);
		setSize(500,250);
		//setLocation(100,100);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==jbadd)
		{
			String s=jtfappname.getText();
			String ss=jtffname.getText();
			p=Integer.parseInt(s);
			q=Integer.parseInt(ss);
			int cp=0,cq=0,il;
			for(il=1;il<=p;il++)
			{
				if((p%il)==0)
					cp=cp+1;
                		}
                		for(il=1;il<=q;il++)
			{
				if((q%il)==0)
					cq=cq+1;
			}
			if((cp==2) && (cq==2))
			{
				JOptionPane.showMessageDialog(this,"PRIME","Message",JOptionPane.ERROR_MESSAGE);
				System.out.println("THE ENTERED NUMBERS ARE PRIME");
				n=p*q;
				fun=(p-1)*(q-1);
				E e1=new E();
				e=e1.getE(fun);
				EAlg ea=new EAlg();
				d=ea.getD(e,fun);
				System.out.println("the public key is:{"+e+","+n+"}");
				System.out.println("the private key is:{"+d+","+n+"}");
				jta.append("the public key is:{"+e+","+n+"}\n");
				jta.append("the private key is:{"+d+","+n+"}\n");	
				Connection con=null;
				Statement s1=null;
				String createString;
				String insertString;
				insertString="insert into ident2 values("+n+","+e+","+d+")";
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					//con=DriverManager.getConnection("jdbc:odbc:one");
					con=DriverManager.getConnection("jdbc:odbc:leodsn","scott","tiger");
					s1=con.createStatement();
					//String ss="insert into ident values('"+dn+"',"+add+"',"+no+"',"+pname+"',"+bus+"',"+id+"')";
					//s.executeUpdate(createString);
					s1.executeUpdate(insertString);
					s1.close();
					con.commit();
					con.close();
				}
				catch(Exception e)
				{
					System.out.println("there is an error during inserting"+e);
				}
			}
			else
				 JOptionPane.showMessageDialog(this,"NOT A PRIME","Message",JOptionPane.ERROR_MESSAGE);
		}
		if(ae.getSource()==jbremove)
		{
			jtfappname.setText("");
			jtffname.setText("");
			//jtfftype.setText("");
			//jtffsize.setText("");
			jta.setText("");                  
		}
		if(ae.getSource()==jbok)
		{
			this.dispose();
			/*
			keyframe kf=new keyframe();
			kf.setSize(800,600);
		               kf.setVisible(true);*/
		               /* FrontEnd sf1=new FrontEnd();
		                sf1.setVisible(true);*/                        
	               }
	}
	public static void main(String args[])
	{
		new genkeys(); 
	}
}

