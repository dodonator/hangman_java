
/**
 * Die Klasse Game, laesst den Spieler den Spielmodus
 * aussuchen und ruft diesen anschliessend auf.
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
            Out.println(" _    _ ");                                        
            Out.println("| |  | | ");                                        
            Out.println("| |__| | __ _ _ __   __ _ _ __ ___   __ _ _ __ "); 
            Out.println("|  __  |/ _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ ");
            Out.println("| |  | | (_| | | | | (_| | | | | | | (_| | | | |");
            Out.println("|_|  |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|");
            Out.println("                     __/ |                      ");
            Out.println("                    |___/      ");
            Out.println("");
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
        // Good Bye!
        Out.println("  _____                 _   ____ ");           
        Out.println(" / ____|               | | |  _ \\   ");         
        Out.println("| |  __  ___   ___   __| | | |_) |_   _  ___ ");
        Out.println("| | |_ |/ _ \\ / _ \\ / _` | |  _ <| | | |/ _ \\");
        Out.println("| |__| | (_) | (_) | (_| | | |_) | |_| |  __/");
        Out.println(" \\_____|\\___/ \\___/ \\__,_| |____/ \\__, |\\___|");
        Out.println("                                   __/ |     ");
        Out.println("                                  |___/ ");

    }

    private void clear(){
        Out.print('\u000C');
    }
}
