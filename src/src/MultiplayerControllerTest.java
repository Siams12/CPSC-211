import static org.junit.Assert.*;

import org.junit.Test;

public class MultiplayerControllerTest {

	@Test
	public void testDirection() {
		MultiplayerController Direction = new MultiplayerController();
		if (Direction.Direction("NW") == false) {
		fail("Expected to return true got" + (Direction.Direction("NW"))  );
		}
		if (Direction.Direction("NorthWest") == true) {
			fail("Expected to return false got" + (Direction.Direction("NorthWest")));
		}
	}
	@Test
	public void testMovement() {
		MultiplayerController Movement = new MultiplayerController();
		BoardPosition NW = Movement.Movement(new BoardPosition(2,3) , "NW");
		if(!NW .equals(new BoardPosition(1,2)) ) {
			fail("not expected got" + NW);
		}
		BoardPosition NE = Movement.Movement(new BoardPosition (5,6) , "NE");
		if (!NE .equals(new BoardPosition(4,7))) {
			fail("not expected got " + NE);
		}
		BoardPosition N = Movement.Movement(new BoardPosition (5,6) , "N");
		if (!N .equals(new BoardPosition(4,6))) {
			fail("not expected got " + N);
		}
		BoardPosition W = Movement.Movement(new BoardPosition (5,6) , "W");
		if (!W .equals(new BoardPosition(5,5))) {
			fail("not expected got " + W);
		}
		BoardPosition E = Movement.Movement(new BoardPosition (5,6) , "E");
		if (!E .equals(new BoardPosition(5,7))) {
			fail("not expected got " + E);
		}
		BoardPosition S = Movement.Movement(new BoardPosition (5,6) , "S");
		if (!S .equals(new BoardPosition(6,6))) {
			fail("not expected got " + S);
		}
		BoardPosition SE = Movement.Movement(new BoardPosition (5,6) , "SE");
		if (!SE .equals(new BoardPosition(6,7))) {
			fail("not expected got " + SE);
		}
		BoardPosition SW = Movement.Movement(new BoardPosition (5,6) , "SW");
		if (!SW .equals(new BoardPosition(6,5))) {
			fail("not expected got " + SW);
		}
	}
	public void testgo() {
		
	}

}
