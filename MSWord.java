import java.util.*;

/**
 * MSWord beschreibt ein Wort und stellt eine Methode zum
 * Bewerten eines Wortes zur Verfügung.
 * 
 * @author Götz und Dominik
 * @version 9.11
 */

public class MSWord
{

    private int rating;
    private String word;
    private Map table;
    private int difficulty;

    public MSWord(String word)
    {
        // Instanzvariable initialisieren
        this.word = word;
        this.table = this.create_table();
        this.rating = this.rating_method(word);
        this.difficulty = this.set_difficulty();

    }

    public int get_rating()
    {
        return this.rating;
    }

    public String get_word()
    {
        return this.word;
    }

    public int get_difficulty(){
        return this.difficulty;
    }

    public int rating_method(String word)
    {
        int score = 0;
        word = word.toUpperCase();

        // L = Length
        int L = word.length();

        // Re = Repetitions
        int Re = 0;

        // Ra = Rarity
        int Ra = 0;

        for (int i = 0; i < L; i++)
        {
            //System.out.println(i);
            char chr = word.charAt(i);
            if (this.countLetter(word, chr) > 1){
                Re += 1;
            }
            String tmp = word.substring(i,i+1);
            Integer tmp_2 = (Integer)this.table.get(tmp);
            Ra += tmp_2;
        }

        score = L + Ra + Re;

        return score;

    }

    private static int countLetter(String str, char letter) {
        str = str.toLowerCase();       
        letter = Character.toLowerCase(letter);    
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char currentLetter = str.charAt(i);
            if (currentLetter == letter){
                count++;           
            }
        }
        return count;

    }

    
    public Map create_table(){ 
        Map<String, Integer> table = new HashMap<String, Integer>();
        String[] parts;
        String chr;
        Integer value;
        In.open("ht.txt");
        String tmp = In.readWord();
        while(In.done()){
            parts = tmp.split(";");
            chr = parts[0];
            value = Integer.valueOf(parts[1]);
            table.put(chr, value);
            // Out.println(chr + " : " + value);
            tmp = In.readWord();
        }
        In.close();
        return table;
    }

    public int set_difficulty(){
        int diff = 0;
        int score = this.get_rating();
        // Diese Formel kann noch optimiert werden:
        diff = 50 - (score / 100);
        return diff;
    }
}