/*
 * Board Class for the Game of Nim 
*/
public class Board
{
  /* Variables */
  private static int pieces;

  /* Methods */
  /** Sets the number of pieces between 10 and 50. */
  public static void populate()
  {
    pieces = (int) ((Math.random() * 41) + 10);
  }

  /** Returns the number of pieces. */
  public static int getNumPieces()
  {
    return pieces;
  }

  /** Removes the specified number of pieces from pieces. */
  public static void removePieces(int n)
  {
    pieces -= n;
  }
}