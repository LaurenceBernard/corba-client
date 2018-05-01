package corbaclient;

import mainfiles.Hangman;
import mainfiles.HangmanHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import javax.swing.*;

public class HangmanClient extends JFrame {
    private static Hangman hangman;
    private MainPanel mainPanel;
    private Processor processor;
    private String playerName;

    public HangmanClient() {
        bootFrame();
    }

    public static void main(String[] args) {

        bootCorbaContext(args);

        //Boot The UI
        new HangmanClient();
    }


    private void bootFrame() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(580, 500);
                setLocationRelativeTo(null);
                setVisible(true);
                String name = JOptionPane.showInputDialog("Please enter your name!");

                if (name != null && !name.isEmpty()) {
                    playerName = name;
                    processor = new Processor();
                    short wordLength = processor.startAndGetLength();
                    mainPanel = new MainPanel(processor, wordLength);
                    add(mainPanel);
                    revalidate();
                    repaint();
                } else
                    System.exit(1);
            }
        });
    }

    public static void bootCorbaContext(String[] args) {
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

    private class Processor implements LetterReceiver {

        @Override
        public void getChar(char guess) {
            short result = hangman.play(HangmanClient.this.playerName, guess);
            Status status = Status.getByCode(result);

            switch (status){
                case GAME_OVER:
                    gameOverAction();
                    break;
                case WON_THE_GAME:
                    wonAction();
                    break;
                case NOT_REGISTERED:
                    notRegisteredAction();
                    break;
                case GUESSED_WRONGLY:
                    guessWronglyAction();
                    break;
                case GUESSED_CORRECTLY:
                    guessCorrectlyAction();
                    break;
            }

        }

        public void gameOverAction(){}
        public void wonAction(){}
        public void notRegisteredAction(){}
        public void guessWronglyAction(){}
        public void guessCorrectlyAction(){}

        public short startAndGetLength(){
            String name = HangmanClient.this.playerName;
            boolean isStarted = hangman.start(name);

            if(!isStarted){
                throw new IllegalArgumentException("This username is already present");
            }

            return hangman.length(name);

        }
    }
}
