
public class View {
	

	public void mazeview(Maze maze) {
		char [][] Maze = maze.getMaze();
	    for (int i = 0; i < maze.getHeight() ; i++) {
	    
			for (int j = 0; j < maze.getWidth(); j++) {
				
				System.out.println(Maze[i][j]);
	}
}
}
}
