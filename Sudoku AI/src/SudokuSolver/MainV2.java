package SudokuSolver;

public class MainV2 {
	public static void main(String[] args){
		System.out.println("Running MainV2!");
		
		boolean print = true, goSlow = false;
		BoardV2 b = new BoardV2(print);
		boolean notComplete = false;
		int steps = 0, numsAdded = 0;

		b.printBoard(0);

		while(!b.gameDone()){
			if(goSlow){
				try { Thread.sleep(1000); }
				catch(InterruptedException e){ Thread.currentThread().interrupt(); }
			}
			b.makeBackup();

			for(int r = 0; r<9; r++)
				for(int c = 0; c<9; c++)
					if(b.get(r,c)==0){
						String temp = b.getAble(r,c);
						if(temp.length()==1){
							int temp2 = Integer.parseInt(temp);
							b.set(r,c,temp2);
							if(print)System.out.println("ABLE ELIMINATION PLACE A "+temp+" AT PLACE ("+r+","+c+")");
							numsAdded++;
						}
					}

			for(int r = 0; r<9; r++)
				if(!b.rowFull(r)){
					int[] needed = b.getNeededRowNumbers(r);
					for(int c = 0; c<9; c++)
						if(b.get(r,c)==0){
							String good = "";
							for(int x: needed)
								if(b.isEligible(r,c,x))good+=x;
							if(good.length()==1){
								int temp = Integer.parseInt(good);
								b.set(r,c,temp);
								if(print)System.out.println("ROW ELIMINATION PLACED A "+temp+" AT PLACE ("+r+","+c+")");
								numsAdded++;
							}
						}
				}

			for(int c = 0; c<9; c++)
				if(!b.colFull(c)){
					int[] needed = b.getNeededColNumbers(c);
					for(int r = 0; r<9; r++)
						if(b.get(r,c)==0){
							String good = "";
							for(int x: needed)
								if(b.isEligible(r,c,x))good+=x;
							if(good.length()==1){
								int temp = Integer.parseInt(good);
								b.set(r,c,temp);
								if(print)System.out.println("COLUMN ELIMINATION PLACED A "+temp+" AT PLACE ("+r+","+c+")");
								numsAdded++;
							}
						}
				}

			for(int test = 1; test<=9; test++)
				for(int rowRotor = 0; rowRotor<3; rowRotor++)
					for(int colRotor = 0; colRotor<3; colRotor++){
						String eligibleIndecies = "";
						boolean numberIsGood = true;
						for(int r = rowRotor*3; numberIsGood && r<rowRotor*3+3; r++)
							for(int c = colRotor*3; numberIsGood && c<colRotor*3+3; c++)
								if(b.isEligible(r,c,test)){
									eligibleIndecies += "" + r + c;
									if(eligibleIndecies.length()>6)numberIsGood = false;
								}
						int len = eligibleIndecies.length();
						if(numberIsGood && len == 2){
							int indecies = Integer.parseInt(eligibleIndecies);
							b.set(indecies/10, indecies%10, test);
							if(print)System.out.println("POSITIONAL ELIMINATION PLACED A "+test+" AT PLACE ("+(indecies/10)+","+(indecies%10)+")");
							numsAdded++;
						}
						else if(numberIsGood && len == 4){
							b.twoInLine(eligibleIndecies,test);
						}
						else if(numberIsGood && len == 6){
							b.threeInLine(eligibleIndecies,test);
						}
					}
			
			if(!b.changed()){
				notComplete = true;
				break;
			}
			
			steps++;
			b.printBoard(steps);
		}//end while loop
		
		b.printBoard(steps);
		if(notComplete)System.out.println("WASNT ABLE TO COMPLETE SUDOKU");
		System.out.println("Total steps: "+steps+"\nTotal numbers added: "+numsAdded);
		b.verify();
	}
}
