import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;
public class FrontEnd extends JFrame implements ActionListener
{
	JButton jbenc = new JButton("Encrypt");
	JButton jbexit = new JButton("Exit");
	JButton jbself = new JButton("Select");
	JButton jbclear = new JButton("Clear All");
	JButton jbselectkey = new JButton("New Keys");
	JLabel jltacont = new JLabel("Selected File: ");
	JLabel jlsfname=new JLabel("File To Encrypt");
	JTextField jtfsfname=new JTextField("",20);
	JLabel jlftsave=new JLabel("Save File As");
	JTextField jtfftsave=new JTextField("",20);
	JLabel jlkey1=new JLabel("N value");
	JPasswordField jtfkey1=new JPasswordField("",20);
	JLabel jlkey2=new JLabel("E value");
	JPasswordField jtfkey2=new JPasswordField("",20);
	JTextArea jta = new JTextArea(25, 35);
	JPanel jp=new JPanel();
	JLabel jltitle=new JLabel("Data Encryption",JLabel.CENTER);
	Font f=new Font("Times Roman", Font.BOLD, 25);
	JLabel jloption=new JLabel("Remove Original File");
	JRadioButton jrbyes=new JRadioButton("Yes");
	JRadioButton jrbno=new JRadioButton("No");
	ButtonGroup bg=new ButtonGroup();
	JPanel jrbpanel=new JPanel();
	JPanel jpta=new JPanel();
	JFileChooser chooser = new JFileChooser();
	String optionvalue="no";
	public FrontEnd()
	{
		Container cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		jpta.setLayout(new BorderLayout());
		jp.setLayout(null);
		jltitle.setFont(f);
		bg.add(jrbyes);
		bg.add(jrbno);
		Border etched1=BorderFactory.createEtchedBorder();
		jrbpanel.setBorder(BorderFactory.createTitledBorder(etched1,"File Status"));
		jp.setBorder(BorderFactory.createTitledBorder(etched1,""));
		jrbpanel.add(jrbyes);
		jrbpanel.add(jrbno);
		jrbno.setSelected(true);
		jlsfname.setBounds(20,50,150,25);
		jp.add(jlsfname);
		jtfsfname.setBounds(170,50,200,25);
		jp.add(jtfsfname);
		jbself.setBounds(370,50,150,25);
		jp.add(jbself);
		jlftsave.setBounds(20,80,150,25);
		jp.add(jlftsave);
		jtfftsave.setBounds(170,80,200,25);
		jp.add(jtfftsave);
		jlkey1.setBounds(20,110,150,25);
		jp.add(jlkey1);
		jtfkey1.setBounds(170,110,200,25);
		jp.add(jtfkey1);
		jlkey2.setBounds(20,140,150,25);
		jp.add(jlkey2);
		jtfkey2.setBounds(170,140,200,25);
		jp.add(jtfkey2);
		jbselectkey.setBounds(370,170,150,25);
		jp.add(jbselectkey);
		jloption.setBounds(20,200,150,25);
		jp.add(jloption);
		jrbpanel.setBounds(170,200,200,60);
		jp.add(jrbpanel);
		jbenc.setBounds(30,300,100,25);
		jp.add(jbenc);
		jbclear.setBounds(230,300,100,25);
		jp.add(jbclear);
		jbexit.setBounds(330,300,100,25);
		jp.add(jbexit);
		Font f1=new Font("Times Roman", Font.BOLD, 12);
		jtfftsave.setFont(f1);
		jtfsfname.setFont(f1);
		jtfkey1.setFont(f1);
		jtfkey2.setFont(f1);
		jbenc.setEnabled(false);
		jbself.setMnemonic('S');
		jbenc.setMnemonic('E');
		jbexit.setMnemonic('x');
		jbclear.setMnemonic('A');
		jbself.addActionListener(this);
		jbenc.addActionListener(this);
		jbexit.addActionListener(this);
		jbclear.addActionListener(this);
		jbselectkey.addActionListener(this);
		jrbyes.addActionListener(this);
		jrbno.addActionListener(this);
		cp.add(jltitle, BorderLayout.NORTH);
		cp.add(jp, BorderLayout.CENTER);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{            
				dispose();
				Rsamainmenu sf1=new Rsamainmenu();sf1.setVisible(true);
			}
		});
		setTitle("Encryption Interface");
		setSize(500,400);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String fname=null;
		String namefile=null;
		String namef=null;
		String msg=null;
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
			int returnVal = chooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				java.io.File filechoosen=chooser.getSelectedFile();
				fname=filechoosen.toString();
				System.out.println("You chose to open this file: " +fname);
			}
			jtfsfname.setText(fname.toString());
			jbenc.setEnabled(true);
		}
		if (ae.getSource() == jbenc)
		{
			if(jtfkey1.getText()!=null && jtfkey2.getText()!=null)
			{
				//        NsicRsa nr=new NsicRsa(jtfsfname.getText(),"Encrypt",jtfftsave.getText());
				long n1,e1;
				n1=Long.parseLong(jtfkey1.getText());
				e1=Long.parseLong(jtfkey2.getText());
				fencdec fenc=new fencdec(jtfsfname.getText(),jtfftsave.getText(),n1,e1);
				/* String data[]=new String[5];
				data[0]=jtfsfname.getText();
				data[1]=jtfftsave.getText()+".rsa";
				data[2]=jtfkey1.getText();
				data[3]=nr.getKey()+"";
				data[4]=optionvalue;
				System.out.println("the value of encryption key is:"+nr.getKey());*/
				this.dispose();
				Rsamainmenu rsamain=new Rsamainmenu();
				rsamain.setVisible(true);
				MyDialog md=new MyDialog("Your File is Encrypted Successfully");//,"Encrypt",data);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Password Incorrect","Error..",JOptionPane.ERROR_MESSAGE);
			}
		}
		if (ae.getSource() == jbexit)
		{
			this.dispose();
			Rsamainmenu sf1=new Rsamainmenu();
			sf1.setVisible(true);
		}
		if (ae.getSource() == jbclear)
		{
			jtfsfname.setText("");
			jtfftsave.setText("");
			jtfkey1.setText("");
			jtfkey2.setText("");
			jbenc.setEnabled(false);
		}
		if (ae.getSource() == jbselectkey)
		{
			genkeys ks=new genkeys();
			ks.setVisible(true);
		}
	}	
	public static void main(String args[])
	{
		FrontEnd m=new FrontEnd();	
		m.setVisible(true);
	}
}


