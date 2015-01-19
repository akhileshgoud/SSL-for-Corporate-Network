import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyDialog extends JDialog implements ActionListener
{

   JLabel jlthanks=new JLabel("",JLabel.CENTER);
   JLabel jlicon=new JLabel("",JLabel.CENTER);
   JButton jbthanks=new JButton("OK");
   JPanel jpthanks=new JPanel();
   Font fthanks=new Font("Times Roman", Font.BOLD, 16);

        public MyDialog(String msg)//,String type,String data[])
        {
           super((Frame)null);
         Container jdcp=getContentPane();
         setTitle("Message...");
		 jlthanks.setText(msg);
              jlthanks.setFont(fthanks);
              jpthanks.add(jbthanks);

         jdcp.setLayout(new BorderLayout());
         jdcp.add(jlthanks,BorderLayout.CENTER);
         jdcp.add(jpthanks,BorderLayout.SOUTH);
         setSize(300,120);
         setLocation(200,200);
         setResizable(false);
         setVisible(true);
         jbthanks.addActionListener(this);

          addWindowListener(new WindowAdapter()
          {
           public void windowClosing(WindowEvent we)
           {            
                dispose();
/*                SecurityFrame sf1=new SecurityFrame();
                sf1.setVisible(true);*/
           }
          });


        }
        public  void actionPerformed(ActionEvent ae)
        {
              if (ae.getSource() == jbthanks)
              {  
                 this.dispose();

                               /*  if(type.equals("Encrypt"))
				 {
                                   FrontEndResult fer=new FrontEndResult(this.data);
                                   fer.setVisible(true);        
                                 }
				 if(type.equals("Decrypt"))
				 {
                                   BackEndResult ber=new BackEndResult(this.data);
                                   ber.setVisible(true);        
                                 }*/

             }

        }
}
