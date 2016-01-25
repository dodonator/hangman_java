import java.io.*;
import java.util.*;

/**
 * Beschreiben Sie hier die Klasse Player.
 * 
 * @author Götz und Dominik
 * @version 9.11
 */
public class Player
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int score;
    private String name;

    /**
     * Konstruktor für Objekte der Klasse Player
     */
    public Player()
    {
        // Instanzvariable initialisieren
        score = 0;
        this.set_name();
    }

    public int get_score()
    {
        return this.score;
    }

    public void add_score(int x)
    {
        this.score = this.score + x;
    }

    public String get_name()
    {
        return this.name;
    }

    public void set_name()
    {
        Out.println("Bitte geben Sie ihren Namen ein: ");
        //Scanner input = new Scanner(System.in);
        //name = input.next();
        name = In.readWord();
    }

}
