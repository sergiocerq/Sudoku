package sudoku;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Error extends JLabel {

	private static final long serialVersionUID = 1L;
	private static Error instance;

	private Error() {
		updateErros(0);
	}
	
	public static Error getInstance() {
		if(instance == null)
			instance = new Error();
		return instance;
	} 
	public void updateErros(int qtd_erros) {
		super.setText("Erros : "+qtd_erros+" / 3");
		if(qtd_erros > 2) {
	    	MusicPlayer.playSong(Song.FAILEDSOUND);
			Countdown.getInstance().stopTimer();
			Object[] options = {"Sair do Jogo",
					"Novo Jogo"};
			int reply = JOptionPane.showOptionDialog(null,
                    "Você errou 3 vezes e perdeu o jogo", "Fim de Jogo",JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,     //do not use a custom Icon
                    options,  //the titles of buttons
                    options[0]);
            if (reply == JOptionPane.YES_OPTION)
                System.exit(0);
            //NO_OPTION
            if (reply == JOptionPane.NO_OPTION) {
            	SudokuMain.getInstance().initGame(false);
            	Cell.resetErros();
            }
		}					
	}
	
	
}
