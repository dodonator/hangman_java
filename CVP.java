
import java.util.*;

/**
 * Die Klasse PVC steuert ein Spiel mit mehreren Runden
 * Die Methode round_method() wird immer wieder auf-
 * gerufen. Dabei spielt der Spieler gegen den Computer. 
 * 
 * @author Goetz und Dominik 
 * @version 9.11
 */

public class CVP
{
    Human player = new Human();
    AI computer = new AI();

    public CVP()
    {
        boolean running = true;

        Player[] result = new Player[2];
        result[0] = computer;
        result[1] = player;

        while(running) {
            result = round_word (result[0], result[1]);
            Out.println(result[0].get_name() + " : " + result[0].get_score());
            Out.println(result[1].get_name() + " : " + result[1].get_score());
            Out.println("Q zum Beenden drücken");
            String answer = In.readWord();
            if(answer.equals("Q") || answer.equals("q")){
                Out.println("");
                running =false;
                break;
            }

        }

        Out.println(computer.get_name() + " : " + computer.get_score());
        Out.println(player.get_name() + " : " + player.get_score());

        if(player.get_score() > computer.get_score()){
            Out.println(player.get_name() + " hat gewonnen!");
        }

        else {

            if(player.get_score() == computer.get_score()){
                Out.println("Es steht Unentschieden ");
            }
            else{
                Out.println(computer.get_name() + " hat gewonnen!");
            }

        }
    }

    public Player[] round_word(Player pComputer, Player pPlayer){

        Human player = (Human) pPlayer;
        AI computer = (AI) pComputer;
        
        String name_c = computer.get_name();
        String name_h = player.get_name();
        String word = computer.word_input();

        boolean running = true;
        int fail_limit = 10;
        int fail_counter = 0;
        
        StringBuilder output_word = new StringBuilder();
        List<String> used_chars = new ArrayList<String>();
        int L = word.length();

        for (int i = 0; i < L; i++){
            output_word.append("-");
        }

        while (running = true){
            this.clear(20);
            Out.println(output_word);
            Out.println("Fehler: " + fail_counter + " / " + fail_limit);
            Out.println(used_chars);
            Out.println();

            output_word.delete(0, output_word.length());

            String Try = player.guess();
            if (Try.length() == 1){
                // It's a char!
                used_chars.add(Try);
                

                if (word.contains(Try) != true){
                    fail_counter += 1;
                }

                for (int o = 0; o < word.length(); o++){
                    String tmp = word.substring(o, o+1);
                    if (used_chars.contains(tmp)){
                        output_word.append(tmp);
                    }
                    else{
                        output_word.append("-");
                    }
                }
            }
            else{
                if (Try.length() == word.length()){

                    if (Try.toUpperCase().equals(word.toUpperCase())){
                        player.add_score(1);
                        running = false;
                        Out.println("");
                        Out.println(word);
                        Out.println("Das Wort wurde erraten!");
                        Out.println("");
                        break;
                    }
                }
                else{
                    Out.println("");
                    Out.println("Keine Silben angeben!");
                    fail_counter += 1;
                }
            }

            if (output_word.toString().toUpperCase().equals(word.toUpperCase())){
                player.add_score(1);
                running = false;
                Out.println("");
                Out.println(word);
                Out.println("Das Wort wurde erraten!");
                Out.println("");
                break;
            }

            if (fail_counter == fail_limit){
                computer.add_score(1);
                Out.println("Das Wort war: " + word);
                running = false;
                break;
            }
        }

        Player[] opponents = new Player[2];
        opponents[0] = computer;
        opponents[1] = player;

        return opponents;
    }

    public void clear(int n){
        for (int i = 0; i <= n; i++){
            Out.println("");
        }
    }
}
