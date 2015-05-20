package SudokuSolver;

//000007390200900001006010000900005010400000007030400002000020500600004009017500000

//not yet passed
//500000000000008207140000056800460000900020008000037005610000032208700000000000009
//1561998370
//070120600000006800900000000020050906310000078806090040000000001007400000001075020
//5192436215
//058600000900003000024000000703060050500010004010040906000000420000800009000009370

//hardest in the world gg 800000000003600000070090200050007000000045700000100030001000068008500010090000400

public class MainV3 {
	public static void main(String[] args){
		System.out.println("Running test2!");

		boolean print = true, goSlow = false;
		BoardV3 b = new BoardV3(print);
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
							if(print)System.out.println("ABLE ELIMINATION PLACED A "+temp+" AT PLACE ("+r+","+c+")");
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
							b.log(rowRotor*3,colRotor*3,test,eligibleIndecies);
							b.twoInLine(eligibleIndecies,test);
						}
						else if(numberIsGood && len == 6){
							b.threeInLine(eligibleIndecies,test);
						}
					}
			b.logCheck();
			
			//here
			for(int rc = 0; rc<9; rc++){
				String[] able = b.getRowAble(rc);
				for(int i = 0; i<9; i++)
					for(int s = i+1; s<9; s++)
						if(!able[i].equals("") && able[i].equals(able[s])){
							b.removeFromRowExcept(rc, i, s, able[i]);
							if(print)System.out.println("MADE AN EXTENDED ROW INFERENCE AT ROW "+rc+" WITH NUMBERS "+able[i]);
						}
				able = b.getColAble(rc);
				for(int i = 0; i<9; i++)
					for(int s = i+1; s<9; s++)
						if(!able[i].equals("") && able[i].equals(able[s])){
							b.removeFromColExcept(rc, i, s, able[i]);
							if(print)System.out.println("MADE AN EXTENDED COL INFERENCE AT COL "+rc+" WITH NUMBERS "+able[i]);
						}
			}

			
			
			
			if(!b.changed()){
				notComplete = true;
				break;
			}

			steps++;
			if(print)b.printBoard(steps);
		}//end while loop

		b.printBoard(steps);
		if(notComplete)System.out.println("WASNT ABLE TO COMPLETE SUDOKU");
		System.out.println("Total steps: "+steps+"\nTotal numbers added: "+numsAdded);
		b.verify();
	}
}
