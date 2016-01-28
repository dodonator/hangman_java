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
        List word_list = new ArrayList<String>();
        int word_list_len = 0;
        In.open("wortliste.txt");
        String tmpWord = In.readWord();
        while (In.done()){
            word_list.add(tmpWord);
            word_list_len += 1;
            // Out.println(tmpWord);
            tmpWord = In.readWord();
        }
        In.close();

        Random random = new Random();
        int index = random.nextInt(word_list_len);
        // Out.println(index);
        // Out.println(word_list.get(index));
        String word = (String) word_list.get(index);        

        MSWord W = new MSWord(word);
        int rating = W.get_rating();
        int diff = W.get_difficulty();
        // Out.println(rating);
        return word;

    }

    public String guess()
    {
        String[] Alphabet = {"A", "B", "C", "D", "E",
                             "F", "G", "H", "I", "J",
                             "K", "L", "M", "N", "O",
                             "P", "Q", "R", "S", "T",
                             "U", "V", "W", "X", "Y",
                             "Z", "A", "E", "I", "O",
                             "U", "N", "R", "S", "T",
                             "M", "E", "N", "I", "S",
                            };
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
                used_chars.add(tmp);
                running = false;
                break;
            }
        }
        Out.println(tmp);
        return tmp;
    }
}
