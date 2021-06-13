/*
 * Game Class for the Game of Nim 
*/
import java.util.Scanner;

public class Game
{
  /* Variables */
  private Player player1;
  private Player player2;

  /* Constructor */
  public Game()
  {
    System.out.println("Welcome to the Game of Nim!\n------------------------------");
    player1 = new Player();
    System.out.println("------------------------------");
    player2 = new Player();
  }

  /* Methods */
  /** Starts the Game of Nim, players take turns taking pieces 
      from the pile, ends until there is one more piece to take. */
  public void play()
  { 
    Player firstPlayer;
    Player secondPlayer;
    Scanner input = new Scanner(System.in);
    boolean play = true;

    // If autoplay is on, the game starts again after displaying results
    while(play)
    {
      //Randomly sets first player
      if ((int) (Math.random() * 2) == 1)
      {
        firstPlayer = player1;
        secondPlayer = player2;
      }
      else
      {
        firstPlayer = player2;
        secondPlayer = player1;
      }

      Board.populate();

      while(Board.getNumPieces() != 1)
      {
        firstPlayer.takeTurn();
        secondPlayer.takeTurn();
      }

      // Depending on the players score's, a statement will print 
      if (player1.getScore() > player2.getScore())
      {
        System.out.println("------------------------------\nThe Winner is " + player1.getName() + ", score: " + player1.getScore());
        System.out.println("The Loser is " + player2.getName() + ", score: " + player2.getScore());
      }
      else if (player1.getScore() == player2.getScore())
      {
        System.out.println("------------------------------\nIt's a Tie!\n" + player1.getName() + "'s score: " + player1.getScore());
        System.out.println(player2.getName() + "'s score: " + player2.getScore());
      }
      else
      {
        System.out.println("------------------------------\nThe Winner is " + player2.getName() + ", score: " + player2.getScore());
        System.out.println("The Loser is " + player1.getName() + ", score: " + player1.getScore());
      }

      System.out.println("------------------------------\nWant to play again? (y/n)");  
      if (input.next().equals("y"))
      {
        play = true;
      }
      else
      {
        play = false;
      }
    }

    input.close();
  }
}