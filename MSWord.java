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
        this.table = this.create_map();
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

    
    public Map create_map(){
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("E", 1740);
        map.put("N", 978);
        map.put("I", 755);
        map.put("S", 727);
        map.put("R", 700);
        map.put("A", 651);
        map.put("T", 615);
        map.put("D", 508);
        map.put("H", 476);
        map.put("U", 435);
        map.put("L", 344);
        map.put("C", 306);
        map.put("G", 301);
        map.put("M", 253);
        map.put("O", 251);
        map.put("B", 189);
        map.put("W", 189);
        map.put("F", 166);
        map.put("K", 121);
        map.put("Z", 113);
        map.put("P", 79);
        map.put("V", 67);
        map.put("J", 27);
        map.put("Y", 4);
        map.put("X", 3);
        map.put("Q", 2);
        // System.out.println("The table was created");
        return map;
    }
    
    
    public int set_difficulty(){
        int diff = 0;
        int score = this.get_rating();
        // diff = 1000 / score;
        return diff;
    }
}