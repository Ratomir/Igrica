
package Panels;

import gallows.MenuBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Ljiljana
 */
public class RightUpPanel 
{
    private JPanel panel = new JPanel();
    private JPanel missesPanel;
    private JLabel countAttemps;
    private JPanel infoPanel;
    
    private MenuBar myMenubar;
    
    private LeftUpPanel luPanel;
    
    private int numberMisses = 0;
    
    public RightUpPanel(LeftUpPanel leftPanel)
    {
        this.luPanel = leftPanel;
        
        panel.setBackground(new Color(222,251,179));
        SpringLayout springLayout = new SpringLayout();
        
        panel.setLayout(springLayout);
        
        JButton btnNewGame = new JButton();
        btnNewGame.setText("New Game");
        btnNewGame.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
        
        btnNewGame.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
                btnNewGame.setBackground(Color.RED);
                btnNewGame.setFont(btnNewGame.getFont().deriveFont(14f));
                btnNewGame.setIcon(new ImageIcon("src/Content/Images/smile.png"));
                btnNewGame.setText("New Game, realy???");
            }
            
            @Override
            public void mouseExited(MouseEvent e)
            {
                btnNewGame.setText("New Game");
                btnNewGame.setIcon(null);
                btnNewGame.setFont(btnNewGame.getFont().deriveFont(18f));
                btnNewGame.setBackground(UIManager.getColor("Button.background"));
            }
            
            @Override
            public void mouseClicked(MouseEvent arg0) 
            {
                getMyMenubar().newGameClicked();
            }
        });
        
	springLayout.putConstraint(SpringLayout.NORTH, btnNewGame, 5, SpringLayout.NORTH, panel);
	springLayout.putConstraint(SpringLayout.WEST, btnNewGame, 5, SpringLayout.WEST, panel);
	springLayout.putConstraint(SpringLayout.SOUTH, btnNewGame, 50, SpringLayout.NORTH, panel);
	springLayout.putConstraint(SpringLayout.EAST, btnNewGame, -5, SpringLayout.EAST, panel);
	panel.add(btnNewGame);
		
	infoPanel = new JPanel();
        infoPanel.setBackground(new Color(153,246,20));
        infoPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	springLayout.putConstraint(SpringLayout.NORTH, infoPanel, 56, SpringLayout.NORTH, panel);
	springLayout.putConstraint(SpringLayout.WEST, infoPanel, 5, SpringLayout.WEST, panel);
	springLayout.putConstraint(SpringLayout.SOUTH, infoPanel, -5, SpringLayout.SOUTH, panel);
	springLayout.putConstraint(SpringLayout.EAST, infoPanel, -5, SpringLayout.EAST, panel);
        
        infoPanel.setLayout(new BorderLayout(5, 5));
        
        JLabel misses = new JLabel("Misses");
        misses.setHorizontalAlignment(SwingConstants.CENTER);
        misses.setFont(new Font("Kristen ITC", Font.PLAIN, 19));
        infoPanel.add(misses, BorderLayout.NORTH);
        
        createMissesPanel();
        
        JPanel attempsPanel = new JPanel();
        attempsPanel.setBackground(new Color(138,197,52));
        JLabel lblString = new JLabel("Attempts: ");
        lblString.setFont(new Font("Kristen ITC", Font.PLAIN, 19));
        attempsPanel.add(lblString);
        
        countAttemps = new JLabel("0");
        countAttemps.setForeground(new Color(184,0,0));
        countAttemps.setFont(new Font("Kristen ITC", Font.BOLD, 30));
        attempsPanel.add(countAttemps);
        
        infoPanel.add(attempsPanel, BorderLayout.SOUTH);
        
	panel.add(infoPanel);
    }

    /**
     * @return the panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * @param panel the panel to set
     */
    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
    
    public void addMiss()
    {
        missesPanel.add(new JLabel(new ImageIcon("src/Content/Images/misses.png")));
        this.numberMisses++;
    }

    /**
     * @return the countAttemps
     */
    public JLabel getCountAttemps() {
        return countAttemps;
    }

    /**
     * @param countAttemps the countAttemps to set
     */
    public void setCountAttemps(String number) 
    {
        this.countAttemps.setText(number);
    }

    /**
     * @return the numberMisses
     */
    public int getNumberMisses() 
    {
        return numberMisses;
    }

    /**
     * @param numberMisses the numberMisses to set
     */
    public void setNumberMisses(int numberMisses) {
        this.numberMisses = numberMisses;
    }
    
    public void createMissesPanel()
    {
        if(this.missesPanel != null)
        {
            this.missesPanel.removeAll();
            this.infoPanel.remove(this.missesPanel);
        }
        
        missesPanel = new JPanel();
        missesPanel.setBackground(new Color(153,246,20));
        this.infoPanel.add(missesPanel, BorderLayout.CENTER);
    }

    /**
     * @return the myMenubar
     */
    public MenuBar getMyMenubar() {
        return myMenubar;
    }

    /**
     * @param myMenubar the myMenubar to set
     */
    public void setMyMenubar(MenuBar myMenubar) {
        this.myMenubar = myMenubar;
    }
}
