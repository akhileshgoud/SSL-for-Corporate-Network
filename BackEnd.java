import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
public class BackEnd extends JFrame implements ActionListener
{
	JButton jbdec = new JButton("Decrypt");
	JButton jbexit = new JButton("Exit");
	JButton jbself = new JButton("Select");
	JPanel jp=new JPanel();
	JLabel jltitle=new JLabel("File Decryption",JLabel.CENTER);
	Font f=new Font("Times Roman", Font.BOLD, 25);
	JLabel jlfname=new JLabel("File To Decrypt");
	JTextField jtffname=new JTextField("",20);
	JLabel jlsf=new JLabel("Save Decrypted File As");
	JTextField jtfsf=new JTextField("",20);
	JLabel jlkey1=new JLabel("Enter N value");
	JPasswordField jtfkey1=new JPasswordField("",20);
	JLabel jlkey2=new JLabel("Enter D value");
	JPasswordField jtfkey2=new JPasswordField("",20);
	JLabel jloption=new JLabel("Remove Original File");
	JRadioButton jrbyes=new JRadioButton("Yes");
	JRadioButton jrbno=new JRadioButton("No");
	ButtonGroup bg=new ButtonGroup();
	JPanel jrbpanel=new JPanel();
	String optionvalue="no";
	public BackEnd()
	{
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		jp.setLayout(null);
		jrbpanel.setLayout(new FlowLayout());
		jltitle.setFont(f);
		Border etched1=BorderFactory.createEtchedBorder();
		jrbpanel.setBorder(BorderFactory.createTitledBorder(etched1,"File Status")); 
		jp.setBorder(BorderFactory.createTitledBorder(etched1,null)); 
		bg.add(jrbyes);
		bg.add(jrbno);
		jrbpanel.add(jrbyes);
		jrbpanel.add(jrbno);
		jlfname.setBounds(20,50,150,25);
		jp.add(jlfname);
		jtffname.setBounds(170,50,250,25);
		jp.add(jtffname);
		jbself.setBounds(430,50,100,25);
		jp.add(jbself);
		jlsf.setBounds(20,80,150,25);
		jp.add(jlsf);
		jtfsf.setBounds(170,80,250,25);
		jp.add(jtfsf);
		jlkey1.setBounds(20,110,150,25);
		jp.add(jlkey1);
		jtfkey1.setBounds(170,110,250,25);
		jp.add(jtfkey1);
		jlkey2.setBounds(20,140,150,25);
		jp.add(jlkey2);
		jtfkey2.setBounds(170,140,250,25);
		jp.add(jtfkey2);
		jloption.setBounds(20,190,150,25);
		jp.add(jloption);
		jrbpanel.setBounds(170,170,250,60);
		jp.add(jrbpanel);
		jbdec.setBounds(20,250,150,25);
		jp.add(jbdec);
		jbexit.setBounds(250,250,150,25);
		jp.add(jbexit);
		Font ff=new Font("Times Roman", Font.BOLD, 12);
		jtffname.setFont(ff);
		jtfsf.setFont(ff);
		jtfkey1.setFont(ff);
		jrbno.setSelected(true);
		cp.add(jltitle, BorderLayout.NORTH);
		cp.add(jp, BorderLayout.CENTER);
		jbself.setMnemonic('S');
		jbdec.setMnemonic('D');
		jbexit.setMnemonic('x');jbdec.addActionListener(this);
		jbself.addActionListener(this);
		jbexit.addActionListener(this);
		jrbyes.addActionListener(this);
		jrbno.addActionListener(this);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{            
				dispose();
				Rsamainmenu sf1=new Rsamainmenu();
				sf1.setVisible(true);
			}
		});
		setTitle("Decryption Interface");
		setSize(800, 600);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String fname=null;
		String namef=null;
		if(ae.getSource()==jrbyes)
		{
			optionvalue="yes";
		}
		if(ae.getSource()==jrbno)
		{
			optionvalue="no";
		}
		if (ae.getSource() == jbself)
		{
			JFileChooser chooser = new JFileChooser();
			ExampleFileFilter filter = new ExampleFileFilter();
			filter.addExtension("rsa");
			chooser.setFileFilter(filter);    
			int returnVal = chooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				System.out.println("You chose to open this file: " +chooser.getSelectedFile().getName());
				fname=chooser.getSelectedFile().toString();
				jtffname.setText(fname);
			}
		}
		if (ae.getSource() == jbdec)
		{
			long n,d;
			String efile=jtffname.getText();	
			String dfile=jtfsf.getText();
			n=Long.parseLong(jtfkey1.getText());
			d=Long.parseLong(jtfkey2.getText());
			fencdec1 fdec=new fencdec1(efile,dfile,n,d);
			this.dispose();
			Rsamainmenu rsamain=new Rsamainmenu();
			rsamain.setVisible(true);
			MyDialog md=new MyDialog("Your File is Decrypted Successfully");
		}
		if (ae.getSource() == jbexit)
		{
			this.dispose();
			Rsamainmenu sf1=new Rsamainmenu();
			sf1.setVisible(true);
		}
	}
	public static void main(String args[])
	{
		BackEnd m=new BackEnd();	
		m.setVisible(true);
	}
}
 
