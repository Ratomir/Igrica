
package Panels;

import Base.BaseClass;
import gallows.MenuBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author Ljiljana
 */
public class LeftUpPanel
{
    private JPanel panel = new JPanel();
    private JLabel word;
    private JLabel image;
    private BaseClass baseWord;
    private JTextField txtWord;
    
    private MenuBar myMenubar;
    
    public LeftUpPanel(Font font, BaseClass base)
    {
        this.baseWord = base;
        
        panel.setLayout(new BorderLayout(5,5));
        
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout(5, 5));
        imagePanel.setBackground(Color.WHITE);
        image = new JLabel(new ImageIcon("src/Content/Stickman/image.PNG"));
        image.setVerticalAlignment(SwingConstants.CENTER);
        imagePanel.add(image, BorderLayout.CENTER);
        
        panel.add(imagePanel, BorderLayout.CENTER);
        
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BorderLayout(5,5));
        
        JLabel labela = new JLabel("Type Your word");
        labela.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
        labela.setHorizontalAlignment(SwingConstants.CENTER);
        userPanel.add(labela, BorderLayout.NORTH);
        
        txtWord = new JTextField();
        txtWord.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
        txtWord.setHorizontalAlignment(SwingConstants.CENTER);
        TextDocument document = new TextDocument();
        document.setMaxChars(base.getWord().length());
        ((AbstractDocument) txtWord.getDocument()).setDocumentFilter(document);
        userPanel.add(txtWord, BorderLayout.CENTER);
        
        JButton btnChackWord = new JButton("Chack word");
        btnChackWord.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
        btnChackWord.addMouseListener(new MouseAdapter() 
        {
	    @Override
	    public void mouseClicked(MouseEvent arg0) 
            {
                chackWord(arg0);
	    }
	});
        userPanel.add(btnChackWord, BorderLayout.SOUTH);
        
        panel.add(userPanel, BorderLayout.NORTH);
        
        JPanel wordPanel = new JPanel();
        
        word = new JLabel();
        word.setText(base.getWord().replaceAll("[^ ]", "?"));
                
        word.setHorizontalAlignment(SwingConstants.CENTER);
        word.setFont(font);
        wordPanel.add(word);
        
        panel.add(wordPanel, BorderLayout.SOUTH);
    }

    /**
     * @return the panel
     */
    public JPanel getPanel() 
    {
        return panel;
    }

    /**
     * @param panel the panel to set
     */
    public void setPanel(JPanel panel) 
    {
        this.panel = panel;
    }
    
    /**
     * @param word the word to set
     */
    public void setWord(String word) {
        this.getWord().setText(word);
    }

    /**
     * @return the word
     */
    public JLabel getWord() {
        return word;
    }

    public void setImage(String src)
    {
        image.setIcon(new ImageIcon(src));
    }
    
    public void chackWord(MouseEvent e)
    {
        if(getTxtWord().getText().equals(this.getBaseWord().getWord()))
        {
            StringBuilder stringBuilder = new StringBuilder("Congratulations, you are successfully hit a search term");
            stringBuilder.append(getBaseWord().getWord());
            JLabel lblWIn = new JLabel(stringBuilder.toString());
            lblWIn.setForeground(Color.magenta);
            lblWIn.setFont(new Font("Kristen ITC", Font.PLAIN, 15));
        
            ImageIcon icon = new ImageIcon("src/Content/Images/star.png");
            
            Object buttonArray[] = {"New game", "EXIT"};
        
            int response = JOptionPane.showOptionDialog(null, lblWIn, "Gallows", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
                    icon, buttonArray, buttonArray[0]);
            
            if (response == JOptionPane.YES_OPTION) 
            {
                this.getMyMenubar().newGameClicked();
            } 
            else
            {
                System.exit(0);
            }
        }
    }

    /**
     * @return the baseWord
     */
    public BaseClass getBaseWord() {
        return baseWord;
    }

    /**
     * @param baseWord the baseWord to set
     */
    public void setBaseWord(BaseClass baseWord) {
        this.baseWord = baseWord;
    }

    /**
     * @return the txtWord
     */
    public JTextField getTxtWord() {
        return txtWord;
    }

    /**
     * @param txtWord the txtWord to set
     */
    public void setTxtWord(String txtWord) {
        this.txtWord.setText(txtWord);
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
