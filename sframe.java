import java.awt.*;
import javax.swing.*;
public class sframe extends JFrame
{
	sframe(String title,String res)
	{
		super(title);
		if(res.equals("EXISTS"))
			JOptionPane.showMessageDialog(this,"Exits","Message",JOptionPane.ERROR_MESSAGE);
		else if(res.equals("not exists"))
			JOptionPane.showMessageDialog(this,"Does Not Exits","Message",JOptionPane.ERROR_MESSAGE);
		else
			JOptionPane.showMessageDialog(this,res,"Message",JOptionPane.ERROR_MESSAGE);
	}
}
