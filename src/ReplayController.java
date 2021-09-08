	import java.util.Scanner; 
		import java.io.File;
		import java.io.FileNotFoundException;
		import java.io.PrintWriter; 
public class ReplayController {
	public static void main(String[] args) {
		ReplayController controller = new ReplayController();
		controller.go();
	}
		
		
			public Scanner Scan() {
			  MultiplayerController File = new MultiplayerController();
			  File IsolaMoves = new File ("BoardMoves.txt");
			  Scanner input = null;
			  try {
				  input = new Scanner(IsolaMoves);
				  return input;
			  }
			  catch(FileNotFoundException e) {
				  System.out.println("Could not read the file");
				  return null;  
			  }
			}
			
			public String Read(Scanner scanFile) {
			  String User_Direction = scanFile.next();
			  return User_Direction;
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
			
			
			
			      public void go () {   
			    	  Scanner scanFile = Scan();
			    	  IsolaBoard board = new IsolaBoard();
			    	  BoardView view = new BoardView(board);
			    	  Scanner scan = new Scanner(System.in);
			    	  BoardSpace Current_Player = BoardSpace.Player1;
			    	  MultiplayerController Control  = new MultiplayerController();	
			    	  while (board.checkWinner() == BoardSpace.Available) {
			    		 view.display();
			    		 String User_Direction = " ";
			    		 BoardPosition Player_Position = board.findPosition(Current_Player);
			    		 User_Direction = Read(scanFile);
			    		 BoardPosition P = Movement(Player_Position, User_Direction);
			    		 board.movePlayer(Current_Player, P);
			    		 view.display();
			    		 if (Current_Player == BoardSpace.Player1) {
			    			 Current_Player = BoardSpace.Player2;
			    		 }
			    		 else {
			    			 Current_Player = BoardSpace.Player1;
			    		 }
			    		 
				    	  
			    	  }
			    	  if (board.checkWinner() == BoardSpace.Player1) {
				    	  System.out.println("Player 1 wins!");
				      }
				      if (board.checkWinner() == BoardSpace.Player2) {
				    	  System.out.println("Player 2 wins");
				      }
				      
				     
		//Open output.dat
		//Create board
		//Create text view
		
		//while game is not over
		// {
		// display board
		
		// read player move from output.dat
		// make move on board
		// switch to next player
		//display for 1 second
		// }
		
		//display board
		
		//close output.dat
	}
			      public void close(Scanner scanFile) {
			    	  scanFile.close();
			      }
}
