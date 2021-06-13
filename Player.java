/*
 * Player Class for the Game of Nim 
*/
import java.util.Scanner;

public class Player
{
  /* Instance Variables */
  private String name;
  private int score;

  /* Constructors */
  public Player()
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter name: ");
    name = sc.nextLine();
    System.out.println("Welcome " + name + " to the Game of Nim!");
  }

  public Player(String name)
  {
    this.name = name;
    System.out.println("Welcome " + this.name + " to the Game of Nim!");
  }

  /* Methods */
  /** Returns the player's name.*/
  public String getName()
  {
    return name;
  }

  /** Returns the player's score.*/
  public int getScore()
  {
    return score;
  }

  /** Increases the player's score by 1.*/
  public void incrScore()
  {
    score ++;
  }

  /** The player is displayed the pile size and enters the amount they want to take away. */
  public void takeTurn()
  {
    if (Board.getNumPieces() != 1)
    { 
      if (Board.getNumPieces() == 2)
      {
        this.incrScore();
      }

      Scanner input = new Scanner(System.in);
      int remove;

      System.out.println("------------------------------\nPile Size: " + Board.getNumPieces());
      System.out.println(this.name + " can take 1 piece or up to " + Board.getNumPieces()/2 + " pieces:");
      System.out.print(this.name + " takes: ");

      remove = input.nextInt();

      // The player must enter an integer between 1 and half the pile size.
      while((remove < 1) || (remove > (Board.getNumPieces() / 2)))
      {
        System.out.println("Please enter an integer between 1 and " + (Board.getNumPieces() / 2) + ":");
        remove = input.nextInt();
      }
      
      Board.removePieces(remove);
    }
  }
}