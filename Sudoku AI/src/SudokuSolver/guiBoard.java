package SudokuSolver;

import java.util.Scanner;

public class guiBoard {
	private int[][] board;
	//private String newScr = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
	private int[][] backup = new int[9][9];
	private String[][] ableBackup = new String[9][9];

	private String[][] able;

	String[] madeInferences = new String[200];
	int madeInferencesIndex = 0;

	public guiBoard(){
		board = new int[9][9];
		able = new String[9][9];
		for(int r = 0; r<9; r++)
			for(int c = 0; c<9; c++)
				able[r][c] = "123456789";
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

	public int get(int r, int c){
		return board[r][c];
	}
/*
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
*/
	public void makeBackup(){
		for(int r = 0; r<9; r++)
			for(int c = 0; c<9; c++){
				backup[r][c] = board[r][c];
				ableBackup[r][c] = able[r][c];
			}
	}

	public boolean changed(){
		for(int r = 0; r<9; r++)
			for(int c = 0; c<9; c++)
				if(board[r][c]!=backup[r][c] || !able[r][c].equals(ableBackup[r][c]))return true;
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

	public boolean isEligible(int r, int c, int t){
		return able[r][c].contains(""+t);
	}

	public boolean gameDone(){
		for(int[] y: board)
			for(int x: y)
				if(x==0)return false;
		return true;
	}

	public void inputBoard(String temp){
		int index = 0;
		for(int r = 0; r<9; r++)
			for(int c = 0; c<9; c++){
				board[r][c] = Integer.parseInt(""+temp.charAt(index));
				if(board[r][c]!=0){
					able[r][c] = "";
					remove(r,c,board[r][c]);
				}

				index++;
			}
	}

	public void remove(int r, int c, int t){
		for(int i = 0; i<9; i++)
			able[r][i] = able[r][i].replaceAll(""+t,"");

		for(int i = 0; i<9; i++)
			able[i][c] = able[i][c].replaceAll(""+t,"");

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

		for(int r2 = r; r2<r+3; r2++)
			for(int c2 = c; c2<c+3; c2++)
				able[r2][c2] = able[r2][c2].replaceAll(""+t,"");
	}

	public void set(int r, int c, int t){
		board[r][c] = t;
		remove(r,c,t);
		able[r][c] = "";
	}

	public String getAble(int r, int c){
		return able[r][c];
	}
/*
	public boolean rowFull(int r){
		for(int x: board[r])
			if(x==0)return false;
		return true;
	}

	public boolean colFull(int c){
		for(int[] x: board)
			if(x[c]==0)return false;
		return true;
	}
*/
	public boolean twoInLine(String indecies, int t){
		int combined = Integer.parseInt(indecies);
		int r1 = combined/1000, c1 = (combined/100)%10;
		int r2 = (combined/10)%10, c2 = combined%10;

		if(r1 == r2 && isEligibleInference(indecies,t)){
			removeFromRowExceptCube(r1,c1,t);
			addInference(indecies,t);
			return true;
		}
		else if(c1 == c2 && isEligibleInference(indecies,t)){
			removeFromColExceptCube(r1,c1,t);
			addInference(indecies,t);
			return true;
		}
		return false;
	}

	public boolean threeInLine(String indecies, int t){
		int combined = Integer.parseInt(indecies);
		int r1 = combined/100000, c1 = (combined/10000)%10;
		int r2 = (combined/1000)%10, c2 = (combined/100)%10;
		int r3 = (combined/10)%10, c3 = combined%10;

		if(r1 == r2 && r2 == r3 && isEligibleInference(indecies,t)){
			removeFromRowExceptCube(r1,c1,t);
			addInference(indecies,t);
			return true;
		}
		else if(c1 == c2 && c2 == c3 && isEligibleInference(indecies,t)){
			removeFromColExceptCube(r1,c1,t);
			addInference(indecies,t);
			return true;
		}
		return false;
	}

	public void removeFromRowExceptCube(int r, int c, int t){
		gui.append("MADE A ROW INFERENCE OF A "+t+" AT ROW "+r+"\n");
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
			c = 0;
			break;
		case 2:
			c = 3;
			break;
		case 3:
			c = 6;
			break;
		case 4:
			c = 0;
			break;
		case 5:
			c = 3;
			break;
		case 6:
			c = 6;
			break;
		case 7:
			c = 0;
			break;
		case 8:
			c = 3;
			break;
		case 9:
			c = 6;
			break;
		}

		for(int x = 0; x<9; x++){
			if(x == c){
				x += 2;
				continue;
			}
			else if(x == c+1){
				x+=1;
				continue;
			}
			else if(x == c+2){
				continue;
			}
			able[r][x] = able[r][x].replaceAll(""+t,"");
		}
	}

	public void removeFromColExceptCube(int r, int c, int t){
		gui.append("MADE A COL INFERENCE OF A "+t+" AT COL "+c+"\n");
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

		//r = ((cube-1)%3)*3;
		switch(cube){
		case 1:
			r = 0;
			break;
		case 2:
			r = 0;
			break;
		case 3:
			r = 0;
			break;
		case 4:
			r = 3;
			break;
		case 5:
			r = 3;
			break;
		case 6:
			r = 3;
			break;
		case 7:
			r = 6;
			break;
		case 8:
			r = 6;
			break;
		case 9:
			r = 6;
			break;
		}

		for(int x = 0; x<9; x++){
			if(x == r){
				x += 2;
				continue;
			}
			else if(x == r+1){
				x+=1;
				continue;
			}
			else if(x == r+2){
				continue;
			}
			able[x][c] = able[x][c].replaceAll(""+t,"");
		}
	}

	private String[][] log = new String[9][9];
	private int[] indecies = new int[9];

	public void log(int r, int c, int t, String indecies){
		int cube = 0;
		if(r<=2 && c<=2)cube = 0;
		else if(r<=2 && c>=3 && c<=5)cube = 1;
		else if(r<=2 && c>=6)cube = 2;
		else if(r>=3 && r<=5 && c<=2)cube = 3;
		else if(r>=3 && r<=5 && c>=3 && c<=5)cube = 4;
		else if(r>=3 && r<=5 && c>=6)cube = 5;
		else if(r>=6 && c<=2)cube = 6;
		else if(r>=6 && c>=3 && c<=5)cube = 7;
		else if(r>=6 && c>=6)cube = 8;

		//System.out.println("reached testing "+t+":"+cube+":"+indecies);
		log[cube][this.indecies[cube]] = t+indecies;
		this.indecies[cube]++;
	}

	//12345
	public void logCheck(){
		for(int cube = 0; cube<9; cube++){
			if(indecies[cube] == 0)continue;
			for(int i = 0; i<9; i++){
				if(log[cube][i]==null)break;
				for(int s = i+1; s<9; s++){
					if(log[cube][s]==null)break;
					if(log[cube][i].substring(1,3).equals(log[cube][s].substring(1,3)) && log[cube][i].substring(3).equals(log[cube][s].substring(3)) && isEligibleInference(log[cube][s]+log[cube][s],0)){
						int combination = Integer.parseInt(log[cube][i]);
						int r1 = (combination/1000)%10, c1 = (combination/100)%10;
						int r2 = (combination/10)%10, c2 = combination%10;

						addInference(log[cube][s]+log[cube][s],0);

						char char1 = log[cube][i].charAt(0), char2 = log[cube][s].charAt(0);
						for(int t = 0; t<able[r1][c1].length(); t++){
							char temp = able[r1][c1].charAt(t);
							if(temp != char1 && temp != char2)
								able[r1][c1] = able[r1][c1].replaceAll(""+temp,"");
						}
						for(int t = 0; t<able[r2][c2].length(); t++){
							char temp = able[r2][c2].charAt(t);
							if(temp != char1 && temp != char2)
								able[r2][c2] = able[r2][c2].replaceAll(""+temp,"");
						}
						gui.append("MADE A RESTRICTION INFERENCE WITH THE NUMBERS "+char1+","+char2+" AT ("+r1+","+c1+")("+r2+","+c2+")\n");
					}
				}
			}
			//System.out.println(able[2][1]);
		}

		indecies = new int[9];
		log = new String[9][9];
	}
	
	public String[] getRowAble(int r){
		return able[r];
	}
	
	public String[] getColAble(int c){
		String[] temp = new String[9];
		for(int r = 0; r<9; r++)
			temp[r] = able[r][c];
		return temp;
	}

	public void removeFromRowExcept(int r, int c1, int c2, String nums){
		for(int c= 0; c<9; c++)
			if(c!=c1 && c!=c2)
				for(int s = 0; s<nums.length(); s++)
					able[r][c] = able[r][c].replaceAll(""+nums.charAt(s),"");
	}
	
	public void removeFromRowExcept(int r, int c1, int c2, int c3, String nums){
		for(int c = 0; c<9; c++)
			if(c!=c1 && c!=c2 && c!=c3)
				for(int s = 0; s<nums.length(); s++)
					able[r][c] = able[r][c].replaceAll(""+nums.charAt(s),"");
	}

	public void removeFromColExcept(int c, int r1, int r2, String nums){
		for(int r = 0; r<9; r++)
			if(r!=r1 && r!=r2)
				for(int s = 0; s<nums.length(); s++)
					able[r][c] = able[r][c].replaceAll(""+nums.charAt(s),"");
	}
	
	public void removeFromColExcept(int c, int r1, int r2, int r3, String nums){
		for(int r = 0; r<9; r++)
			if(c!=r1 && r!=r2 && r!=r3)
				for(int s = 0; s<nums.length(); s++)
					able[r][c] = able[r][c].replaceAll(""+nums.charAt(s),"");
	}

	public boolean inTheSameCube(String rc1, String rc2){
		int rc = Integer.parseInt(rc1);
		int r1 = rc/10, c1 = rc%10;
		rc = Integer.parseInt(rc2);
		int r2 = rc/10, c2 = rc%10;

		int cube1 = 0;
		if(r1<=2 && c1<=2)cube1 = 0;
		else if(r1<=2 && c1>=3 && c1<=5)cube1 = 1;
		else if(r1<=2 && c1>=6)cube1 = 2;
		else if(r1>=3 && r1<=5 && c1<=2)cube1 = 3;
		else if(r1>=3 && r1<=5 && c1>=3 && c1<=5)cube1 = 4;
		else if(r1>=3 && r1<=5 && c1>=6)cube1 = 5;
		else if(r1>=6 && c1<=2)cube1 = 6;
		else if(r1>=6 && c1>=3 && c1<=5)cube1 = 7;
		else if(r1>=6 && c1>=6)cube1 = 8;
		int cube2 = 0;
		if(r2<=2 && c2<=2)cube2 = 0;
		else if(r2<=2 && c2>=3 && c2<=5)cube2 = 1;
		else if(r2<=2 && c2>=6)cube2 = 2;
		else if(r2>=3 && r2<=5 && c2<=2)cube2 = 3;
		else if(r2>=3 && r2<=5 && c2>=3 && c2<=5)cube2 = 4;
		else if(r2>=3 && r2<=5 && c2>=6)cube2 = 5;
		else if(r2>=6 && c2<=2)cube2 = 6;
		else if(r2>=6 && c2>=3 && c2<=5)cube2 = 7;
		else if(r2>=6 && c2>=6)cube2 = 8;

		return cube1 == cube2;
	}

	public boolean inTheSameCube(String rc1, String rc2, String rc3){
		int rc = Integer.parseInt(rc1);
		int r1 = rc/10, c1 = rc%10;
		rc = Integer.parseInt(rc2);
		int r2 = rc/10, c2 = rc%10;
		rc = Integer.parseInt(rc3);
		int r3 = rc/10, c3 = rc%10;

		int cube1 = 0;
		if(r1<=2 && c1<=2)cube1 = 0;
		else if(r1<=2 && c1>=3 && c1<=5)cube1 = 1;
		else if(r1<=2 && c1>=6)cube1 = 2;
		else if(r1>=3 && r1<=5 && c1<=2)cube1 = 3;
		else if(r1>=3 && r1<=5 && c1>=3 && c1<=5)cube1 = 4;
		else if(r1>=3 && r1<=5 && c1>=6)cube1 = 5;
		else if(r1>=6 && c1<=2)cube1 = 6;
		else if(r1>=6 && c1>=3 && c1<=5)cube1 = 7;
		else if(r1>=6 && c1>=6)cube1 = 8;
		int cube2 = 0;
		if(r2<=2 && c2<=2)cube2 = 0;
		else if(r2<=2 && c2>=3 && c2<=5)cube2 = 1;
		else if(r2<=2 && c2>=6)cube2 = 2;
		else if(r2>=3 && r2<=5 && c2<=2)cube2 = 3;
		else if(r2>=3 && r2<=5 && c2>=3 && c2<=5)cube2 = 4;
		else if(r2>=3 && r2<=5 && c2>=6)cube2 = 5;
		else if(r2>=6 && c2<=2)cube2 = 6;
		else if(r2>=6 && c2>=3 && c2<=5)cube2 = 7;
		else if(r2>=6 && c2>=6)cube2 = 8;
		int cube3 = 0;
		if(r3<=2 && c3<=2)cube3 = 0;
		else if(r3<=2 && c3>=3 && c3<=5)cube3 = 1;
		else if(r3<=2 && c3>=6)cube3 = 2;
		else if(r3>=3 && r3<=5 && c3<=2)cube3 = 3;
		else if(r3>=3 && r3<=5 && c3>=3 && c3<=5)cube3 = 4;
		else if(r3>=3 && r3<=5 && c3>=6)cube3 = 5;
		else if(r3>=6 && c3<=2)cube3 = 6;
		else if(r3>=6 && c3>=3 && c3<=5)cube3 = 7;
		else if(r3>=6 && c3>=6)cube3 = 8;

		return cube1 == cube2 && cube2 == cube3;
	}

	public void removeFromCubeExceptRow(String rc, int num){
		int i_rc = Integer.parseInt(rc);
		int r = i_rc/10, c = i_rc%10, targetRow = r;

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

		for(int r1 = r; r1<r+3; r1++){
			if(r1 == targetRow)continue;
			for(int c1 = c; c1<c+3; c1++)
				able[r1][c1] = able[r1][c1].replaceAll(""+num, "");
		}
		gui.append("MADE A CUBE INFERENCE OF A "+num+" AT ROW "+targetRow+" AND CUBE "+cube+"\n");
	}

	public void removeFromCubeExceptCol(String rc, int num){
		int i_rc = Integer.parseInt(rc);
		int r = i_rc/10, c = i_rc%10, targetCol = c;

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

		for(int c1 = c; c1<c+3; c1++){
			if(c1 == targetCol)continue;
			for(int r1 = r; r1<r+3; r1++)
				able[r1][c1] = able[r1][c1].replaceAll(""+num, "");
		}
		gui.append("MADE A CUBE INFERENCE OF A "+num+" AT COL "+targetCol+" AND CUBE "+cube+"\n");
	}

	public void addInference(int r, int c, int num){
		madeInferences[madeInferencesIndex] = ""+num+r+c;
		madeInferencesIndex++;
	}

	public void addInference(String indecies, int num){
		madeInferences[madeInferencesIndex] = ""+num+indecies;
		madeInferencesIndex++;
	}

	public boolean isEligibleInference(int r, int c, int num){
		String inference = ""+num+r+c;
		for(String x: madeInferences){
			if(x == null)break;
			if(x.equals(inference))return false;
		}
		return true;
	}

	public boolean isEligibleInference(String indecies, int num){
		String inference = ""+num+indecies;
		for(String x: madeInferences){
			if(x == null)break;
			if(x.equals(inference))return false;
		}
		return true;
	}
	
	public boolean notInSameCube(int c1, int c2){
		int cube1, cube2;
		if(c1>=6)cube1 = 3;
		else if(c1>=3)cube1 = 2;
		else cube1 = 1;
		
		if(c2>=6)cube2 = 3;
		else if(c2>=3)cube2 = 2;
		else cube2 = 1;
		
		return cube1!=cube2;
	}
	
	//TODO
	public String[][] getBoardWithoutZeros(){
		String[][] temp = new String[9][9];
		for(int )
	}
}
























