package sudoku;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


/**
 * The main Sudoku program
 */
public class SudokuMain extends JFrame {
   private static final long serialVersionUID = 1L;  // to prevent serial warning
   private static SudokuMain instance;
   private int erros;
   
   public int getErros() {
		return erros;
   }

	public void updateErros() {
		this.erros++;
	}

	// private variables
   GameBoardPanel board = new GameBoardPanel();
   JButton btnIniciarJogo;
   JLabel lblEscolhaONvel;
   JButton btnSair;
   JComboBox comboBox;

   // Constructor
   private SudokuMain() {

      Container cp = getContentPane();
      setLocationRelativeTo(null);
      getContentPane().setLayout(null);

      btnIniciarJogo = new JButton("Iniciar Jogo");
      btnIniciarJogo.setBounds(158, 357, 117, 25);
      getContentPane().add(btnIniciarJogo);
      
      comboBox = new JComboBox();
      comboBox.setBounds(158, 302, 117, 24);
      getContentPane().add(comboBox);
      comboBox.addItem("Fácil");
      comboBox.addItem("Médio");
      comboBox.addItem("Difícil");
      
      lblEscolhaONvel = new JLabel("Escolha o nível:");
      lblEscolhaONvel.setBounds(158, 275, 117, 15);
      getContentPane().add(lblEscolhaONvel);
      
      btnSair = new JButton("Sair");
      btnSair.setBounds(185, 415, 62, 25);
      btnSair.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      		MusicPlayer.playSong(Song.BUTTONSOUND);
      		System.exit(0);
      	}
      });
      getContentPane().add(btnSair);
      board.setBounds(0, 39, 435, 462);

      cp.add(board);     
      board.setVisible(false);
      	
      Countdown.getInstance().setBounds(365, 12, 70, 15);
	  cp.add(Countdown.getInstance());
	
	  Error.getInstance().setBounds(188, 12, 87, 15);
	  getContentPane().add(Error.getInstance());
	  setBounds(100, 100, 435, 537);
	  Error.getInstance().setVisible(false);
	  Countdown.getInstance().setVisible(false);

      // Add a button to the south to re-start the game via board.newGame()
      // ......

      // Initialize the game board to start the game
      

      //pack();     // Pack the UI components, instead of using setSize()
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // to handle window-closing
      setTitle("Sudoku");
      setVisible(true);
      btnIniciarJogo.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent arg0) {
				MusicPlayer.playSong(Song.BUTTONSOUND);
        		Countdown.getInstance().startTimer();
        		if (comboBox.getSelectedItem().equals("Fácil")) 
        			board.newGame(Levels.EASY);
        		if (comboBox.getSelectedItem().equals("Médio")) 
        			board.newGame(Levels.MEDIUM);
        		if (comboBox.getSelectedItem().equals("Difícil")) 
        			board.newGame(Levels.HARD);
        		
        		initGame(true);
        	}		
        });
      
      JLabel lblNewLabel = new JLabel(new ImageIcon(getClass().getResource("/images/logo2.png")));
      lblNewLabel.setBounds(72, 12, 276, 251);
      getContentPane().add(lblNewLabel);
      //snakeFrame.add();
      //snakeFrame.pack();
		/*
		 * BufferedImage img; try { img = ImageIO.read(new File("logo2.png")); JLabel
		 * lblNewLabel_1 = new JLabel(new ImageIcon(img)); lblNewLabel_1.setBounds(170,
		 * 12, 70, 15); getContentPane().add(lblNewLabel_1); } catch (IOException e1) {
		 * // TODO Auto-generated catch block e1.printStackTrace(); }
		 */
      setLocationRelativeTo(null);
   }
   public static SudokuMain getInstance() {
	   if(instance == null)
		   instance = new SudokuMain();
	   return instance;
   }
   public void initGame(boolean b) {
		Countdown.getInstance().setVisible(b);
		board.setVisible(b);
		Error.getInstance().setVisible(b);
		btnIniciarJogo.setVisible(!b);
		lblEscolhaONvel.setVisible(!b);
		btnSair.setVisible(!b);
		comboBox.setVisible(!b);
	}
   

/** The entry main() entry method */
   public static void main(String[] args) {
      // [TODO 1] Check "Swing program template" on how to run
      //  the constructor of "SudokuMain" [ok]
      // .........
	   EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SudokuMain frame = getInstance();
					MusicPlayer.playSong(Song.SOUNDSTACK);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
   }
}
