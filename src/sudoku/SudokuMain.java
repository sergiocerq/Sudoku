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
      getContentPane().setLayout(null);
      setLocationRelativeTo(null);

      btnIniciarJogo = new JButton("Iniciar Jogo");
      
      btnIniciarJogo.setBounds(141, 357, 117, 25);
      getContentPane().add(btnIniciarJogo);
      
      comboBox = new JComboBox();
      comboBox.setBounds(141, 302, 117, 24);
      getContentPane().add(comboBox);
      comboBox.addItem("Fácil");
      comboBox.addItem("Médio");
      comboBox.addItem("Difícil");
      
      lblEscolhaONvel = new JLabel("Escolha o nível:");
      lblEscolhaONvel.setBounds(141, 275, 117, 15);
      getContentPane().add(lblEscolhaONvel);
      
      btnSair = new JButton("Sair");
      btnSair.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      		System.exit(0);
      	}
      });
      btnSair.setBounds(170, 413, 62, 25);
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
      btnIniciarJogo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		Countdown.getInstance().startTimer();
        		board.newGame(Levels.HARD);
        		initGame(true);
        	}		
        });
      	

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
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
   }
}