
package main;
import gallows.*;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Ratomir
 */
public class MainClass 
{
    public static void main(String[] args) 
    {
        try
	{
	    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	}
	catch (ClassNotFoundException e)
	{
	    e.printStackTrace();
	}
	catch (InstantiationException e)
	{
	    e.printStackTrace();
	}
	catch (IllegalAccessException e)
	{
            e.printStackTrace();
	}
	catch (UnsupportedLookAndFeelException e)
	{
	    e.printStackTrace();
	}
        
        try 
        {
                //create the font to use. Specify the size!
                Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/Content/SCRATCHMYBACK.TTF")).deriveFont(25f);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                //register the font
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/Content/SCRATCHMYBACK.TTF")));
                
                new Frame(customFont);
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch(FontFormatException e)
        {
            e.printStackTrace();
        }
    }
}
