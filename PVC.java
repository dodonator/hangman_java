
import java.util.*;

/**
 * Die Klasse PVC steuert ein Spiel mit mehreren Runden
 * Die Methode round_method() wird immer wieder auf-
 * gerufen. Dabei spielt der Spieler gegen den Computer. 
 * 
 * @author Götz und Dominik 
 * @version 9.11
 */

public class PVC
{
    Human player = new Human();
    AI computer = new AI();

    public PVC()
    {
        boolean running = true;
        
        Player[] result = new Player[2];
        result[0] = player;
        result[1] = computer;
        
        while(running) {
            result = round_word (result[0], result[1]);
            Out.println(result[0].get_name() + " : " + result[0].get_score());
            Out.println(result[1].get_name() + " : " + result[1].get_score());
            Out.println("Q zum Beenden drücken");
            String answer = In.readWord();
			if(answer.equals("Q") || answer.equals("q")){
                running =false;
                break;
            }

        }
        
        Out.println(player.get_name() + " : " + player.get_score());
        Out.println(computer.get_name() + " : " + computer.get_score());
        
        if(player.get_score() > computer.get_score()){
            Out.println(player.get_name() + " hat gewonnen!");
        }
        
        else {
            
            if(player.get_score() == computer.get_score()){
                Out.println("Es steht Unentschieden	");
            }
            else{
                Out.println(computer.get_name() + " hat gewonnen!");
            }
        
        }
    }

    
    public Player[] round_word(Player pPlayer, Player pComputer){
        // Zwei Spieler werden übergeben und zwei Spieler
        // werden zurückgegeben.
        Scanner input = new Scanner(System.in);
        
        Human player = (Human) pPlayer;
        AI computer = (AI) pComputer;
        
        String name_p = player.get_name();
        String name_c = computer.get_name();
        String word = player.word_input();
        
        this.clear(20);
        
        boolean running = true;
        int fail_limit = 10;
        int fail_counter = 0;

        String output_word = "";
        int L = word.length();
        
        for (int i = 0; i <= word.length(); i++){
            output_word = output_word + "-";
        }
        
        while (running = true){
            Out.println(output_word);
            Out.println("Fehler: " + fail_counter);
            Out.println();
            
            if (output_word.equals(word)){
                computer.add_score(1);
                running = false;
                break;
            }
            
            String chr = computer.guess();
            
            if (word.contains(chr)){
                int tmp = word.indexOf(chr);
                output_word = output_word.substring(0, tmp)+ chr + output_word.substring(tmp+1, L);
            }
            else{
                fail_counter += 1;
            }

            if (fail_counter == fail_limit){
                player.add_score(1);
                running = false;
                break;
            }
        }

        Player[] opponents = new Player[2];
        opponents[0] = player;
        opponents[1] = computer;
        
        return opponents;
    }

    
    public void clear(int n){
        for (int i = 0; i <= n; i++){
            Out.println("");
        }
    }
}
