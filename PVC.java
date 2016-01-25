
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
            result = round_word (result[1], result[0]);
            System.out.println(result[0].get_name() + " : " + result[0].get_score());
            System.out.println(result[1].get_name() + " : " + result[1].get_score());
            System.out.println("Q zum Beenden drücken");
            Scanner input = new Scanner(System.in);
            String answer = input.next();
            if(answer == "Q" || answer == "q"){
                running =false;
                break;
            }

        }
        
        System.out.println(player.get_name() + " : " + player.get_score());
        System.out.println(computer.get_name() + " : " + computer.get_score());
        
        if(player.get_score() > computer.get_score()){
            System.out.println(player.get_name() + " hat gewonnen!");
        }
        
        else {
            
            if(player.get_score() == computer.get_score()){
                System.out.println("Es steht Unentschieden	");
            }
            else{
                System.out.println(computer.get_name() + " hat gewonnen!");
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
            System.out.println(output_word);
            System.out.println("Fehler: " + fail_counter);
            System.out.println();
            
            if (output_word == word){
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
            System.out.println("");
        }
    }
}
