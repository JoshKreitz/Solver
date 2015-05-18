package SudokuSolver;

import java.util.Scanner;

public class Board {
	private int[][] board;
	/*{{7,0,0,0,8,1,2,0,4},
			{5,8,0,0,0,4,0,0,0},
			{0,1,0,0,0,5,7,0,9},
			{3,0,0,0,1,0,4,9,0},
			{0,0,8,6,0,2,1,0,0},
			{0,5,1,0,7,0,0,0,3},
			{4,0,5,8,0,0,0,1,0},
			{0,0,0,1,0,0,0,3,7},
			{1,0,3,2,5,0,0,0,8}
		};*/
	//private String newScr = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
	private int[][] backup = {{-1}};

	public Board(){
		board = new int[9][9];

		inputBoard();
	}

	public void printBoard(int step){
		System.out.println("==============================================================STEP "+step+"=======================");
		for(int a = 0; a<9; a++){
			for(int b = 0; b<9; b++){
				System.out.print(board[a][b] + " ");
				if(b == 2 || b == 5)System.out.print("  |  ");
			}
			if(a == 2 || a == 5){
				System.out.print("\n---------------------------");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void inputBoard(){
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a string of all the numbers: ");
		String temp = kb.nextLine();
		int index = 0;
		for(int r = 0; r<9; r++)
			for(int c = 0; c<9; c++){
				board[r][c] = Integer.parseInt(""+temp.charAt(index));

				index++;
			}
		kb.close();
	}

	public int get(int r, int c){
		return board[r][c];
	}

	
	public void set(int r, int c, int target){
		board[r][c] = target;
	}

	public boolean isEligible(int r, int c, int t){
		return board[r][c]==0 && !rowContains(r,t) && !colContains(c,t) && !cubeContains(r,c,t);
	}

	public boolean rowContains(int row, int target){
		for(int x: board[row])
			if(x == target)return true;
		return false;
	}

	public boolean colContains(int col, int target){
		for(int[] x: board)
			if(x[col] == target)return true;
		return false;
	}

	public boolean cubeContains(int r, int c, int target){
		int cube = 0;
		if(r<=2 && c<=2)cube = 1;
		else if(r<=2 && c>=3 && c<=5)cube = 2;
		else if(r<=2 && c>=6)cube = 3;
		else if(r>=3 && r<=5 && c<=2)cube = 4;
		else if(r>=3 && r<=5 && c>=3 && c<=5)cube = 5;
		else if(r>=3 && r<=5 && c>=6)cube = 6;
		else if(r>=6 && c<=2)cube = 7;
		else if(r>=6 && c>=3 && c<=5)cube = 8;
		else if(r>=6 && c>=6)cube = 9;

		switch(cube){
		case 1:
			r = 0;
			c = 0;
			break;
		case 2:
			r = 0;
			c = 3;
			break;
		case 3:
			r = 0;
			c = 6;
			break;
		case 4:
			r = 3;
			c = 0;
			break;
		case 5:
			r = 3;
			c = 3;
			break;
		case 6:
			r = 3;
			c = 6;
			break;
		case 7:
			r = 6;
			c = 0;
			break;
		case 8:
			r = 6;
			c = 3;
			break;
		case 9:
			r = 6;
			c = 6;
			break;
		}

		for(int i = r; i<r+3; i++)
			for(int s = c; s<c+3; s++)
				if(board[i][s] == target)return true;
		return false;
	}

	public boolean gameDone(){
		for(int i = 0; i<9; i++)
			if(rowContains(i,0))return false;
		return true;
	}
	
	public int[] getNeededRowNumbers(int r){
		String possible = "123456789";
		for(int x: board[r])
			if(x != 0)possible.replaceAll(""+x,"");
		int[] done = new int[possible.length()];
		for(int i = 0; i<done.length; i++)
			done[i] = Integer.parseInt(""+possible.charAt(i));
		return done;
	}

	public int[] getNeededColNumbers(int c){
		String possible = "123456789";
		for(int[] x: board)
			if(x[c] != 0)possible.replaceAll(""+x[c],"");
		int[] done = new int[possible.length()];
		for(int i = 0; i<done.length; i++)
			done[i] = Integer.parseInt(""+possible.charAt(i));
		return done;
	}

	public void makeBackup(){
		backup = new int[9][9];
		for(int r = 0; r<9; r++)
			for(int c = 0; c<9; c++)
				backup[r][c] = board[r][c];
	}

	public boolean changed(){
		for(int r = 0; r<9; r++)
			for(int c = 0; c<9; c++)
				if(board[r][c]!=backup[r][c])return true;
		return false;
	}

	public void verify(){
		for(int r = 0; r<9; r++){
			String needed = "123456789";
			for(int c = 0; c<9; c++){
				needed = needed.replaceAll(""+board[r][c], "");
			}
			if(!(needed.length()==0)){
				System.out.println("NOT VALID IN ROW "+r+"\nLEFT OVER: "+needed);
				return;
			}
		}

		for(int c = 0; c<9; c++){
			String needed = "123456789";
			for(int r = 0; r<9; r++){
				needed = needed.replaceAll(""+board[r][c], "");
			}
			if(!(needed.length()==0)){
				System.out.println("NOT VALID IN COL "+c+"\nLEFT OVER: "+needed);
				return;
			}
		}

		System.out.println("VALID");
	}
}
























