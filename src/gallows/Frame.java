package gallows;

import Base.BaseClass;
import Panels.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Ljiljana
 */
public class Frame extends JFrame
{
    private DownPanel downPanel;
    private LeftUpPanel leftUpPanel;
    private RightUpPanel rightUpPanel;
    private UpPanel upPanel;
    
    private MenuBar meni;
    private JSplitPane jsPane;
    Font customFont = null;
    private BaseClass base;
    
    private JPanel jpLeft;
    private JPanel jpRight;
    private JPanel jpDown;
    private JPanel jpUp;
    
    public Frame(Font font)
    {
        base = new BaseClass();
        
        this.customFont = font;
        
        createLeftUpPanel();
        
        createRightUpPanel();
        
        createDownPanel();
        
        meni = new MenuBar(leftUpPanel, rightUpPanel, downPanel);
        
        this.leftUpPanel.setMyMenubar(meni);
        
        this.downPanel.setMyMenuBar(meni);
        
        this.rightUpPanel.setMyMenubar(meni);
        
        createUpPanel();
                
        createSplitPanel(); 
        
        this.setJMenuBar(meni.getMeniBar());
        
        this.add(jsPane);
        
        frameSettings();
    }

    private void createDownPanel() 
    {
        downPanel = new DownPanel(customFont, base, this.rightUpPanel, this.leftUpPanel);
        this.jpDown = downPanel.getDownPanel();
    }

    private void createLeftUpPanel() 
    {
        leftUpPanel = new LeftUpPanel(customFont, base);
        this.jpLeft = leftUpPanel.getPanel();
    }

    private void createRightUpPanel() 
    {
        rightUpPanel = new RightUpPanel(leftUpPanel);
        this.jpRight = rightUpPanel.getPanel();
    }

    private void createUpPanel() 
    {
        upPanel = new UpPanel(this.jpLeft, this.jpRight);
        this.jpUp= upPanel.getPanel();
    }

    private void createSplitPanel() 
    {
        jsPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.jpUp, this.jpDown);
        jsPane.setBackground(Color.yellow);
        jsPane.setPreferredSize(new Dimension(700, 550));
        jsPane.setResizeWeight(.8d);
    }

    private void frameSettings() 
    {
        this.setTitle("Gallows");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setType(Type.NORMAL);
        
        Dimension dimensionWindow = new Dimension(500, 400);
        
        this.setSize(jsPane.getWidth(), jsPane.getHeight());
        
        Toolkit tkDimension = Toolkit.getDefaultToolkit();
	Dimension dimensionScrean = tkDimension.getScreenSize();

	setLocation(dimensionScrean.width / 2 - dimensionWindow.width / 2,
				dimensionScrean.height / 2 - dimensionWindow.height / 2);
        
        this.pack();
        this.setIconImage(new ImageIcon("src/Content/Images/gallowss.png").getImage());
        this.setVisible(true);
    }

}
