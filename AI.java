
/**
 * @author Götz und Dominik
 * @version 9.11
 */
public class AI extends Player
{
    // Bezugsobjekte

    // Attribute

    // Konstruktor
    public AI()
    {
        
    }

    public String word_input()
    {
        // Hier sollen Worte aus einer Wortliste gelesen werden
        String word = "ToDo";
        
        MSWord W = new MSWord(word);
        int rating = W.get_rating();
        System.out.println(rating);
        return "ToDo";
    }
    
     public String guess()
    {
       // Hier werden Buchstaben nach einem Muster geraten
       return "ToDo";
    }

}
