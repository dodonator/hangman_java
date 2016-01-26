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
    Human human_1 = new Human();
    Human human_2 = new Human();

    public PVP()
    {
        boolean running = true;

        Human[] result = new Human[2];
        result[0] = human_1;
        result[1] = human_2;

        while(running) {
            result = round_word (result[0], result[1]);
            Out.println(result[0].get_name() + " : " + result[0].get_score());
            Out.println(result[1].get_name() + " : " + result[1].get_score());
            Out.println("Beliebiges Zeichen zum fortfahren eingeben!");
            Out.println("Q zum Beenden drücken");
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
        // Zwei Menschen werden übergeben und zwei Menschen
        // werden zurückgegeben.
        Scanner input = new Scanner(System.in);

        String name_1 = human_1.get_name();
        String name_2 = human_2.get_name();
        String word = human_1.word_input();

        this.clear(20);

        boolean running = true;
        int fail_limit = 10;
        int fail_counter = 0;
        // String output_word = "";
        StringBuilder output_word = new StringBuilder();
        List<String> used_chars = new ArrayList<String>();
        int L = word.length();

        for (int i = 0; i <= L; i++){
            // output_word = output_word + "-"
            output_word.append("-");
        }

        while (running = true){
            Out.println(output_word);
            Out.println("Fehler: " + fail_counter + " / " + fail_limit);

            Out.println();

            output_word.delete(0, output_word.length());

            String Try = human_2.guess();
            if (Try.length() == 1){
                // Out.println("It's a char!");
                used_chars.add(Try);
                // Out.println(used_chars);
                if (word.contains(Try)){
                    // int tmp = word.indexOf(Try);
                    // output_word = output_word.substring(0, tmp)+ Try + output_word.substring(tmp+1, L);

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
                    fail_counter += 1;
                }
            }
            else{
                if (Try.length() == word.length()){

                    if (Try.toUpperCase().equals(word.toUpperCase())){
                        human_2.add_score(1);
                        running = false;
                        Out.println("Das Wort wurde erraten!");
                        break;
                    }
                }
                else{
                    fail_counter += 1;
                }
            }

            if (output_word.toString().toUpperCase().equals(word.toUpperCase())){
                human_2.add_score(1);
                running = false;
                Out.println("Das Wort wurde erraten!");
                break;
            }

            if (fail_counter == fail_limit){
                human_1.add_score(1);
                running = false;
                break;
            }
        }

        Human[] opponents = new   Human[2];
        opponents[0] = human_2;
        opponents[1] = human_1;

        return opponents;   
    }

    public void clear(int n){
        for (int i = 0; i <= n; i++){
            Out.println("");
        }
    }
}
