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
	public void movetest() {
		IsolaBoard move = new IsolaBoard();
		if (move.findPosition(BoardSpace.Player1).getRow() == move.movePlayer(BoardSpace.Player1,move.findPosition(BoardSpace.Player1).getRow() )) {
			fail("");
		}
		if() {
		fail("");
	}
	}
	public void checkwinner() {
		IsolaBoard checkwinner = new IsolaBoard();
		if () {
			
		}
	}
	
}

