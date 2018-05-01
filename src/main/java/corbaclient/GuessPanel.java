package corbaclient;

import javax.swing.*;
import java.awt.*;

public class GuessPanel extends JPanel {

    JLabel[] guesses;


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

    public static void main(String[] args) {
        JFrame f = new JFrame();

        f.add(new GuessPanel());
        //f.setComponentOrientation(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(200, 100);
        f.setVisible(true);
    }
}
