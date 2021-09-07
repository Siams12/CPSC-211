import java.util.Scanner; 
import java.io.File; 

public class MultiplayerController
{
	public static void main(String[] args)
	{
		
		MultiplayerController controller = new MultiplayerController();
		controller.go();
		  
	}
	
	public boolean Direction(String User_Direction) {
		switch (User_Direction){
			case ("SW"):
			case ("NW"):
			case ("N"):
			case ("S"):
			case ("W"):
			case ("SE"):
			case("NE"):
			case("E"):
			return true;
		}
		return false;
	}
	      public void go ()
	      {
	    	  IsolaBoard board = new IsolaBoard();
	    	  BoardView view = new BoardView(board);
	    	  Scanner scan = new Scanner(System.in);
	    	  String Current_Player = "Player_1";
	    	  MultiplayerController Control  = new MultiplayerController();
	    	  while (board.checkWinner() == BoardSpace.Available) {
	    		 view.display();
	    		 String User_Direction = " ";
	    		 while (Current_Player .equals("Player_1")) {
	    		 BoardPosition Player_Position = board.findPosition(BoardSpace.Player1);
	    		 while (Control.Direction(User_Direction) == false) {
	    			 
	    		 System.out.println("Player 1 what is your move?");
	    		 User_Direction = scan.nextLine();
	    		 }
	    		 switch (User_Direction) {
	    		 case("N"):
	    			 BoardPosition North = new BoardPosition(Player_Position.getRow()-1, Player_Position.getColumn());
	    			 board.movePlayer(BoardSpace.Player1 , North);
	    			 break;
	    		 case("W"):
	    			 BoardPosition West = new BoardPosition(Player_Position.getRow(), Player_Position.getColumn()-1);
	    			 board.movePlayer(BoardSpace.Player1, West);
	    			 break;
	    		 case("S"):
	    			 BoardPosition South = new BoardPosition(Player_Position.getRow()+1, Player_Position.getColumn());
	    			 board.movePlayer(BoardSpace.Player1, South); 
	    			 break;
	    		 case("E"):
	    			 BoardPosition East = new BoardPosition(Player_Position.getRow(), Player_Position.getColumn()+1);
	    			 board.movePlayer(BoardSpace.Player1, East);
	    			 break;
	    		 case("SE"):
	    			 BoardPosition Southeast = new BoardPosition(Player_Position.getRow()+1, Player_Position.getColumn()+1);
	    			 board.movePlayer(BoardSpace.Player1, Southeast);
	    			 break;
	    		 case("SW"):
	    			 BoardPosition Southwest = new BoardPosition(Player_Position.getRow()+1, Player_Position.getColumn()-1);
	    			 board.movePlayer(BoardSpace.Player1, Southwest);
	    			 break;
	    		 case("NE"):
	    			 BoardPosition Northeast = new BoardPosition(Player_Position.getRow()-1, Player_Position.getColumn()+1);
	    			 board.movePlayer(BoardSpace.Player1, Northeast);
	    			 break;
	    		 case("NW"):
	    			 BoardPosition NorthWest = new BoardPosition(Player_Position.getRow()-1, Player_Position.getColumn()-1);
	    			 board.movePlayer(BoardSpace.Player1, NorthWest);
	    		 }
	    		  if (board.checkWinner() == BoardSpace.Player1) {
			    	  System.out.println("Player 1 wins!");
			      }
			      if (board.checkWinner() == BoardSpace.Player2) {
			    	  System.out.println("Player 2 wins");
			      }
		    	  
	    		 view.display();
	    		 Current_Player = "Player_2";
	    		 }
	    		 while (Current_Player .equals("Player 2")) { 
	    		 }
	    		 BoardPosition Player_Position = board.findPosition(BoardSpace.Player2);
	    		 User_Direction = " ";
	    		 while (Control.Direction(User_Direction) == false) {
	    		 System.out.println("Player 2 what is your move?");
	    		 User_Direction = scan.nextLine();
	    		 }
	    		 switch (User_Direction) {
	    		 case("N"):
	    			 BoardPosition North = new BoardPosition(Player_Position.getRow()-1, Player_Position.getColumn());
	    			 board.movePlayer(BoardSpace.Player2 , North);
	    			 break;
	    		 case("W"):
	    			 BoardPosition West = new BoardPosition(Player_Position.getRow(), Player_Position.getColumn()-1);
	    			 board.movePlayer(BoardSpace.Player2, West);
	    			 break;
	    		 case("S"):
	    			 BoardPosition South = new BoardPosition(Player_Position.getRow()+1, Player_Position.getColumn());
	    			 board.movePlayer(BoardSpace.Player2, South);
	    			 break;
	    		 case("E"):
	    			 BoardPosition East = new BoardPosition(Player_Position.getRow(), Player_Position.getColumn()+1);
	    			 board.movePlayer(BoardSpace.Player2, East);
	    			 break;
	    		 case("SE"):
	    			 BoardPosition Southeast = new BoardPosition(Player_Position.getRow()+1, Player_Position.getColumn()+1);
	    			 board.movePlayer(BoardSpace.Player2, Southeast);
	    			 break;
	    		 case("SW"):
	    			 BoardPosition Southwest = new BoardPosition(Player_Position.getRow()+1, Player_Position.getColumn()-1);
	    			 board.movePlayer(BoardSpace.Player2, Southwest);
	    			 break;
	    		 case("NE"):
	    			 BoardPosition Northeast = new BoardPosition(Player_Position.getRow()-1, Player_Position.getColumn()+1);
	    			 board.movePlayer(BoardSpace.Player2, Northeast);
	    			 break;
	    		 case("NW"):
	    			 BoardPosition NorthWest = new BoardPosition(Player_Position.getRow()-1, Player_Position.getColumn()-1);
	    			 board.movePlayer(BoardSpace.Player2, NorthWest);
	    			 
	    		 }
	    		 if (board.checkWinner() == BoardSpace.Player1) {
			    	  System.out.println("Player 1 wins!");
			      }
			      if (board.checkWinner() == BoardSpace.Player2) {
			    	  System.out.println("Player 2 wins");
			      }
		    	  
	    	  Current_Player = "Player_1";
	    	  }
	    	  //create board
	    	  //create a view attached to that board
	    	  //create output.dat
	    	  //while game is not over
	    	  //{
	    	  //  display board
	    	  // ask current player for their move
	    	  // write move to output.dat
	    	  // make that move on the board
	    	  // Check to see if game is over
	    	  // Switch to next player
	    	  // }
	    	  //display board
	    	  //close output.dat
	      
	      
	      
}
	}

