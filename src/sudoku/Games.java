package sudoku;

public class Games {
	//Atualmente não está pegando um random, mas sim um especifico. Criam uns 8 possiveis jogos
	public static int[][] getRandomGame(){
		int[][] hardcodedNumbers =
	         {{5, 3, 4, 6, 7, 8, 9, 1, 2},
	          {6, 7, 2, 1, 9, 5, 3, 4, 8},
	          {1, 9, 8, 3, 4, 2, 5, 6, 7},
	          {8, 5, 9, 7, 6, 1, 4, 2, 3},
	          {4, 2, 6, 8, 5, 3, 7, 9, 1},
	          {7, 1, 3, 9, 2, 4, 8, 5, 6},
	          {9, 6, 1, 5, 3, 7, 2, 8, 4},
	          {2, 8, 7, 4, 1, 9, 6, 3, 5},
	          {3, 4, 5, 2, 8, 6, 1, 7, 9}};
		return hardcodedNumbers;
	}
	
	public static boolean[][] getRandomPuzzle(Levels level){
		boolean[][] hardcodedIsGiven = new boolean[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE]; 
		//Criar uma lógica random para cada if mudar sempre e de forma diferente a cada nivel. O nivel easy tem mais true's, enquanto o hard tem menos.
		if(level == Levels.EASY) {			
			boolean[][] values =
				{{true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, false},
				{true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, false},
				{true, true, false, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true}};
			hardcodedIsGiven = values;
		}
		if(level == Levels.MEDIUM) {
			boolean[][] values =
				{{true, false, true, true, true, true, true, true, true},
				{true, true, false, true, true, false, true, true, false},
				{true, true, true, true, false, true, true, true, true},
				{true, true, true, true, true, false, true, true, false},
				{true, true, false, true, true, true, true, true, false},
				{true, true, false, true, true, true, false, true, true},
				{true, true, true, true, true, true, true, true, true},
				{true, false, true, true, true, true, true, true, true},
				{true, true, false, true, true, false, true, true, true}};
			hardcodedIsGiven = values;
		}
		if(level == Levels.HARD) { 
			boolean[][] values =
				{{true, false, false, false, true, true, false, true, true},
				{true, true, false, true, true, false, true, true, false},
				{true, false, true, true, false, true, true, false, true},
				{false, true, false, true, true, false, true, true, false},
				{false, true, false, true, true, true, false, false, false},
				{true, false, false, true, true, true, false, false, true},
				{true, true, true, true, false, true, true, true, false},
				{true, false, true, true, true, true, false, true, false},
				{true, true, false, true, true, false, true, false, false}};
			hardcodedIsGiven = values;
		}
		return hardcodedIsGiven;
	}

}
