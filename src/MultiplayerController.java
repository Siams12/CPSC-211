import java.util.Scanner; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter; 

public class MultiplayerController
{
	public static void main(String[] args)
	{
		
		MultiplayerController controller = new MultiplayerController();
		controller.go();
		  
	}
	
	public PrintWriter File() {
		File IsolaMoves = new File ("BoardMoves.txt");
		PrintWriter output = null;
		  try {
	  			output = new PrintWriter(IsolaMoves);
	  					return output;
	  			
                         
	  				}
	  			 catch (FileNotFoundException e) {
	  				System.out.println("Couldn't create file");
	  				return null;
	  
	}
	}
	public boolean Direction(String User_Direction) {
		switch (User_Direction){
			case("SW"):
			case("NW"):
			case("N"):
			case("S"):
			case("W"):
			case("SE"):
			case("NE"):
			case("E"):
			return true;
		}
		return false;
	}
	
	public BoardPosition Movement(BoardPosition Position, String User_Direction) {
	switch (User_Direction) {
	case("N"):
		 return new BoardPosition(Position.getRow()-1, Position.getColumn());
	 case("W"):
		 return new BoardPosition(Position.getRow(), Position.getColumn()-1);
	 case("S"):
		 return new BoardPosition(Position.getRow()+1, Position.getColumn());
	 case("E"):
		 return new BoardPosition(Position.getRow(), Position.getColumn()+1);
	 case("SE"):
		return new BoardPosition(Position.getRow()+1, Position.getColumn()+1);
	 case("SW"):
		return new BoardPosition(Position.getRow()+1, Position.getColumn()-1);
	 case("NE"):
		 return  new BoardPosition(Position.getRow()-1, Position.getColumn()+1);
	 case("NW"):
		return new BoardPosition(Position.getRow()-1, Position.getColumn()-1);
	 }
		
		
		return null;
	}
	
	public void Write(PrintWriter directionFile, String User_Direction) {
	 directionFile.println(User_Direction);
	}
	      public void go ()
	      {   PrintWriter directionFile = File();
	    	  IsolaBoard board = new IsolaBoard();
	    	  BoardView view = new BoardView(board);
	    	  Scanner scan = new Scanner(System.in);
	    	  BoardSpace Current_Player = BoardSpace.Player1;
	    	  MultiplayerController Control  = new MultiplayerController();	
	    	  while (board.checkWinner() == BoardSpace.Available) {
	    		 view.display();
	    		 String User_Direction = " ";
	    		 BoardPosition Player_Position = board.findPosition(Current_Player);
	    		 BoardPosition P = Movement(Player_Position, User_Direction);
	    		 
	    		 while (Control.Direction(User_Direction) == false){
	    			 
	    		 System.out.println(Current_Player + " what is your move?");
	    		 User_Direction = scan.nextLine();
	    		 }		
	    		 P = Movement(Player_Position, User_Direction);
	    		 board.movePlayer(Current_Player, P);
	    		 if (!Player_Position .equals(board.findPosition(Current_Player))){
	    		 Write(directionFile,User_Direction);
	    		 //Had to have the writing after the movement to check for the movement to be correct.
	    		 view.display();
	    		
	    		 if (Current_Player == BoardSpace.Player1) {
	    			 Current_Player = BoardSpace.Player2;
	    		 }
	    		 else {
	    			 Current_Player = BoardSpace.Player1;
	    		 }
	    		 
		    	  
	    	  
	    	  if (board.checkWinner() == BoardSpace.Player1) {
		    	  System.out.println("Player 1 wins!");
		      }
		      if (board.checkWinner() == BoardSpace.Player2) {
		    	  System.out.println("Player 2 wins!");
		      }}}
		      Close(directionFile);
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
	      
	      
	      

	      public void Close(PrintWriter directionFile) {
	    	  
	    	  directionFile.close();
	      }
	}

