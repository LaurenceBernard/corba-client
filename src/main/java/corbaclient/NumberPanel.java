package corbaclient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberPanel extends JPanel implements ActionListener {
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private JButton[] btns = new JButton[alphabet.length];

    public NumberPanel() {
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
        clickedBtn.setEnabled(false);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();

        f.add(new NumberPanel());
        //f.setComponentOrientation(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 200);
        f.setVisible(true);
    }
}
