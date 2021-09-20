import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Controller {

	public static void main(String[] args) {
		Maze model = new Maze(4,4);
		View View = new View();
		Controller Controller = new Controller();
		Controller.go();

	}
	
	public Maze readMazeFromFile() {
		//read width and height of maze
	      Controller File = new Controller();
		  File file = getMazeFileFromUser();
		  Scanner input = null;
		  try {
			  input = new Scanner(file);
		  }
		  catch(FileNotFoundException e) {
			  System.out.println("Could not read the file");
		  }
		  int width = input.nextInt();
		  int height = input.nextInt();
		  Maze maze = new Maze (width, height);
		  for (int row = 0; row < height; row++) {
			  for(int column = 0; column < width; column++) {
				  String converttoCharacter = input.next();
				  char character = converttoCharacter.charAt(0);
				  maze.set(character, row, column);
			  }
		  }
		 
		  return maze;
		  
			  
		}
    public File getMazeFileFromUser() {
    	return null;
    }
	

	public void go() {
		//Read maze from file
		//for each start and end pair 
		// {
		// solve the maze
		// output the answer
		//}
		JFileChooser chooser = new JFileChooser();
		 
	    int returnVal = chooser.showOpenDialog(null);
	    
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    
	      File file = chooser.getSelectedFile();
	       Scanner input = null;
	    
	    try
	    {
	        input = new Scanner(file);
	    } catch (FileNotFoundException e)
	    {
	    	
	    	System.out.println("Could not find the file " + file.getName());
	    	return;
	    }
	}
	     Maze maze = readMazeFromFile();
		
}
}