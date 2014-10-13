package Panels;

import Base.BaseClass;
import gallows.Frame;
import gallows.MenuBar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Ljiljana
 */
public class DownPanel
{
    private JPanel downPanel = new JPanel();
    private RightUpPanel rightPanel;
    private LeftUpPanel leftPanel;
    private MenuBar myMenuBar;
    private Font font;
    private BaseClass base;
    private ArrayList<String> hitLetter = new ArrayList<String>();
    private String regex = "[^ ]";
    
    public DownPanel(Font font, BaseClass base, RightUpPanel ruPanel, LeftUpPanel luPanel)
    {
        this.font = font;
        
        downPanel.setBackground(Color.yellow);
        downPanel.setMinimumSize(new Dimension(WIDTH, 160));
        downPanel.setPreferredSize(new Dimension(WIDTH, 160));
        
        createButtons();
        
        this.rightPanel = ruPanel;
        this.leftPanel = luPanel;
        this.base = base;
    }

    /**
     * @return the downPanel
     */
    public JPanel getDownPanel() {
        return downPanel;
    }

    /**
     * @param downPanel the downPanel to set
     */
    public void setDownPanel(JPanel downPanel) {
        this.downPanel = downPanel;
    }
    
    public void letterClick(JButton button)
    {
        button.setVisible(false);
        
        if(getBase().getWord().contains(button.getText()))
        {
            setRegex(getRegex().substring(0, getRegex().length() - 1));
            setRegex(getRegex() + ",^" + button.getText() + "]");
            
            String testString = getBase().getWord();
            testString = testString.replaceAll(getRegex(), "?");
            
            this.leftPanel.setWord(testString);
        }
        else
        {
            this.rightPanel.addMiss();
           
            try 
            {
                InputStream inputStream = new FileInputStream("src/Content/no-2.wav");
                AudioStream au = new AudioStream(inputStream);
                AudioPlayer.player.start(au);
            } 
            catch (FileNotFoundException ex) 
            {   
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch (IOException ex) 
            {
                 Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            switch(this.rightPanel.getNumberMisses()) 
            {
                case 1:
                {
                    this.leftPanel.setImage("src/Content/Stickman/image1.png");
                    break;
                }
                case 2:
                {
                    this.leftPanel.setImage("src/Content/Stickman/image2.png");
                    break;
                }
                case 3:
                {
                    this.leftPanel.setImage("src/Content/Stickman/image3.png");
                    break;
                }
                case 4:
                {
                    this.leftPanel.setImage("src/Content/Stickman/image4.png");
                    break;
                }
                case 5:
                {
                    this.leftPanel.setImage("src/Content/Stickman/image5.png");
                    break;
                }
                case 6:
                {
                    this.leftPanel.setImage("src/Content/Stickman/image6.png");
                    JLabel lblWIn = new JLabel("Ooooh, You Lose!!!");
                    lblWIn.setForeground(Color.magenta);
                    lblWIn.setFont(new Font("Kristen ITC", Font.PLAIN, 15));
                    
                    ImageIcon icon = new ImageIcon("src/Content/Images/loseGame.png");
                    
                    this.leftPanel.setWord(this.base.getWord());
            
                    Object buttonArray[] = {"New game", "EXIT"};
        
                    int response = JOptionPane.showOptionDialog(null, lblWIn, "Gallows", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
                    icon, buttonArray, buttonArray[0]);
                    
                    if(response == JOptionPane.YES_OPTION)
                    {
                        this.myMenuBar.newGameClicked();
                        return;
                    }
                    else
                    {
                        System.exit(0);
                    }
                    
                    break;
                }
            }
        }
        
        int number = Integer.valueOf(this.rightPanel.getCountAttemps().getText());
        this.rightPanel.setCountAttemps(String.valueOf(++number));
    }

    public void createButtons()
    {
        char letter = 'A';
        JButton dugme;
        for (int i = 1; i <= 26; i++) 
        {
            dugme = new JButton(String.valueOf(letter++));
            dugme.setFont(font);
            dugme.setBackground(new Color((int)(Math.random() * 0x1000000)));
            this.downPanel.add(dugme);
            
            dugme.addMouseListener(new MouseAdapter() 
            {
                @Override
                public void mouseClicked(MouseEvent e) 
                {
                    letterClick((JButton)e.getSource());
                }
            });
        }
    }

    /**
     * @return the base
     */
    public BaseClass getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(BaseClass base) {
        this.base = base;
    }

    /**
     * @return the hitLetter
     */
    public ArrayList<String> getHitLetter() {
        return hitLetter;
    }

    /**
     * @param hitLetter the hitLetter to set
     */
    public void setHitLetter(ArrayList<String> hitLetter) {
        this.hitLetter = hitLetter;
    }

    /**
     * @return the regex
     */
    public String getRegex() {
        return regex;
    }

    /**
     * @param regex the regex to set
     */
    public void setRegex(String regex) {
        this.regex = regex;
    }

    /**
     * @return the myMenuBar
     */
    public MenuBar getMyMenuBar() {
        return myMenuBar;
    }

    /**
     * @param myMenuBar the myMenuBar to set
     */
    public void setMyMenuBar(MenuBar myMenuBar) {
        this.myMenuBar = myMenuBar;
    }
}
