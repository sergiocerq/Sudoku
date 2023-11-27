package sudoku;

import java.util.Random;

public class Games {
	private static Random random = new Random();
	private static int[][][] games = {
		{{5, 3, 4, 6, 7, 8, 9, 1, 2},
		{6, 7, 2, 1, 9, 5, 3, 4, 8},
		{1, 9, 8, 3, 4, 2, 5, 6, 7},
		{8, 5, 9, 7, 6, 1, 4, 2, 3},
		{4, 2, 6, 8, 5, 3, 7, 9, 1},
		{7, 1, 3, 9, 2, 4, 8, 5, 6},
		{9, 6, 1, 5, 3, 7, 2, 8, 4},
		{2, 8, 7, 4, 1, 9, 6, 3, 5},
		{3, 4, 5, 2, 8, 6, 1, 7, 9}},			
		
		{{4, 3, 5, 2, 6, 9, 7, 8, 1},
		{6, 8, 2, 5, 7, 1, 4, 9, 3},
		{1, 9, 7, 8, 3, 4, 5, 6, 2},
		{8, 2, 6, 1, 9, 5, 3, 4, 7},
		{3, 7, 4, 6, 8, 2, 9, 1, 5},
		{9, 5, 1, 7, 4, 3, 6, 2, 8},
		{5, 1, 9, 3, 2, 6, 8, 7, 4},
		{2, 4, 8, 9, 5, 7, 1, 3, 6},
		{7, 6, 3, 4, 1, 8, 2, 5, 9}},
		
		{{8, 5, 9, 6, 1, 2, 4, 3, 7},
	    	{6, 7, 4, 9, 8, 3, 1, 5, 2},
	   	{2, 3, 1, 7, 4, 5, 6, 9, 8},
	   	{1, 9, 5, 3, 6, 7, 8, 2, 4},
	    	{7, 6, 8, 4, 2, 9, 5, 1, 3},
	    	{3, 4, 2, 1, 5, 8, 7, 6, 9},
	    	{9, 2, 7, 5, 3, 4, 1, 8, 6},
	    	{4, 1, 6, 8, 7, 1, 9, 3, 5},
	    	{5, 8, 3, 2, 9, 6, 4, 7, 1}},
		
		{{2, 8, 9, 4, 3, 5, 7, 6, 1},
	    	{3, 1, 6, 9, 2, 7, 4, 8, 5},
	    	{7, 4, 5, 6, 1, 8, 9, 3, 2},
	    	{5, 2, 8, 3, 7, 6, 1, 4, 9},
	    	{1, 6, 7, 2, 4, 9, 3, 5, 8},
	    	{9, 3, 4, 8, 5, 1, 6, 2, 7},
	    	{4, 5, 3, 1, 9, 2, 8, 7, 6},
	    	{6, 7, 1, 5, 8, 3, 2, 9, 4},
	    	{8, 9, 2, 7, 6, 4, 5, 1, 3}},
		
	    	{{1, 4, 6, 5, 3, 8, 9, 2, 7},
	    	{5, 3, 2, 7, 9, 1, 6, 8, 4},
	    	{7, 9, 8, 2, 4, 6, 5, 1, 3},
	    	{3, 7, 5, 4, 6, 2, 8, 9, 1},
	    	{6, 8, 9, 1, 5, 3, 4, 7, 2},
	    	{4, 2, 1, 9, 8, 7, 3, 6, 5},
	    	{9, 6, 3, 8, 7, 4, 1, 5, 2},
	    	{8, 1, 4, 3, 2, 5, 7, 9, 6},
	    	{2, 5, 7, 6, 1, 9, 0, 0, 8}},
		
	    	{{5, 1, 7, 6, 4, 3, 8, 9, 2},
	    	{6, 4, 3, 1, 5, 2, 7, 8, 9},
	    	{9, 2, 8, 7, 1, 6, 4, 5, 3},
	    	{1, 3, 4, 9, 6, 7, 5, 2, 8},
	    	{7, 6, 9, 8, 2, 5, 3, 1, 4},
	    	{2, 8, 5, 3, 9, 4, 6, 7, 1},
	    	{3, 7, 1, 5, 8, 9, 2, 4, 6},
	    	{4, 9, 6, 2, 7, 1, 0, 3, 5},
	    	{8, 5, 2, 4, 3, 0, 1, 6, 7}},
		
		{{8, 6, 2, 3, 7, 1, 9, 4, 5},
	    	{3, 7, 5, 6, 9, 4, 2, 8, 1},
	    	{4, 1, 9, 2, 5, 8, 3, 7, 6},
	    	{9, 3, 7, 4, 6, 5, 1, 2, 8},
	    	{6, 8, 4, 9, 1, 2, 7, 5, 3},
	    	{2, 5, 1, 8, 3, 7, 6, 9, 4},
	   	{1, 9, 6, 7, 4, 3, 5, 0, 2},
	    	{7, 4, 8, 5, 2, 6, 0, 3, 9},
	    	{5, 2, 3, 1, 8, 9, 4, 6, 7}},
		
		{{9, 3, 1, 6, 7, 2, 5, 4, 8},
	   	{6, 7, 8, 3, 5, 4, 2, 9, 1},
	    	{4, 5, 2, 8, 1, 9, 7, 6, 3},
	    	{5, 1, 9, 4, 8, 7, 6, 3, 2},
	    	{8, 2, 3, 9, 6, 5, 4, 1, 7},
	    	{7, 4, 6, 2, 3, 1, 9, 8, 5},
	    	{1, 9, 4, 7, 2, 3, 8, 5, 6},
	    	{3, 8, 5, 1, 9, 6, 0, 7, 4},
	    	{2, 6, 7, 5, 4, 8, 3, 0, 9}},
		
		{{6, 9, 8, 1, 7, 5, 2, 3, 4},
	    	{4, 2, 1, 3, 9, 8, 5, 6, 7},
	    	{5, 3, 7, 6, 4, 2, 8, 1, 9},
	    	{9, 1, 5, 7, 6, 4, 3, 2, 8},
	    	{3, 7, 2, 8, 5, 1, 9, 4, 6},
	    	{8, 4, 6, 2, 3, 9, 7, 5, 1},
	    	{1, 6, 9, 4, 2, 7, 0, 8, 3},
	    	{7, 8, 4, 9, 1, 3, 6, 0, 2},
	    	{2, 5, 3, 0, 8, 6, 1, 7, 0}}
	};
	
	public static int[][] getRandomGame(){
		int[][] hardcodedNumbers = games[random.nextInt(10)];
		return hardcodedNumbers;
	}
	
	public static boolean[][] generateLevel(int qtdFalseCell, int limit) {
        boolean[][] values = new boolean[9][9];
        int qtdFalseCellInLine = 0;
        int qtdFalseCellInColumn[] = new int[9];
        for (int lines = 0; lines < values.length; lines++) {
        	qtdFalseCellInLine = 0;
            for (int columns = 0; columns < values[lines].length; columns++) {
                if (!random.nextBoolean() && qtdFalseCell > 0 && 
                	qtdFalseCellInLine < limit && qtdFalseCellInColumn[columns] < limit) {
                    values[lines][columns] = false;
                    qtdFalseCell--;
                    qtdFalseCellInLine++;
                    qtdFalseCellInColumn[columns]++;
                } else {
                    values[lines][columns] = true;
                }
            }
        }
        return values;
    }

	public static boolean[][] getRandomPuzzle(Levels level){
		boolean[][] hardcodedIsGiven = new boolean[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE]; 
		if(level == Levels.EASY) {			
			boolean[][] values = generateLevel(10, 2);
			hardcodedIsGiven = values;
		}
		if(level == Levels.MEDIUM) {
			boolean[][] values = generateLevel(30, 3);
			hardcodedIsGiven = values;
		}
		if(level == Levels.HARD) { 
			boolean[][] values = generateLevel(60, 5);
			hardcodedIsGiven = values;
		}
		return hardcodedIsGiven;
	}
}
