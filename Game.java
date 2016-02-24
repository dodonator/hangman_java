
/**
 * Beschreiben Sie hier die Klasse Game.
 * 
 * @author Dominik und Götz
 * @version 9.11
 */
public class Game
{

    public Game()
    {
        String game_mode = "";
        while ( !game_mode.equals("q")){

            this.clear();
            Out.println("0: Spieler gegen Spieler");
            Out.println("");
            Out.println("1: Spieler gegen Computer");
            Out.println("   Der Spieler gibt das Wort ein");
            Out.println("   Der Computer versucht, das Wort zu erraten");
            Out.println("");
            Out.println("2: Computer gegen Spieler");
            Out.println("   Der Computer gibt das Wort ein");
            Out.println("   Der Spieler versucht, das Wort zu erraten");
            Out.println("");
            Out.println("q: Beenden!");
            Out.println("");
            game_mode = In.readWord();
            this.clear();

            if (game_mode.equals("0"))
            {
                PVP mode = new PVP();
            }
            else{
                if (game_mode.equals("1"))
                {
                    PVC mode = new PVC();
                }
                else
                {
                    if (game_mode.equals("2")){
                        CVP mode = new CVP();
                    }
                    else
                    {
                        game_mode = "q";
                    }
                }
            }
        }
    }

    private void clear(){
        Out.print('\u000C');
    }
}
