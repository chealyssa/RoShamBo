/* 
  Che Alyssa Zulaik & Kentaro Fujii
  Psedocode:
  - Welcome note 
  - Ask user for input 
    - Rock, paper or scissor 
      - check input (only see if it matched)
      - if not just asks user to reenter 
  - Use random number to choose between 0 - 2
    - [Rock,Paper,Scissors]
*/
import java.util.Scanner;
import java.util.Random;
class Main {

  public static void main(String[] args) {
    startGame();
  }

  
  public static void startGame(){
    System.out.println();
    System.out.println("Welcome to Rock, Paper, Scissor game! Hope you enjoy, this was done in two hours :)");
    System.out.println();
    Scanner kb = new Scanner(System.in);
    String userChoice = userChoice(kb);
    String robotChoice = robotChoice();
    compareAnswers(userChoice, robotChoice); 
  }
  
  /**
This method askes the user for an input of either "rock" "paper" or "scissors". Once inputted, this method will make sure if the input answer matches with the correct spelling(ignores letter case). If the user inputs something other than "rock" "paper" or "scissors", then it will output a message saying to try again and that the input was invalid. Once the user inputs the proper spelling of "rock" "paper" or "scissors", then it will return what was input for an output.
  */
  public static String userChoice(Scanner kb){
    boolean input = true; //assumes answer if ture
    String choice = "";
    System.out.print("Pick rock, paper, or scissors: ");
      while(input){
        choice = kb.nextLine(); //takes users input
        if (choice.equalsIgnoreCase("rock")   //see if input matches with preset answers  
            ||choice.equalsIgnoreCase("paper")
            ||choice.equalsIgnoreCase("scissors")){
          input = false // exits while loop
        }
        else{ //if input is invalid these repsonses will be outputed
          System.out.println("Invalid input, Please try again");
          System.out.print("Pick rock, paper, or scissors: ");
        }
      }
    return choice; // returns users choice
    
  }

  /**
This is a method that creates the choice for the computer. It starts by createing a random number generator between 1 and   3. It then takes the index that was created and compares it to teh array. ounce the index is given and the array is chosen it will return what the array choice outputs.
  */
  public static String robotChoice(){
    Random rand = new Random();
    int index = rand.nextInt(3) + 1; //creates a random number generator between 1 and 3
    String[] choiceArray = {"", "Rock", "Paper", "Scissors"}; //creates an array 
    String robotChoice = choiceArray[index];// takes index bewtween 1 and 3 and uses it to call the array
    return robotChoice; // should return either rock/paper/sci
  }

  
  /**
This method compares the asnwers the computers gives and what the user inputs. If both answers are the same the game will end in a draw and if the computer wins, there will be an output saying so and vise versa.
  */
  public static void compareAnswers(String userChoice, String robotChoice){
    System.out.println("You chose: " +userChoice);
    System.out.println("The robot chose: " +robotChoice);
    System.out.println();
    // If user and robot have the same choice - DRAW 
    if(userChoice.equalsIgnoreCase(robotChoice)){
      System.out.print("Game ends in a draw");
    } 
      
    // If user is rock and robot is paper - robot wins
    else if(userChoice.equalsIgnoreCase("rock") && robotChoice.equals("Paper")){
      System.out.print("Sorry you lose! :(");
    }

    // If user is rock and robot is scissors - user wins 
    else if(userChoice.equalsIgnoreCase("rock") && robotChoice.equals("Scissors")){
            System.out.print("Congrats you win! :)");
    }

    // If user is paper and robot is rock - user wins 
    else if(userChoice.equalsIgnoreCase("paper") && robotChoice.equals("Rock")){
            System.out.print("Congrats you win! :)");
    }
    // If user is paper and robot is scissors - robot wins 
    else if(userChoice.equalsIgnoreCase("paper") && robotChoice.equals("Scissors")){
            System.out.print("Sorry you lose! :(");
    }

    // If user is scissors and robot is rock - robot wins 
    else if(userChoice.equalsIgnoreCase("scissors") && robotChoice.equals("Rock")){
            System.out.print("Sorry you lose! :(");
    }
    // If user is scissors and robot is paper - user wins 
    else{
      System.out.print("Congrats you win! :)");
    }
  }
}
