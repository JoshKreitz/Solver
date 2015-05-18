package SudokuSolver;

public class Main {
	public static void main(String[] args){
		Board b = new Board();
		boolean notComplete = false;
		int steps = 0;
		int numsAdded = 0;

		b.printBoard(steps);
		while(!b.gameDone()){
			/*try { Thread.sleep(1000); }
			catch(InterruptedException e){ Thread.currentThread().interrupt(); }*/
			b.printBoard(steps);

			b.makeBackup();

			//figure out all the possible numbers
			for(int r = 0; r<9; r++){
				for(int c = 0; c<9; c++){
					if(b.get(r,c) == 0){
						String good = "";
						for(int test = 1; test<=9; test++)
							if(b.isEligible(r,c,test)){
								good += ""+test;
							}
						if(good.length()==1){
							b.set(r,c,Integer.parseInt(good));
							numsAdded++;
							System.out.println("ELIMINATION 1 PLACED A "+good+" AT PLACE ("+r+","+c+")");
						}
					}
				}
			}

			for(int test = 1; test<=9; test++){
				for(int rowRotor = 0; rowRotor<3; rowRotor++){
					for(int colRotor = 0; colRotor<3; colRotor++){
						String eligibleIndecies = "";
						boolean numberIsGood = true;
						//System.out.println("NEW CUBE");
						for(int r = rowRotor*3; numberIsGood && r<rowRotor*3+3; r++){
							for(int c = colRotor*3; numberIsGood && c<colRotor*3+3; c++){
								//System.out.println("Testing "+test+" at ("+r+","+c+")");
								if(b.isEligible(r,c,test)){
									eligibleIndecies += "" + r + c;
									if(eligibleIndecies.length()>2 )numberIsGood = false;
								}
								else if((c == colRotor*3 && r == rowRotor*3) && b.cubeContains(r,c,test))numberIsGood = false;
							}
						}
						if(numberIsGood && eligibleIndecies.length()>1){
							int indecies = Integer.parseInt(eligibleIndecies);
							b.set(indecies/10, indecies%10, test);
							numsAdded++;
							System.out.println("ELIMINATION 2 PLACED A "+test+" AT PLACE ("+(indecies/10)+","+(indecies%10)+")");
						}
					}
				}
			}

			for(int r = 0; r<9; r++){
				int[] needed = b.getNeededRowNumbers(r);
				for(int c = 0; c<9; c++){
					if(b.get(r,c)==0){
						String good = "";
						for(int x: needed)
							if(!b.colContains(c,x) && !b.cubeContains(r,c,x))
								good+=x;
						if(good.length()==1){
							b.set(r,c,Integer.parseInt(good));
							numsAdded++;
							System.out.println("ELIMINATION 3 PLACED A "+good+" AT PLACE ("+r+","+c+")");
						}
					}
				}
			}

			for(int c = 0; c<9; c++){
				int[] needed = b.getNeededColNumbers(c);
				for(int r = 0; r<9; r++){
					if(b.get(r,c)==0){
						String good = "";
						for(int x: needed)
							if(!b.rowContains(r,x) && !b.cubeContains(r,c,x))
								good+=x;
						if(good.length()==1){
							b.set(r,c,Integer.parseInt(good));
							numsAdded++;
							System.out.println("ELIMINATION 4 PLACED A "+good+" AT PLACE ("+r+","+c+")");
						}
					}
				}
			}

			if(!b.changed()){
				notComplete = true;
				break;
			}
			steps++;
		}//end while loop

		b.printBoard(steps);
		if(notComplete)System.out.println("WASNT ABLE TO COMPLETE SUDOKU");
		System.out.println("Total steps: "+steps+"\nTotal numbers added: "+numsAdded);
		b.verify();
	}
}

//050040000000700008030609107500000320001000700043000009208904060600008000000050070
//000800000000000710068507000480050600009000200005030079000109540012000000000005000

//000007390200900001006010000900005010400000007030400002000020500600004009017500000
//num 10160354584
