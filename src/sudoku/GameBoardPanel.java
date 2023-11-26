package sudoku;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameBoardPanel extends JPanel {
   private static final long serialVersionUID = 1L;  // to prevent serial warning

   // Define named constants for UI sizes
   public static final int CELL_SIZE = 50;   // Cell width/height in pixels
   public static final int BOARD_WIDTH  = CELL_SIZE * SudokuConstants.GRID_SIZE;
   public static final int BOARD_HEIGHT = CELL_SIZE * SudokuConstants.GRID_SIZE;
                                             // Board width/height in pixels

   // Define properties
   /** The game board composes of 9x9 Cells (customized JTextFields) */
   private Cell[][] cells = new Cell[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];
   /** It also contains a Puzzle with array numbers and isGiven */
   private Puzzle puzzle = new Puzzle();

   /** Constructor */
   public GameBoardPanel() {
      super.setLayout(new GridLayout(SudokuConstants.GRID_SIZE, SudokuConstants.GRID_SIZE));  // JPanel

      // Allocate the 2D array of Cell, and added into JPanel.
      for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
            cells[row][col] = new Cell(row, col);
            super.add(cells[row][col]);   // JPanel
         }
      }

      // [TODO 3] Allocate a common listener as the ActionEvent listener for all the
      //  Cells (JTextFields)
      // .........
      CellInputListener listener = new CellInputListener();

      // [TODO 4] Adds this common listener to all editable cells
      // .........
      for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
          for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
        	  if (cells[row][col].isEditable()) {
        	     cells[row][col].addActionListener(listener);   // For all editable rows and cols
        	  }  
          }
       }

      super.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
   }

   /**
    * Generate a new puzzle; and reset the gameboard of cells based on the puzzle.
    * You can call this method to start a new game.
    */
   public void newGame(Levels l) {
      // Generate a new puzzle
      puzzle.newPuzzle(l);

      // Initialize all the 9x9 cells, based on the puzzle.
      for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
            cells[row][col].newGame(puzzle.numbers[row][col], puzzle.isGiven[row][col]);
         }
      }
   }

   /**
    * Return true if the puzzle is solved
    * i.e., none of the cell have status of TO_GUESS or WRONG_GUESS
    */
   public boolean isSolved() {
      for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
            if (cells[row][col].status == CellStatus.TO_GUESS || cells[row][col].status == CellStatus.WRONG_GUESS) {
               return false;
            }
         }
      }
      return true;
   }
   public static void newGame() {
	   
   }
   // [TODO 2] Define a Listener Inner Class for all the editable Cells
   // .........
   private class CellInputListener implements ActionListener {
	   @Override
	   public void actionPerformed(ActionEvent e) {
	      // Get a reference of the JTextField that triggers this action event
		 Cell sourceCell = (Cell)e.getSource();
	 	 try {
		 	 
		 	 // Retrieve the int entered
		 	 int numberIn = Integer.parseInt(sourceCell.getText());
		 	 // For debugging
		 	 //System.out.println("You entered " + numberIn);
		 	
		 	 if (numberIn == sourceCell.number) {
		 	    sourceCell.status = CellStatus.CORRECT_GUESS;
		 	 } else {
		 		sourceCell.status = CellStatus.WRONG_GUESS;
		 	 }
		 	 sourceCell.paint();   
		 	 if(isSolved()) {
		 		Countdown.getInstance().stopTimer();		 		 
		 		Object[] options = {"Sair do Jogo",
				"Novo Jogo"};
		 		int reply = JOptionPane.showOptionDialog(null,
		 				"Tempo : "+Countdown.getTime()+"\nVocê venceu!", "Jogo Finalizado",JOptionPane.YES_NO_OPTION,
	                    JOptionPane.QUESTION_MESSAGE,
	                    null,     //do not use a custom Icon
	                    options,  //the titles of buttons
	                    options[0]);
				System.out.println(""+reply);
	            if (reply == JOptionPane.YES_OPTION)
	                System.exit(0);
	            //NO_OPTION
	            if (reply == JOptionPane.NO_OPTION) {
	            	SudokuMain.getInstance().initGame(false);
	            }
	            Cell.resetErros();
		 	 }
	 	 }catch (NumberFormatException nf) {
	 		 JOptionPane.showMessageDialog(null, "Digite Corretamente!");
	 	 }
	   }
	 }
}