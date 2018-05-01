package corbaclient;

import javax.swing.*;
import java.awt.*;

public class GuessPanel extends JPanel {

    private JLabel[] guesses;


    public GuessPanel() {
        this(5);
    }

    public GuessPanel(int wordLength) {
        guesses = new JLabel[wordLength];
        setLayout(new GridLayout(0, wordLength));

        for (int i = 0; i < guesses.length; i++) {
            guesses[i] = new JLabel();
            JLabel lbl = guesses[i];
            lbl.setText("<HTML><U>?</U></HTML>");
            lbl.setFont(new Font("Serif", Font.PLAIN, 30));
            add(lbl);

        }
    }

    public void guessedWord(String guessedWord) {
        char[] guessedCharArray = guessedWord.toCharArray();
        for (int i = 0; i < guesses.length; i++) {

            if (guessedCharArray[i] == 0) {
                guesses[i].setText("<HTML><U>?</U></HTML>");
            } else {
                guesses[i].setText(String.format("<HTML><U>%c</U></HTML>", guessedCharArray[i]));
            }

            guesses[i].setFont(new Font("Serif", Font.PLAIN, 30));
        }
    }


}
