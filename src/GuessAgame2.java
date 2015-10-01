import java.util.Random;

import javax.swing.JOptionPane;


public class GuessAgame2 {

static boolean playAgain;
static int max; 
static int objective; 
static int userGuess;


  
    public static void main(String[] args) {

        do {
        setMax();
        setObjective();
        userGuess();
        playAgain();
        } while (playAgain == true);

    }

    
    public static void setMax() {

        boolean valid = false;

        
        while(!valid) {
            try {
                max = Integer.parseInt(JOptionPane.showInputDialog("Guess a number between 1 and \"infinite\". Set infinite: "));
                valid = true;
            }
            catch (NumberFormatException e) {}
        }


        while (max < 1 || max > Integer.MAX_VALUE) {
            valid = false;
            while (!valid) {
                try {
                    max = Integer.parseInt(JOptionPane.showInputDialog("Max must be between 1 and " + Integer.MAX_VALUE + ": "));
                    valid = true;
                }
                catch(NumberFormatException e) {}
            }
        }

    }

    /**
     * Sets the objective between 1 and "max"
     */
    public static void setObjective() {

        Random rand = new Random();

        if (max == 1)
            objective = 1;
        else
            objective = rand.nextInt(max - 1) + 1;

        // Prints objective for testing
        System.out.println(objective);

    }

    
    public static void userGuess() {

        // Prompts user for guess and ensures it's an integer
        do {
            userGuess = 0;

            try {
                userGuess = Integer.parseInt(JOptionPane.showInputDialog("Guess a number between 1 and " + max + ": "));
            }
            catch (NumberFormatException e){}

        
            while (userGuess > max || userGuess < 1) {
                try {
                    userGuess = Integer.parseInt(JOptionPane.showInputDialog(null, "Your guess must be between 1 and " + max));
                    }
                catch (NumberFormatException e) {}
            }
            userWinLose();
        } while (userGuess != objective);

    }

   
    public static void userWinLose() {


        if (userGuess < objective)
            JOptionPane.showMessageDialog(null, "Too low!");
        else if (userGuess > objective)
            JOptionPane.showMessageDialog(null, "Too high!");
        else
            JOptionPane.showMessageDialog(null, "You win!");

    }

    
    public static void playAgain() {

        boolean valid = false;

  
        while (!valid) {
            try {
                if (Integer.parseInt(JOptionPane.showInputDialog("Enter 0 to quit or 1 to play again: ")) == 0)
                    playAgain = false;
                else
                    playAgain = true;
                valid = true;
            }
            catch (NumberFormatException e) {}
        }

    }

}
