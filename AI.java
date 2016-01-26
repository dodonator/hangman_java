import java.util.*; 
/**
 * @author Götz und Dominik
 * @version 9.11
 */

public class AI extends Player
{
    public List used_chars = new ArrayList<String>();
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
        String[] Alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String tmp = new String();
        boolean running = true;
        while (running){
            Random random = new Random();
            int index = random.nextInt(Alphabet.length);
            tmp = Alphabet[index];
            if (used_chars.contains(tmp)){
                running = true;
            }
            else{
                running = false;
                break;
            }
        }
        return tmp;
    }
}
