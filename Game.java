import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game {
    private JPanel move, countdown;
    private JButton button;
    private JLabel moveL, countdownL;
    private Timer timer;
    private int count;//To keep track of the time
    private Hand hand;

    public static void main (String args[]) {
        Game game = new Game();
        game.setUpGUI();
    }

    private void setUpGUI() {
        JFrame frame = new JFrame("Stone, Paper, Scissor Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 500);

        //Hand for the play
        hand = new Hand();

        //Panels
        move = new JPanel();
        countdown = new JPanel();

        //Temporary panel colors
        move.setBackground(new Color(255, 255, 255));
        countdown.setBackground(new Color(200, 200, 40));
        
        //Labels
        moveL = new JLabel();
        countdownL = new JLabel();

        //Button
        button = new JButton("Start");
        button.addActionListener(new ButtonListener());

        //Timer initialisation
        timer = new Timer(1000, new TimerListener());
        
        //Add
        move.add(moveL);
        countdown.add(countdownL);
        frame.getContentPane().add(BorderLayout.NORTH, countdown);
        frame.getContentPane().add(BorderLayout.CENTER, move);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
    }

    private void startPlaying() {
        //start time
        timer.start();
        
        button.setText("Stop");
    }

    private void stopPlaying() {
        //Stop time
        timer.stop();
        
        button.setText("Start");
        moveL.setText("");
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
                    countdownL.setText("3");
                break;

                case 2:
                    countdownL.setText("2");
                break;

                case 3: 
                    countdownL.setText("1");
                break;

                case 4:
                    countdownL.setText("GO!");
                    hand.shake();
                    moveL.setText(hand.show());
                    count = 0;
                break;
            }
        }
    }
}










