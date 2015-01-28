package gallows;

import Base.*;
import Panels.DownPanel;
import Panels.LeftUpPanel;
import Panels.RightUpPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Ratomir
 */
public class MenuBar extends JMenuBar
{
    private LeftUpPanel luPanel;
    private RightUpPanel ruPanel;
    private DownPanel doPanel;
    
    private JMenuBar meniBar;
    private JMenu typeGallows;
    private JCheckBoxMenuItem jcbScientists;
    private JCheckBoxMenuItem jcbSports;
    private JCheckBoxMenuItem jcbSingers;
    private final JMenuItem newGame;
    
    private int type;

    /**
     * @return the meniBar
     */
    public JMenuBar getMeniBar() {
        return meniBar;
    }

    /**
     * @param meniBar the meniBar to set
     */
    public void setMeniBar(JMenuBar meniBar) {
        this.meniBar = meniBar;
    }
    
    public MenuBar(LeftUpPanel leftPanel, RightUpPanel rightPanel, DownPanel downPanel)
    {
        this.luPanel = leftPanel;
        this.ruPanel = rightPanel;
        this.doPanel = downPanel;
        
        meniBar = new JMenuBar();
        
        typeGallows = new JMenu("Type Gallows");
        typeGallows.setMnemonic(KeyEvent.VK_T);
        
        newGame = new JMenuItem("New Game");
        newGame.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                newGameClicked();
	    }
	});
        
        typeGallows.add(newGame);
        typeGallows.addSeparator();
        
        jcbScientists = new JCheckBoxMenuItem("Scientists", new ImageIcon("src/Content/Images/scientist.png"));
        jcbSports = new JCheckBoxMenuItem("Sports", new ImageIcon("src/Content/Images/sport.png"));
        jcbSingers = new JCheckBoxMenuItem("Singers", new ImageIcon("src/Content/Images/singer.png"));
        
        jcbScientists.setMnemonic('S');
        jcbScientists.setSelected(true);
        jcbScientists.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                chackBoxClick(e);
            }
        });
        
        
        jcbSports.setMnemonic('P');
        jcbSports.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                chackBoxClick(e);
            }
        });
        
        
        jcbSingers.setMnemonic('I');
        jcbSingers.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                chackBoxClick(e);
            }
        });
        
        
        typeGallows.add(jcbScientists);
        typeGallows.add(jcbSports);
        typeGallows.add(jcbSingers);
        
        meniBar.add(typeGallows);
    }

    private void chackBoxClick(ActionEvent e) 
    {
        if(((JCheckBoxMenuItem)e.getSource()).getText() == "Scientists")
        {
            getJcbScientists().setSelected(true);
            getJcbSports().setSelected(false);
            getJcbSingers().setSelected(false);
            
            this.type = 1;
        }
        else if(((JCheckBoxMenuItem)e.getSource()).getText() == "Sports")
        {
            getJcbScientists().setSelected(false);
            getJcbSports().setSelected(true);
            getJcbSingers().setSelected(false);
            
            this.type = 2;
        }
        else
        {
            getJcbScientists().setSelected(false);
            getJcbSports().setSelected(false);
            getJcbSingers().setSelected(true);
            
            this.type = 3;
        }
    }
    
    public void newGameClicked()
    {
        this.ruPanel.createMissesPanel();
        this.ruPanel.setCountAttemps("0");
        this.ruPanel.setNumberMisses(0);
        
        this.luPanel.setImage("src/Content/Stickman/image.png");
        
        this.doPanel.getDownPanel().removeAll();
        this.doPanel.createButtons();
        
        BaseClass newWord = new BaseClass(this.type);
        this.doPanel.setBase(newWord);
        
        this.doPanel.setRegex("[^ ]");
        this.doPanel.getHitLetter().clear();
        
        this.luPanel.setBaseWord(newWord);
        this.luPanel.setWord(newWord.getWord().replaceAll("[^ ]", "?"));
        this.luPanel.setTxtWord("");
    }

    /**
     * @return the jcbScientists
     */
    public JCheckBoxMenuItem getJcbScientists() {
        return jcbScientists;
    }

    /**
     * @param jcbScientists the jcbScientists to set
     */
    public void setJcbScientists(JCheckBoxMenuItem jcbScientists) {
        this.jcbScientists = jcbScientists;
    }

    /**
     * @return the jcbSports
     */
    public JCheckBoxMenuItem getJcbSports() {
        return jcbSports;
    }

    /**
     * @param jcbSports the jcbSports to set
     */
    public void setJcbSports(JCheckBoxMenuItem jcbSports) {
        this.jcbSports = jcbSports;
    }

    /**
     * @return the jcbSingers
     */
    public JCheckBoxMenuItem getJcbSingers() {
        return jcbSingers;
    }

    /**
     * @param jcbSingers the jcbSingers to set
     */
    public void setJcbSingers(JCheckBoxMenuItem jcbSingers) {
        this.jcbSingers = jcbSingers;
    }
}
