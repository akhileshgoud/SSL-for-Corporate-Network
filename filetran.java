import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
//import javax.swing.border.*;
public class filetran extends JFrame implements ActionListener
{
	Container cp=getContentPane();
	JPanel jp=new JPanel();
	JButton jbexit = new JButton("Exit");
	JButton jbtrans = new JButton("Transmit");
	JButton jbclear = new JButton("Clear All");
	JLabel fname = new JLabel("File To Transefer");
	JLabel sername=new JLabel("To Server");
	JTextField fnam=new JTextField("",20);
	JTextField snam=new JTextField("",20);
	JLabel title=new JLabel("File Transmission",JLabel.CENTER);
	Font f=new Font("Times Roman", Font.BOLD, 25);
	public filetran()
	{
		cp.setLayout(new BorderLayout());
		cp.add(title,BorderLayout.NORTH);
		jp.setLayout(null);
		title.setFont(f);
		fname.setBounds(80,100,100,30);
		jp.add(fname);
		fnam.setBounds(250,100,200,20);
		jp.add(fnam);
		sername.setBounds(80,150,100,30);
		jp.add(sername);
		snam.setBounds(250,150,200,20);
		jp.add(snam);
		jbtrans.setBounds(130,300,100,25);     
		jp.add(jbtrans);
		jbclear.setBounds(230,300,100,25);
		jp.add(jbclear);
		jbexit.setBounds(330,300,100,25);
		jp.add(jbexit);
		Font f1=new Font("Times Roman", Font.BOLD, 12);
		fnam.setFont(f1);
		snam.setFont(f1);
		jbexit.setMnemonic('X');
		jbtrans.setMnemonic('T');
		jbclear.setMnemonic('A');
		jbexit.addActionListener(this);
		jbtrans.addActionListener(this);
		jbclear.addActionListener(this);
		cp.add(jp,BorderLayout.CENTER);
		setVisible(true);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{            
				dispose();
				Rsamainmenu sf1=new Rsamainmenu();
				sf1.setVisible(true);
           			}
          		});
		setTitle("File Transmission Interface");
		setSize(500,400);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String fname=null;
		String namefile=null;
		String namef=null;
		String msg=null;
      		if (ae.getSource() == jbexit)
		{
			this.dispose();
			Rsamainmenu sf1=new Rsamainmenu();
			sf1.setVisible(true);
		}
		if (ae.getSource() == jbtrans)
		{
			String encf=fnam.getText();
			testc fcln=new testc(encf);
			this.dispose();
			Rsamainmenu sff=new Rsamainmenu();
		}
		if (ae.getSource() == jbclear)
		{
			fnam.setText("");
			snam.setText("");
		}
	}
	public static void main(String args[])
	{
		filetran m=new filetran();
		m.setVisible(true);
	}
}


