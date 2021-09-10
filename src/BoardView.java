
public class BoardView {
	private IsolaBoard board;

	public BoardView(IsolaBoard board) {
		this.board = board;
	}

	public void display() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (board.get(i, j) == BoardSpace.Available) {
					System.out.print("-");
				}
				if (board.get(i, j) == BoardSpace.Player2) {
					System.out.print("2");
				}
				if (board.get(i, j) == BoardSpace.Player1) {
					System.out.print("1");
				}
				if (board.get(i, j) == BoardSpace.Missing) {
						System.out.print(" ");
					
				}
			}
			System.out.println("");

		}

	}
}
