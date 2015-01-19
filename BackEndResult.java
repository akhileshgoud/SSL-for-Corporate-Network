import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class BackEndResult extends JFrame implements ActionListener
{
   JButton jbexit = new JButton("Close");
   JPanel jp=new JPanel();

   JLabel jltitle=new JLabel("File Decryption Data",JLabel.CENTER);
   Font f=new Font("Times Roman", Font.BOLD, 25);

   JLabel jlfname=new JLabel("File To Decrypt");
   JTextField jtffname=new JTextField("",20);
   JLabel jlsf=new JLabel("Save Decrypted File As");
   JTextField jtfsf=new JTextField("",20);
   JLabel jlkey1=new JLabel("Enter Key");
   JTextField jtfkey1=new JTextField("",20);
   JLabel jlkey2=new JLabel("Enter Decrypted Key");
   JTextField jtfkey2=new JTextField("",20);

   JLabel jloption=new JLabel("Remove Original File");
   JRadioButton jrbyes=new JRadioButton("Yes");
   JRadioButton jrbno=new JRadioButton("No");
   ButtonGroup bg=new ButtonGroup();
   JPanel jrbpanel=new JPanel();

   JLabel jlresult=new JLabel("Process Successful");

   String  data[]=new String[5];
  

   public BackEndResult(String data[])
   {
      Container cp = getContentPane();

      this.data=data;

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

      jbexit.setBounds(250,250,150,25);
      jp.add(jbexit);

      jrbno.setSelected(true);


      Font ff=new Font("Times Roman", Font.BOLD, 12);
      jtffname.setFont(ff);
      jtfsf.setFont(ff);
      jtfkey1.setFont(ff);
      jtfkey2.setFont(ff);


      cp.add(jltitle, BorderLayout.NORTH);
      cp.add(jp, BorderLayout.CENTER);

      jtffname.setText(this.data[0]);
      jtfsf.setText(this.data[1]);
      jtfkey1.setText(this.data[2]);
      jtfkey2.setText(this.data[3]);

      String option=data[4];

      if(option.equals("yes"))
      {
         jrbyes.setSelected(true);
      }
      

      jbexit.setMnemonic('C');

      setTitle("Decryption Interface");
      setSize(800, 600);

          addWindowListener(new WindowAdapter()
          {
           public void windowClosing(WindowEvent we)
           {            
                dispose();
             /*   SecurityFrame sf1=new SecurityFrame();
                sf1.setVisible(true);*/
           }
          });


      jbexit.addActionListener(this);
   }

   public void actionPerformed(ActionEvent ae)
   {
      String fname=null;
      String namef=null;


      if (ae.getSource() == jbexit)
      {
                this.dispose();
/*                SecurityFrame sf1=new SecurityFrame();
                sf1.setVisible(true);*/

      }
   }
}
