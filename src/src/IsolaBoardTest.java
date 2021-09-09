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

		Position.findPosition(BoardSpace.Player2);
		Position.findPosition(BoardSpace.Available);
		Position.findPosition(BoardSpace.Missing);
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
		}
		BoardPosition D = new BoardPosition(-1,2);
		move.movePlayer(BoardSpace.Player1, D);
		
		if(move.findPosition(BoardSpace.Player1).getRow() != -1) {
			fail("Invalid got" + C.getRow());
			//Shouldn't move because it is illegal.
		}
		 
	
	}
	public void checkwinner() {
		IsolaBoard checkwinner = new IsolaBoard();
		if () {
			
		}
	}
	
}

