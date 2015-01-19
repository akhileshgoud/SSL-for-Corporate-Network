import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.net.*;
public class keyframe extends JFrame implements ActionListener
{       Container cp=getContentPane();
	JButton jbcancel=new JButton("Cancel");	
	JButton jbcreate=new JButton("New Key");
        JButton jbtran=new JButton("TRASMIT"); 
	JLabel jltitle=new JLabel("Key Selection",JLabel.CENTER);
	Font f=new Font("Times Roman",Font.BOLD,25);
	JLabel jlekeys=new JLabel("Existing Keys");
        JLabel jn=new JLabel("(Nval-----Eval------Dval-----)");
        JLabel jns=new JLabel("N VALUE TO SEND:");
        JLabel jes=new JLabel("E VALUE TO SEND:");
        JLabel jfs=new JLabel("FILE NEEDED:");
        JLabel dom=new JLabel("DOMAIN NAME :");
        JTextArea ta=new JTextArea(10,15);
        JPanel jp=new JPanel();
        JPanel jpta=new JPanel();
        JScrollPane jsp=null;
JTextField ntb=new JTextField(10);
JTextField etb=new JTextField(10);
JTextField fnam=new JTextField(10);
JTextField jdom=new JTextField(25);
Connection con = null;
Statement s = null;
String createStr = null;
String insertString = null;
/**/
        public keyframe()
        {
        cp.setLayout(new BorderLayout());
        jltitle.setFont(f);
        jpta.setLayout(new BorderLayout());
        cp.add(jltitle,BorderLayout.NORTH);
        jp.setLayout(null);

        setTitle("Key Selection...");
        jltitle.setFont(f);

        setSize(600,400);
        setVisible(true);
		try{
                      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                      //con = DriverManager.getConnection("jdbc:odbc:once");
	       con=DriverManager.getConnection("jdbc:odbc:leodsn","scott","tiger");
		System.out.println("_________tiger________");
                      s = con.createStatement();
                      ResultSet rs=s.executeQuery("Select * from ident2");
		System.out.println("________while_______"+rs.next());
			int i=0;
                        String e1,n1,d1;
		while(rs.next())
                                {
			System.out.println("inside while..........");
		           n1=String.valueOf(rs.getInt("nval"));                         
                                        ta.append(n1);
			System.out.println("_____"+n1);
                                        ta.append("\t");
                                        e1=String.valueOf(rs.getInt("eval"));
                                        ta.append(e1);
                                        ta.append("\t");
                                        d1=String.valueOf(rs.getInt("dval"));
                                        ta.append(d1);
					System.out.println("Data reading"+i);
					i++;
                                        ta.append("\n");
				}
		   }catch(Exception ex){System.out.println("Error in data reading....keyframe....");}
                jn.setBounds(1,1,100,50);
                jpta.add(jn);
                ta.setBounds(10,50,10,50);
                jsp=new JScrollPane(ta);
                jpta.add(new JPanel(),BorderLayout.WEST);
                jpta.add(jsp,BorderLayout.WEST);

                jns.setBounds(10,100,250,20);
                jp.add(jns);
                ntb.setBounds(145,100,250,20);
                jp.add(ntb);
                jes.setBounds(10,140,250,20);
                jp.add(jes);
                etb.setBounds(145,140,250,20);
                jp.add(etb);
                jfs.setBounds(10,180,250,20);
                jp.add(jfs);
                fnam.setBounds(145,180,250,20);
                jp.add(fnam);
                dom.setBounds(10,220,250,20);
                jp.add(dom);
                jdom.setBounds(145,220,250,20);
                jp.add(jdom);
                jbcreate.setBounds(10,280,100,25);
                jp.add(jbcreate);
                jbcancel.setBounds(80,280,100,25);
                jp.add(jbcancel);
                jbtran.setBounds(170,280,100,25);
                jp.add(jbtran);


		jbcancel.addActionListener(this);
		jbcreate.addActionListener(this);
                jbtran.addActionListener(this);
                cp.add(jp,BorderLayout.CENTER);
                cp.add(jpta,BorderLayout.WEST);

	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==jbcancel)
		{
			this.dispose();
		}
		if(ae.getSource()==jbcreate)
                { this.dispose();
                genkeys gk=new genkeys();
                 gk.setVisible(true);
		}
                if(ae.getSource()==jbtran)
                {String todom=new String("");
                String npub=ntb.getText();
                String epub=etb.getText();
                String fname=fnam.getText();
                todom=jdom.getText();
                ttcp tc=new ttcp(npub,epub,fname);
                Rsamainmenu rmm=new Rsamainmenu();
                }
	}
	public static void main(String args[])
	{
                keyframe kf=new keyframe();
                kf.setVisible(true); 
	}
}
