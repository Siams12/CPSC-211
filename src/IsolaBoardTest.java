import static org.junit.Assert.*;

import org.junit.Test;

public class IsolaBoardTest {

	@Test
	public void testcreateboard() {
		IsolaBoard Board = new IsolaBoard();
		Board.getHeight();
		if (Board.getHeight() != 7) {
			fail("Expected Height to be 7");
		}
		Board.getWidth();
		if (Board.getWidth() != 7) {
			fail("Expected width to be 7");
		}
		IsolaBoard New = new IsolaBoard(9,8);
		if(New.getHeight() != 8) {
			fail("Expected Height to be 8 of the new board");
		}
		if(New.getWidth()!= 9) {
			fail("Expected Width to be 9 of the new board");
		}
	}
	@Test
	public void testGet() {
		IsolaBoard get = new IsolaBoard();
		
		if (get.get(0, 0) != BoardSpace.Available)
			fail("Expected BoardSpace at 0, 0 to be Available. Got " + get.get(0, 0));
		if (get.get(0, 3) != BoardSpace.Player1)
			fail("Expected BoardSpace at 0, 3 to be Player1. Got " + get.get(0, 3));
		if (get.get(6, 3) != BoardSpace.Player2)
			fail("Expected BoardSpace at 6, 3 to be Player2. Got " + get.get(6, 3));
		BoardPosition T = new BoardPosition(1,4);
		get.movePlayer(BoardSpace.Player1, T);
		if(get.get(0, 3)!= BoardSpace.Missing) {
			fail("Expected missing got" + get.get(0, 3));
		}
		if(get.get(1, 4) != BoardSpace.Player1) {
			fail("Expected Player1 got" + get.get(1, 4));
		}
	}
	@Test
	public void findposition() {
		IsolaBoard Position = new IsolaBoard();
		if (Position.findPosition(BoardSpace.Player1).getColumn() != 3)
		{
		fail("Position is expected to be at column 3");
		}
		if (Position.findPosition(BoardSpace.Player1).getRow() != 0)
		{
		fail("Position is expected to be at row 0");
		}
		
		if (Position.findPosition(BoardSpace.Player2).getColumn() != 3)
		{
		fail("Position is expected to be at column 3");
		}
		if (Position.findPosition(BoardSpace.Player2).getRow() != 6)
		{
		fail("Position is expected to be at row 6");
		}
		
		if (Position.findPosition(BoardSpace.Available).getColumn() != 0)
		{
		fail("Position is expected to be at column 0");
		}
		if (Position.findPosition(BoardSpace.Available).getRow() != 0)
		{
		fail("Position is expected to be at row 0");
		}
		BoardPosition L = new BoardPosition(1,2);
        Position.movePlayer(BoardSpace.Player1, L);
        //I wrote this part after making sure the move method worked.
        if (Position.findPosition(BoardSpace.Missing).getRow() != 0) {
        	fail("Position of missing expected to be at 0" + Position.findPosition(BoardSpace.Missing).getRow());
        }
        if(Position.findPosition(BoardSpace.Missing).getColumn() != 3) {
        	fail("Position of missing expected to be at 3" +Position.findPosition(BoardSpace.Missing).getColumn());
        }
    
	}
	@Test
	public void movetest() {
		IsolaBoard move = new IsolaBoard();
		BoardPosition P = new BoardPosition(1,2);
		move.movePlayer(BoardSpace.Player1, P);
		BoardPosition C = move.findPosition(BoardSpace.Player1);
		//Should move to the position
		if (C.getRow() != 1) {
			fail("The row of Player 1 doesn't equal the expected row got" + C.getRow());
		}
		if (C.getColumn()!= 2) {
			fail("The column of Player 1 doesnt equal the expected column got" + C.getColumn());
			//These two test basic movement
		}
		move.movePlayer(BoardSpace.Player1, new BoardPosition(2,3));
		move.movePlayer(BoardSpace.Player1, P);
		C = move.findPosition(BoardSpace.Player1);
		if(C.getRow() == 1) {
			fail("That is a missing space you moved from shouldnt be there" +C.getRow());
			//Tests to see if you can move back to a space you already went from
		}
		if(C.getColumn() == 2) {
			fail("That is a missing space you moved from. Shouldnt be there" + C.getColumn());
		}
		//same as above
		BoardPosition D = new BoardPosition(-1,2);
		move.movePlayer(BoardSpace.Player1, D);
		C = move.findPosition(BoardSpace.Player1);
		if(C.getRow() == -1) {
			fail("Invalid got" + C.getRow());
			//Shouldn't move because it is illegal. Tests spaces OUTSIDE the board
		}
		if(C.getColumn() == 2) {
			fail("Invalid got" + C.getColumn());
			//Shouldnt be able to move to an illegal space.
		}
		BoardPosition L = move.findPosition(BoardSpace.Player2);
		BoardPosition F = new BoardPosition(3,3);
		move.movePlayer(BoardSpace.Missing, F);
		if(move.findPosition(BoardSpace.Missing).getRow() == 3 && move.findPosition(BoardSpace.Missing).getColumn() == 3) {
			fail("Expected to not get that" + "got" + move.findPosition(BoardSpace.Missing).getRow()+ "and" + move.findPosition(BoardSpace.Missing).getColumn());
			//Shouldn't be able to move a missing piece
		}
		move.movePlayer(BoardSpace.Available, F);
		if(move.findPosition(BoardSpace.Available).getRow() == 3 && move.findPosition(BoardSpace.Available).getColumn() == 3) {
			fail("Expected to not get that" + "got" + move.findPosition(BoardSpace.Available).getRow()+ "and" + move.findPosition(BoardSpace.Available).getColumn());
			//Shouldn't be able to move an Available piece
			//Player 1 is currently at (0,1) in this test
		move.movePlayer(BoardSpace.Player2, new BoardPosition(2,5));
		move.movePlayer(BoardSpace.Player2, new BoardPosition(1,4));
		move.movePlayer(BoardSpace.Player2, new BoardPosition(0,3));
		move.movePlayer(BoardSpace.Player2, new BoardPosition(0,2));
		move.movePlayer(BoardSpace.Player2, new BoardPosition(0,1));
		L = move.findPosition(BoardSpace.Player2);
		if(L.getRow() == 1) {
			fail("Player 1 is expected to be there got" + L.getRow());
			//Cannot move where Player 1 is
		}
		if (L.getColumn() == 2){
			fail("Player 1 is expected to be there got" + L.getColumn());
		}
		//Tests movement where player 1 is
		
		}
		 
	
	}
	@Test 
	public void checkwinner() {
		IsolaBoard checkwinner = new IsolaBoard();
		if (checkwinner.checkWinner() != BoardSpace.Available){
			fail("If this method has no winners yet it returns boardspace.available Expected BoardSpace.Available got" + checkwinner.checkWinner());
			
		}
		checkwinner.movePlayer(BoardSpace.Player1, new BoardPosition(0,2));
		checkwinner.movePlayer(BoardSpace.Player1, new BoardPosition(0,1));
		checkwinner.movePlayer(BoardSpace.Player1, new BoardPosition(1,1));
		checkwinner.movePlayer(BoardSpace.Player1, new BoardPosition(1,0));
		checkwinner.movePlayer(BoardSpace.Player1, new BoardPosition(0,0));
		if (checkwinner.checkWinner() != BoardSpace.Player2) {
			fail("Player two should be winning got " + checkwinner.checkWinner());
		}
		IsolaBoard player1Wins = new IsolaBoard();
		player1Wins.movePlayer(BoardSpace.Player2, new BoardPosition(6,2));
		player1Wins.movePlayer(BoardSpace.Player2, new BoardPosition(6,1));
		player1Wins.movePlayer(BoardSpace.Player2, new BoardPosition(5,1));
		player1Wins.movePlayer(BoardSpace.Player2, new BoardPosition(5,0));
		player1Wins.movePlayer(BoardSpace.Player2, new BoardPosition(6,0));
		if (player1Wins.checkWinner() != BoardSpace.Player1) {
			fail("Player One should be winning got" + checkwinner.checkWinner());
		}
		IsolaBoard lastPlayerWins = new IsolaBoard();
		lastPlayerWins.movePlayer(BoardSpace.Player2, new BoardPosition(5,3));
		lastPlayerWins.movePlayer(BoardSpace.Player2, new BoardPosition(4,2));
		lastPlayerWins.movePlayer(BoardSpace.Player2, new BoardPosition(3,2));
		lastPlayerWins.movePlayer(BoardSpace.Player2, new BoardPosition(2,1));
		lastPlayerWins.movePlayer(BoardSpace.Player2, new BoardPosition(1,1));
		lastPlayerWins.movePlayer(BoardSpace.Player2, new BoardPosition(0,1));
		lastPlayerWins.movePlayer(BoardSpace.Player2, new BoardPosition(0,2));
		lastPlayerWins.movePlayer(BoardSpace.Player2, new BoardPosition(1,2));
		lastPlayerWins.movePlayer(BoardSpace.Player2, new BoardPosition(1,3));
		lastPlayerWins.movePlayer(BoardSpace.Player2, new BoardPosition(1,4));
		lastPlayerWins.movePlayer(BoardSpace.Player2, new BoardPosition(1,5));
		lastPlayerWins.movePlayer(BoardSpace.Player2, new BoardPosition(0,5));
		lastPlayerWins.movePlayer(BoardSpace.Player2, new BoardPosition(0,4));
		
		if (lastPlayerWins.checkWinner()!= BoardSpace.Player2) {
			fail("Player 2 should have won" + lastPlayerWins.checkWinner());
		}
		IsolaBoard lastPlayer1Wins = new IsolaBoard();
		lastPlayer1Wins.movePlayer(BoardSpace.Player2, new BoardPosition(5,3));
		lastPlayer1Wins.movePlayer(BoardSpace.Player2, new BoardPosition(4,2));
		lastPlayer1Wins.movePlayer(BoardSpace.Player2, new BoardPosition(3,2));
		lastPlayer1Wins.movePlayer(BoardSpace.Player2, new BoardPosition(2,1));
		lastPlayer1Wins.movePlayer(BoardSpace.Player2, new BoardPosition(1,1));
		lastPlayer1Wins.movePlayer(BoardSpace.Player2, new BoardPosition(0,1));
		lastPlayer1Wins.movePlayer(BoardSpace.Player2, new BoardPosition(0,2));
		lastPlayer1Wins.movePlayer(BoardSpace.Player2, new BoardPosition(1,2));
		lastPlayer1Wins.movePlayer(BoardSpace.Player2, new BoardPosition(1,3));
		lastPlayer1Wins.movePlayer(BoardSpace.Player2, new BoardPosition(1,4));
		lastPlayer1Wins.movePlayer(BoardSpace.Player2, new BoardPosition(1,5));
		lastPlayer1Wins.movePlayer(BoardSpace.Player2, new BoardPosition(1,6));
		lastPlayer1Wins.movePlayer(BoardSpace.Player2, new BoardPosition(0,6));
		lastPlayer1Wins.movePlayer(BoardSpace.Player2, new BoardPosition(0,5));
		lastPlayer1Wins.movePlayer(BoardSpace.Player1, new BoardPosition(0,4));
		if(lastPlayer1Wins.checkWinner()!= BoardSpace.Player1) {
			fail("Player 1 should have won" + lastPlayer1Wins.checkWinner());
		}
	}
	
}

