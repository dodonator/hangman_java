
import java.util.*;

/**
 * Die Klasse PVC steuert ein Spiel mit mehreren Runden
 * Die Methode round_method() wird immer wieder auf-
 * gerufen. Dabei spielt der Spieler gegen den Computer. 
 * Der Spieler gibt das Wort vor, dass der Computer
 * erraten muss.
 * 
 * @author Goetz und Dominik 
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
            Out.println("Q zum Beenden druecken");
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
        // werden zurueckgegeben.
        this.clear();

        Human player = (Human) pPlayer;
        AI computer = (AI) pComputer;

        String name_p = player.get_name();
        String name_c = computer.get_name();
        String word = player.word_input();

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
            this.clear();
            Out.println(output_word + "    " + word.length() + " Buchstaben");
            Out.println(this.bar(fail_counter, fail_limit) + " Fehler: " + fail_counter + " / " + fail_limit);
            Out.println(used_chars);
            Out.println();

            output_word.delete(0, output_word.length());

            String Try = computer.guess();

            
            if (Try.length() == 1){
                // It's a char!
                used_chars.add(Try);

                if (word.contains(Try) != true){
                    fail_counter += 1;
                }

            }
            else{
                if (Try.length() == word.length()){

                    if (Try.toUpperCase().equals(word.toUpperCase())){
                        computer.add_score(1);
                        running = false;
                        Out.println("");
                        Out.println(word);
                        Out.println("Das Wort wurde erraten!");
                        Out.println("");
                        break;
                    }
                    else
                    {
                        Out.println("");
                        Out.println("Das war falsch!");
                        Out.println("");
                        fail_counter += 1;
                    }
                }
                else{
                    Out.println("");
                    Out.println("Entweder einen Buchstaben oder das ganze Wort ("+word.length()+" Buchstaben) eingeben!");
                    Out.println("");
                    fail_counter += 1;
                }
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

            if (output_word.toString().toUpperCase().equals(word.toUpperCase())){
                computer.add_score(1);
                running = false;
                Out.println("");
                Out.println(word);
                Out.println("Das Wort wurde erraten!");
                Out.println("");
                break;
            }

            if (fail_counter == fail_limit){
                player.add_score(1);
                Out.println("Das Wort war: " + word);
                running = false;
                break;
            }
        }

        Player[] opponents = new Player[2];
        opponents[0] = player;
        opponents[1] = computer;

        return opponents;
    }

    public void clear(){
        Out.print('\u000C');
    }

    public String bar(int current, int maximum){
        StringBuilder result = new StringBuilder();
        result.append("[");
        if(current >= 1){

            for(int i = 1; i <= current;i++)
            {
                result.append("*");
            }
        }
        for(int i=1; i <= (maximum-current);i++){
            result.append(" ");
        }
        result.append("]");
        return result.toString();
    }
}
