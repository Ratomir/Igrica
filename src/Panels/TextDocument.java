
package Panels;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Ratomir
 */
public class TextDocument extends DocumentFilter 
{
    private final PlainDocument plainDocument = new PlainDocument();
    private int maxChars;
    
    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException 
    {
        fb.insertString(offset, text.toUpperCase(), attr);

        if(plainDocument.getLength() + text.length() < getMaxChars())
        {
            plainDocument.insertString(offset, text, attr);
	}
    }

  //no need to override remove(): inherited version allows all removals
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attr) throws BadLocationException 
    {
        fb.replace(offset, length, text.toUpperCase(), attr);
    }

    /**
     * @return the maxChars
     */
    public int getMaxChars() {
        return maxChars;
    }

    /**
     * @param maxChars the maxChars to set
     */
    public void setMaxChars(int maxChars) {
        this.maxChars = maxChars;
    }
}

