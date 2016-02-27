import java.util.*;

/**
 * Die Klasse Game steuert ein Spiel mit mehreren Runden
 * Die Methode round_method() wird immer wieder auf-
 * gerufen, 
 * 
 * @author Götz und Dominik 
 * @version 9.11
 */

public class PVP
{
    Human human_1;
    Human human_2;

    public PVP()
    {
        boolean running = true;

        human_1 = new Human();
        human_2 = new Human();

        Human[] result = new Human[2];
        result[0] = human_1;
        result[1] = human_2;

        while(running) {
            result = round_word (result[0], result[1]);
            Out.println();
            Out.println(result[0].get_name() + " : " + result[0].get_score());
            Out.println(result[1].get_name() + " : " + result[1].get_score());
            Out.println();
            Out.println("Beliebiges Zeichen zum fortfahren eingeben!");
            Out.println("Q zum Beenden druecken");
            String answer = In.readWord();
            
            if((answer.equals("Q")) || (answer.equals("q"))){
                Out.println("Beenden");
                running = false;
                break;
            }
            else{
                In.done();
            }

        }

        Out.println(human_1.get_name() + " : " + human_1.get_score());
        Out.println(human_2.get_name() + " : " + human_2.get_score());

        if(human_1.get_score()>human_2.get_score()){
            Out.println(human_1.get_name() + " hat gewonnen!");
        }
        else {
            if(human_1.get_score()==human_2.get_score()){
                Out.println("Es steht Unentschieden ");
            }
            else{
                Out.println(human_2.get_name() + " hat gewonnen!");
            }
        }
    }

    public Human[] round_word(Human human_1, Human human_2){
        // Zwei Menschen werden uebergeben und zwei Menschen
        // werden zurueckgegeben.

        String name_1 = human_1.get_name();
        String name_2 = human_2.get_name();
        String word = human_1.word_input();

        this.clear();

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

            String Try = human_2.guess();

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
                        human_2.add_score(1);
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
                human_2.add_score(1);
                running = false;
                Out.println("");
                Out.println(word);
                Out.println("Das Wort wurde erraten!");
                Out.println("");
                break;
            }

            if (fail_counter == fail_limit){
                human_1.add_score(1);
                Out.println();
                Out.println("Das Wort war: " + word);
                Out.println();
                running = false;
                break;
            }
        }

        Human[] opponents = new   Human[2];
        opponents[0] = human_2;
        opponents[1] = human_1;

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
