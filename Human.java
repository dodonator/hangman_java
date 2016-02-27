import java.io.*;
import java.util.*;
/**
 * Human ist die Klasse für einen menschlichen Spieler
 * 
 * @author Götz und Dominik
 * @version 9.11
 */
public class Human extends Player
{

    public Human()
    {

    }

    public void set_name(){
        Out.println("Spieler: ");
        Out.println("Bitte geben Sie ihren Namen ein");
        this.name = In.readWord();
        Out.println("");
    }

    public String word_input()
    {
        System.out.println(this.get_name() + ", bitte geben Sie ein Wort ein: ");
        String word = In.readWord();
        word = word.toUpperCase();
        if (word.equals("PENIS"))
        {
            Out.println("");
            Out.println("Sorry, dein 'Wort' ist zu kurz!");
            Out.println("");
            this.sleep(2);
        }

        return word;
    }

    public String guess()
    {
        System.out.println(this.get_name() + ", bitte geben Sie einen Buchstaben ein: ");
        String chr = In.readWord();
        chr = chr.toUpperCase();
        return chr;
    }

    public void sleep(int seconds)
    {
        int milli_seconds = 1000 * seconds;
        try {
            Thread.sleep(milli_seconds);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
