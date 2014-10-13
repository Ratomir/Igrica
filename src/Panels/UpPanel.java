package Panels;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Ljiljana
 */
public class UpPanel 
{
    private JPanel panel = new JPanel();
    
    public UpPanel(JPanel leftPanel, JPanel rightPanel)
    {
        panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
        
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 5));
        
        panel.add(leftPanel, "2,2, fill, fill");
        
        panel.add(rightPanel, "4, 2, fill, fill");
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
}
