package corbaclient;

import mainfiles.Hangman;
import mainfiles.HangmanHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import javax.swing.*;

public class HangmanClient {
    static Hangman hangman;

    public static void main(String[] args) {
        if (false) {
            try {
                // create and initialize the ORB
                ORB orb = ORB.init(args, null);

                // get the root naming context
                org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
                // Use NamingContextExt instead of NamingContext. This is
                // part of the Interoperable naming Service.
                NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

                // resolve the Object Reference in Naming
                String name = "HangmanGame";
                hangman = HangmanHelper.narrow(ncRef.resolve_str(name));

                System.out.println("Obtained a handle on server object: " + hangman);
            } catch (Exception e) {
                System.out.println("ERROR : " + e);
                e.printStackTrace(System.out);
            }
        }
        //Boot The UI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();

                frame.add(new MainPanel(new MyLetterReceiver()));
                //f.setComponentOrientation(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(580, 500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                String name = null;
                while (name == null)
                    name = JOptionPane.showInputDialog(frame, "Please enter your name!");

                frame.setTitle(String.format("Hi %s! Let's play Hangman", name));
            }
        });
    }

    public static class MyLetterReceiver implements LetterReceiver{

        @Override
        public void getChar(char userChoice) {
            System.out.println(userChoice);
        }
    }
}
