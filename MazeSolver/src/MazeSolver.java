import java.util.LinkedList;

public class MazeSolver {

	static int[][] maze = {
			{2, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1},
			{1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0},
			{1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0},
			{1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
			{0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0},
			{0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0}
	};
	//0 = wall
	//1 = path
	//2 = destination
	
	static LinkedList<Position> path = new LinkedList<Position>();
	
	public static void main(String[] args) {
		
		Position p = new Position(3, 12);		
		path.push(p);
		
		
		
		while(true) {
			
			int y = path.peek().y;
			int x = path.peek().x;
			maze[x][y] = 0;
			
			//down
			if(isValid(x+1, y)) {
				
				if(maze[x+1][y] == 2) {
					System.out.println("Moved down and you win!");
					return;
				} else if(maze[x+1][y] == 1) {
					System.out.println("Moved down");
					path.push(new Position(x+1, y));
					continue;
				}
			}
			
			//left
			if(isValid(x, y-1)) {
				
				if(maze[x][y-1] == 2) {
					System.out.println("Moved left and you win!");
					return;
				} else if(maze[x][y-1] == 1) {
					System.out.println("Moved left");
					path.push(new Position(x, y-1));
					continue;
				}
			}
			
			//up
			if(isValid(x-1, y)) {
				
				if(maze[x-1][y] == 2) {
					System.out.println("Moved up and you win!");
					return;
				} else if(maze[x-1][y] == 1) {
					System.out.println("Moved up");
					path.push(new Position(x-1, y));
					continue;
				}
			}
			
			//right
			if(isValid(x, y+1)) {
				
				if(maze[x][y+1] == 2) {
					System.out.println("Moved right and you win!");
					return;
				} else if(maze[x][y+1] == 1) {
					System.out.println("Moved right");
					path.push(new Position(x, y+1));
					continue;
				}
			}
			
			
			path.pop();
			System.out.println("Moved back");
			if(path.size() <= 0) {
				System.out.println("No path");
				return;
			}
		}
		
		
		
		

	}
	
	public static boolean isValid(int x, int y) {
		
		
		if(x < 0 || x >= maze.length || y < 0 || y >= maze[x].length) {
			return false;
		} else {
			return true;
		}
	}

}
