package corbaclient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel implements ActionListener {
    private LetterReceiver letterReceiver;
    private char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private JButton[] btns = new JButton[alphabet.length];
    private JButton currentPressedButton;

    public ButtonPanel() {
        setLayout(new GridLayout(0, 7));

        for (int i = 0; i < btns.length; i++) {
            if (i == 21) {
                add(new JLabel());
            }
            btns[i] = new JButton();
            JButton btn = btns[i];
            btn.addActionListener(this);
            btn.setText(String.valueOf(alphabet[i]));
            add(btn);
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton clickedBtn = (JButton) e.getSource();
        char btnChar = clickedBtn.getText().charAt(0);
        currentPressedButton = clickedBtn;
        clickedBtn.setEnabled(false);
        if(letterReceiver != null){
            letterReceiver.getChar(btnChar);
        }
    }

    public void setLetterReceiver(LetterReceiver letterReceiver){
        this.letterReceiver = letterReceiver;
    }

    public JButton getCurrentPressedButton() {
        return currentPressedButton;
    }

}
