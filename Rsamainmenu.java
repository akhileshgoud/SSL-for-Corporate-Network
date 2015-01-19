import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Rsamainmenu extends JFrame implements ActionListener
{
	JLabel jltitle=new JLabel("SECURING DATA USING RSA ",JLabel.CENTER);
	JLabel jlsecurity=new JLabel("Security Menu",JLabel.CENTER);
	JButton jbgenkeys=new JButton("Key Genaration");
	JButton jbktrans=new JButton("Key Transmission");
	JButton jbdencrypt=new JButton("Data Encryption");
	JButton jbddecrypt=new JButton("Data Decryption");
	JButton jbexit=new JButton("Exit");
	JPanel jp=new JPanel();
	Font f=new Font("Times Roman",Font.BOLD,25);
	Font f1=new Font("Times Roman",Font.BOLD,25);
	JPanel jptitle=new JPanel();
	public Rsamainmenu()
	{
		Container cp=this.getContentPane();
	               cp.setLayout(new BorderLayout());
		 jptitle.add(jltitle);
                	 jltitle.setFont(f);
		setTitle("DATA SECURITY");
		jlsecurity.setFont(f);
		jp.setLayout(null);
		jlsecurity.setBounds(300,100,200,30);
		jp.add(jlsecurity);
		jbgenkeys.addActionListener(this);
		jbgenkeys.setBounds(300,160,200,30);
		jp.add(jbgenkeys);
		jbktrans.addActionListener(this);
		jbktrans.setBounds(300,200,200,30);
		jp.add(jbktrans);
		jbdencrypt.setBounds(300,240,200,30);
		jp.add(jbdencrypt);
		jbdencrypt.addActionListener(this);
		jbddecrypt.setBounds(300,280,200,30);
		jp.add(jbddecrypt);
		jbddecrypt.addActionListener(this);
		jbexit.setBounds(300,320,200,30);
		jp.add(jbexit);
		jbexit.addActionListener(this);  
		cp.add(jptitle,BorderLayout.NORTH);
		cp.add(jp,BorderLayout.CENTER);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{            
				dispose();
                   		}
                  	});
		setSize(800,600);
	               setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==jbgenkeys)
		{
			genkeys gk=new genkeys();
			gk.setVisible(true);
		}
		if(ae.getSource()==jbktrans)
		{
			this .dispose();
			keyframe kf=new keyframe();
			kf.setVisible(true);
			ttcps tt=new ttcps();
		}
		if(ae.getSource()==jbdencrypt)
		{
			this.dispose();
			FrontEnd sfef=new FrontEnd();
			sfef.setVisible(true);
		}
		if(ae.getSource()==jbddecrypt)
		{
			this.dispose();
			BackEnd bef=new BackEnd();
			bef.setVisible(true);
		}
		if(ae.getSource()==jbexit)
		{
			this.dispose();	
		}                   
	}
	public static void main(String args[])
	{
		Rsamainmenu sf=new Rsamainmenu();
		sf.setVisible(true);
	}
}
