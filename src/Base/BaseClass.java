
package Base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ratomir
 */
public class BaseClass 
{
    protected String word;

    /**
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * @param word the word to set
     */
    public void setWord(String word) {
        this.word = word;
    }
    
    /**
     * Constructor base class.
     */
    public BaseClass()
    {
        BufferedReader reader;
        try 
        {
            
            reader = new BufferedReader(new FileReader("src/Content/Files/scientists.txt"));
            
            Random randomNumber = new Random();
            int number = randomNumber.nextInt(30);
                    
            while((this.word = reader.readLine()) != null)
            {
                if(getWord().contains(Integer.toString(number)))
                {
                    setWord(getWord().substring(3));
                    break;
                }
            }
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(BaseClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) 
        {
            Logger.getLogger(BaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    public BaseClass(int menu)
    {
        BufferedReader reader;
        try 
        {
            if(menu == 1)
            {
                reader = new BufferedReader(new FileReader("src/Content/Files/scientists.txt"));
            }
            else if(menu == 2)
            {
                reader = new BufferedReader(new FileReader("src/Content/Files/sports.txt"));
            }
            else
            {
                reader = new BufferedReader(new FileReader("src/Content/Files/singers.txt"));
            }
            
            Random randomNumber = new Random();
            int number = randomNumber.nextInt(30);
                    
            while((this.word = reader.readLine()) != null)
            {
                if(getWord().contains(Integer.toString(number)))
                {
                    setWord(getWord().substring(3));
                    break;
                }
            }
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(BaseClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) 
        {
            Logger.getLogger(BaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}

