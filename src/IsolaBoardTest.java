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
	public void getSpace() {
		for (int i = 0; i < 100; i++) {
		IsolaBoard Get = new IsolaBoard(i,i);
		//if (Get.getSpace(0, 0) ==  )
		}
	}
	@Test
	public void findposition() {
		IsolaBoard Position = new IsolaBoard();
		if (Position.findPosition(BoardSpace.Player1) != Position.get(4,4)) {
			fail("They are not the same");
		}
		Position.findPosition(BoardSpace.Player2);
		Position.findPosition(BoardSpace.Available);
		Position.findPosition(BoardSpace.Missing);
	}

}
