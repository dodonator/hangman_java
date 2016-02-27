import java.util.*; 

/**
 * Die Klasse AI raet Woerter, welche vom Spieler eingegeben wurden oder
 * laesst den Spieler Woerter aus einer Liste raten.
 * 
 * @author Goetz und Dominik
 * @version 9.11
 */

public class AI extends Player
{
    public List used_chars = new ArrayList<String>();
    public List word_list = new ArrayList<String>();
    public Map table;
    public int word_list_len = 0;
    public String list_filename = new String();

    public AI()
    {
        table = this.create_table();

        Out.println("1: Wortliste 1");
        Out.println("   Selbst zusammengestellt, auf Hangman angepasst");
        Out.println("");
        Out.println("2: Wortliste 2");
        Out.println("   Komplette Wortliste der deutschen Sprache, auch Beugungen möglich");
        Out.println("");
        Out.println("3: Wortliste 3");
        Out.println("   Umfangreiche Wortliste, nur Substantive");
        Out.println("");
        Out.println("Suchen Sie sich eine Liste aus");
        String list = In.readWord();
        this.list_filename = "wortliste" + list + ".txt";

        word_list_input();
    }

    public void set_name(){
        this.name = "Computer";
    }

    public void word_list_input(){
        In.open(this.list_filename);
        String tmpWord = In.readWord();
        while (In.done()){
            if (tmpWord.length() <= 10){
                word_list.add(tmpWord);
                this.word_list_len += 1;
                
            }
            tmpWord = In.readWord();
        }
        In.close();
        Out.println("Anzahl Woerter: " + this.word_list_len);
    }

    public String word_input()
    {
        Random random = new Random();
        int index = random.nextInt(this.word_list_len);
        String word = (String) this.word_list.get(index);        
        word = word.toUpperCase();

        MSWord W = new MSWord(word);
        int rating = W.get_rating();
        int diff = W.get_difficulty();
        return word;
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
            tmp = In.readWord();
        }
        
        In.close();
        return table;
    }

    public  String generate_alphabet() {
        StringBuilder alphabet = new StringBuilder();
        table = this.table;
        String key;
        int value;
        Iterator it = table.entrySet().iterator();
        
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            key = (String) pair.getKey();
            value = (Integer) pair.getValue();
            if ( (value / 100) == 0){
                value = 1;
            }
            else{
                value = value / 100;
            }
            for (int i = 0; i <= value; i++){
                alphabet.append(key);
            }
            it.remove();
        }
        
        String result = alphabet.toString();
        this.table = this.create_table();
        
        return result;
    }

    public String guess()
    {
        String Alphabet;
        Random random = new Random();
        String tmp = new String();
        Alphabet = this.generate_alphabet();
        this.create_table();
        int index = 0;
        boolean running = true;
        
        while (running){
            Alphabet = this.generate_alphabet();
            index = random.nextInt(Alphabet.length());
            tmp = Alphabet.substring(index, index+1);
            if (used_chars.contains(tmp)){
                running = true;
            }
            else{
                used_chars.add(tmp);
                running = false;
                break;
            }
        }
        
        return tmp;
    }
}
