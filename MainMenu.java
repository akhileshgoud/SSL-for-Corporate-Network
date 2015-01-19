import javax.swing.*;
import javax.swing.text.*;
import javax.swing.tree.*;
import javax.swing.tree.*;
import java.awt.event.*;
import java.awt.*;
public class MainMenu extends JFrame implements ActionListener
{
	JMenuBar mb;
	Container cp=null;
	JDesktopPane desktop=null;
	JInternalFrame internalframe=null;
	JPanel jp=new JPanel();
	JLabel jltitle=new JLabel("DATA SECURITY OVER CORPORATE NETWORK",JLabel.CENTER);
	JButton jbcert=new JButton("Registration");
	JButton jbappdev=new JButton("Authenticate");
	JButton jbocert=new JButton("View Certificate");
	JButton jbdsecurity=new JButton("Confidentiality");
	JButton jbdtrans=new JButton("Data Transmission");
	JButton jbexit=new JButton("Exit");
	Font f=new Font("Times Roman",Font.BOLD,25);
	public MainMenu()
	{
		//fserver fc=new fserver();
		//fc.frecieve();
		cp=getContentPane();
		cp.setLayout(new BorderLayout());
		setTitle("MAIN MENU");
		jltitle.setFont(f);
		jp.setLayout(null);
		jbcert.setBounds(300,100,200,30);
		jp.add(jbcert);
		jbappdev.setBounds(300,140,200,30);
		jp.add(jbappdev);
		jbocert.setBounds(300,180,200,30);
		jp.add(jbocert);
		jbdsecurity.setBounds(300,220,200,30);
		jp.add(jbdsecurity);
		jbdtrans.setBounds(300,260,200,30);
		jp.add(jbdtrans);
		jbexit.setBounds(300,300,200,30);
		jp.add(jbexit);
		cp.add(jltitle,BorderLayout.NORTH);
		cp.add(jp,BorderLayout.CENTER);
		jbcert.addActionListener(this);
		jbappdev.addActionListener(this);
		jbdsecurity.addActionListener(this);
		jbocert.addActionListener(this);
		jbdtrans.addActionListener(this);
		jbexit.addActionListener(this);
		/*        appdev.setMnemonic('A');
		datasecurity.setMnemonic('S');
		datatrans.setMnemonic('T');
		m1e.setMnemonic('x');
		m1e.addActionListener(this);         
		m2k.addActionListener(this);
		appdev.addActionListener(this);
		datasecurity.addActionListener(this);
		datatrans.addActionListener(this);
		about.addActionListener(this);*/
		setJMenuBar(mb);
		setSize(800,600);
		setVisible(true);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{            
				System.exit(0);
			}
		});
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==jbcert)
		 {
			client1 c=new client1();
			/*SoftwareDemo sf=new SoftwareDemo();
			sf.setVisible(true);                      */
		}
		if(ae.getSource()==jbappdev)
		{
			communi com=new communi("TOSERVER");
			com.setVisible(true);
			/*SoftwareDemo sf=new SoftwareDemo();
			sf.setVisible(true);                      */
		}
		if(ae.getSource()==jbocert)
		{
			client cl=new client();//"VIEW CERTIFICATE");
			cl.setVisible(true);
		}
		if(ae.getSource()==jbdsecurity)
		{
			Rsamainmenu rmm=new Rsamainmenu();
		}
		if(ae.getSource()==jbdtrans)
		{
			filetran ft=new filetran();
			ft.setVisible(true);
			/*TransmissionFrame tf=new TransmissionFrame();
			tf.setVisible(true); */
			tests fser=new tests();
		}
		if(ae.getSource()==jbexit)
		{
			System.exit(0);
		}
	}
	public static void main(String args[])
	{
		new MainMenu();
	}
}
