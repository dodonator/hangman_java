import java.io.*;
import java.util.*;
/**
 * Human ist die Klasse f�r einen menschlichen Spieler
 * 
 * @author G�tz und Dominik
 * @version 9.11
 */
public class Human extends Player
{


    /**
     * Constructor for objects of class Human
     */
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
        Scanner input = new Scanner(System.in);
        System.out.println(this.get_name() + ", bitte geben Sie ein Wort ein: ");
        String word = input.next();
        word = word.toUpperCase();
        return word;
    }

    public String guess()
    {
        Scanner input = new Scanner(System.in);
        System.out.println(this.get_name() + ", bitte geben Sie einen Buchstaben ein: ");
        String chr = input.next();
        chr = chr.toUpperCase();
        return chr;
    }
    
}
