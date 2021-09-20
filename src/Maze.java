
public class Maze {
	private int width;
	private int height;
	private char [][] maze;
	
//Controller algorithm
	//Create Model
	//Create view
	// Open File
	//Read maze
	//While (for next line{
	//read text base
	//results
	//display result
	public Maze (int width, int height) {
		this.width = width;
		this.height = height;
	    maze = new char [width][height];
	     
	}
	public char [][] getMaze(){
		return maze;
	}
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	public void set(char character, int row, int column)
	{ 
	   maze[row][column] = character;
		  
		
		
	}
	public String solve (int startrow, int startcol, int endrow, int endcol) {
		String result = "";
		
		//Must use recursion
		//Must return string of the form: r,c-r1,c1,r2-c2
		//drop breadcrumb
		//Must detect startrow and startcolumn
		// base cases
		//if we are at the end
		//   return end coordinates
		
		//we are at a dead end(zero ways to go)
		//    return null
		// count number of clear spots
		// if only one way to go
		// 	calculate the next spot's coordinates
		//  if we are changing direction 
	    //     return nextRow+"," + nextCol+"-" +solve (nextRow, nextCol, endRow, endCol) 
		//    else
		// 	return solve (nextRow, nextCol, endRow, endCol)
		
		//There are multiple ways to go
		//
		//if we can move east
		//     calculate the east coordinates
		//     results = solve(eastRow, eastCol, endRow, endCol)
		//
		//     if results != null
		//        return eastRow+ "," +eastCol+"-" result
		
		//if we can move south
				//     calculate the south coordinates
				//     results = solve(southRow, southCol, endRow, endCol)
				//
				//     if results != null
				//         return southRow+ "," +southCol+"-" result
		
		//if we can move west
				//     calculate the west coordinates
				//     results = solve(westRow, westCol, endRow, endCol)
				//
				//     if results != null
				//        return westRow+ "," +westCol+"-" result
		
		//if we can move north
				//     calculate the north coordinates
				//     results = solve(northRow, northCol, endRow, endCol)
				//
				//     if results != null
				//         return northRow+ "," +northCol+"-" result
		
		return null;
	}
	}

//Shows how to use static method in interface. Dont do that. Dont use default methods. 
//use public methods. no body. 
