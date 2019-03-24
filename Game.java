import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game {
    private JPanel countdown, background;
    private MyPanel move;
    private JButton button;
    private JLabel countdownL;
    private Timer timer;
    private int count;//To keep track of the time
    private Hand hand;
    private boolean isPlaying = false;//Is the game playing?

    public static void main (String args[]) {
        Game game = new Game();
        game.setUpGUI();
    }

    private void setUpGUI() {
        JFrame frame = new JFrame("Stone, Paper, Scissor Game");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);//Centers the app on the screen

        //Hand for the play
        hand = new Hand();

        //Panels
        move = new MyPanel();
        countdown = new JPanel();
        countdown.setBounds( 0, 0, 500, 50);
        move.setBounds( 0, 51, 500, 300);

        //Labels
        countdownL = new JLabel();

        //Button
        button = new JButton("Start");
        button.addActionListener(new ButtonListener());
        button.setBounds( 200, 360, 100, 50);

        //Timer initialisation
        timer = new Timer(1000, new TimerListener());

        //Add
        countdown.add(countdownL);
        frame.getContentPane().add(countdown);
        frame.getContentPane().add(move);
        frame.getContentPane().add(button);
    }

    private void startPlaying() {
        //start time
        timer.start();

        isPlaying = true;

        button.setText("Stop");
    }

    private void stopPlaying() {
        //Stop time
        timer.stop();

        isPlaying = false;

        button.setText("Start");
        countdownL.setText("");
    }

    //Inner Classes
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (button.getText().equals("Start"))
                startPlaying();
            else
                stopPlaying();
        }
    }

    private class TimerListener implements ActionListener{
        public void actionPerformed (ActionEvent e) {
            count++;

            switch (count) {
                case 1:
                move.repaint();
                countdownL.setText("3");
                break;

                case 2:
                countdownL.setText("2");
                break;

                case 3: 
                countdownL.setText("1");
                break;

                case 4:
                hand.shake();
                move.repaint();
                countdownL.setText("GO!");
                count = 0;
                break;
            }
        }
    }

    //Customized panel
    private class MyPanel extends JPanel {
        public void paintComponent( Graphics g) {
            //Paint the background of the panel
            g.setColor(Color.white);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            
            //If it's the right time then show the computer's move
            if (count == 0 && isPlaying) {
                Image image = new ImageIcon ("images/"+hand.show()+".jpg").getImage();
                g.drawImage(image, 110, 75, this);
            }
        }
    }
}





