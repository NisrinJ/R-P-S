import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GamePane extends JLayeredPane implements ActionListener {

    static final int SCREEN_WIDTH = 1200;
    static final int SCREEN_HEIGHT = 1000;
    int playerScore = 0;
    int cpuScore= 0;
    int userChoice;
    int computerChoice;
    JLabel computerLabel = new JLabel();
    JLabel whoWon = new JLabel();
    JLabel score = new JLabel();
    Random random;

    //constructor: creates layerpane fit to the frame and calls startgame method
    GamePane(){
        random = new Random();
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.blue);
        this.setFocusable(true);
        whoWon.setVisible(false);
        startGame();
    }
    //method used to start game
    public void startGame(){
        computerLabel();
        whoWonPane();
        buttons();
        scoreBoard();
        resetButton();
    }
    public void resetButton(){
        JButton reset = new JButton("Reset");
        reset.setVisible(true);
        reset.setFocusable(true);
        reset.setBackground(Color.gray);
        reset.setOpaque(true);
        reset.setFont(new Font("Comic Sans", Font.BOLD, 20));
        reset.setBounds(1000, 100, 150, 100);
        reset.addActionListener(this);
        this.add(reset);
    }
    //resets game
    public void reset(ActionEvent e){
        if(e.getActionCommand().equals("Reset")){
            playerScore = 0;
            cpuScore = 0;
            whoWon.setVisible(false);
            score.setText("Score:" + playerScore + "-" + cpuScore);
        }
    }
    //creates user buttons and adds then to GamePane
    public void buttons(){
        JButton rock = new JButton("Rock");
        rock.setVisible(true);
        rock.setBackground(Color.red);
        rock.setBounds(250, 800, 100,50);
        rock.setOpaque(true);
        rock.setFocusable(true);
        rock.setText("Rock");
        rock.setFont(new Font("Comic Sans", Font.BOLD,15));
        rock.setBorder(BorderFactory.createEtchedBorder());
        rock.addActionListener(this);
        this.add(rock);

        JButton paper = new JButton("Paper");
        paper.setVisible(true);
        paper.setBackground(Color.MAGENTA);
        paper.setBounds(550, 800, 100,50);
        paper.setOpaque(true);
        paper.setFocusable(true);
        paper.setText("Paper");
        paper.setFont(new Font("Comic Sans", Font.BOLD,15));
        paper.setBorder(BorderFactory.createEtchedBorder());
        paper.addActionListener(this);
        this.add(paper);

        JButton scissors = new JButton("Scissors");
        scissors.setVisible(true);
        scissors.setBackground(Color.gray);
        scissors.setBounds(850, 800, 100,50);
        scissors.setOpaque(true);
        scissors.setFocusable(true);
        scissors.setText("Scissors");
        scissors.setBorder(BorderFactory.createEtchedBorder());
        scissors.setFont(new Font("Comic Sans", Font.BOLD,15));
        scissors.addActionListener(this);
        this.add(scissors);
    }
    //method used to record which button is pressed, calls method to generate random computer roll, and calls method for who won
    public void buttonSelected(ActionEvent e){
        if(e.getActionCommand().equals("Rock")){
            userChoice = 0;
            computerSelect();
            whoWon();
        }
        if(e.getActionCommand().equals("Paper")) {
            userChoice = 1;
            computerSelect();
            whoWon();
        }
        if(e.getActionCommand().equals(("Scissors"))){
            userChoice = 2;
            computerSelect();
            whoWon();
        }
    }
    //method for computer role label
    public void computerLabel(){
        computerLabel.setOpaque(true);
        computerLabel.setBackground(Color.BLACK);
        computerLabel.setBounds(500, 100, 200, 100);
        computerLabel.setFocusable(true);
        computerLabel.setVisible(true);
        computerLabel.setText("");
        computerLabel.setFont(new Font("Comic Sans", Font.BOLD,30));
        this.add(computerLabel);
    }
    //sets random computer roll
    public void computerSelect(){
        computerChoice = random.nextInt(3);
        if(computerChoice == 0){
            computerLabel.setBackground(Color.red);
            computerLabel.setHorizontalTextPosition(JLabel.RIGHT);
            computerLabel.setText("Rock");
        }
        if(computerChoice == 1){
            computerLabel.setBackground(Color.magenta);
            computerLabel.setHorizontalTextPosition(JLabel.RIGHT);
            computerLabel.setText("Paper");
        }
        if(computerChoice == 2){
            computerLabel.setBackground(Color.gray);
            computerLabel.setHorizontalTextPosition(JLabel.RIGHT);
            computerLabel.setText("Scissors");
        }
    }
    //sets center label displaying who won
    public void whoWonPane(){
        whoWon.setText("");
        whoWon.setBounds(450, 300, 500, 300);
        whoWon.setFocusable(true);
        whoWon.setOpaque(false);
        whoWon.setVisible(true);
        whoWon.setFont(new Font("Comic Sans", Font.BOLD, 50));
        this.add(whoWon);
    }
    //figures out who won and adjusts scoreboard
    public void whoWon(){
        if (computerChoice == userChoice){
            whoWon.setVisible(true);
            whoWon.setText("It's a tie!");
        }
        if (computerChoice == 0 & userChoice == 1){
            playerScore++;
            whoWon.setVisible(true);
            score.setText("Score:" + playerScore + "-" + cpuScore);
            whoWon.setText("Player won!");
        }
        if(computerChoice == 0 & userChoice == 2){
            cpuScore++;
            whoWon.setVisible(true);
            score.setText("Score:" + playerScore + "-" + cpuScore);
            whoWon.setText("Computer won!");
        }
        if(computerChoice == 1 & userChoice == 0){
            cpuScore++;
            whoWon.setVisible(true);
            score.setText("Score:" + playerScore + "-" + cpuScore);
            whoWon.setText("Computer won!");
        }
        if(computerChoice == 1 & userChoice == 2){
            playerScore++;
            whoWon.setVisible(true);
            score.setText("Score:" + playerScore + "-" + cpuScore);
            whoWon.setText("Player won!");
        }
        if(computerChoice == 2 & userChoice == 0){
            playerScore++;
            whoWon.setVisible(true);
            score.setText("Score:" + playerScore + "-" + cpuScore);
            whoWon.setText("Player won!");
        }
        if(computerChoice == 2 & userChoice == 1){
            cpuScore++;
            whoWon.setVisible(true);
            score.setText("Score:" + playerScore + "-" + cpuScore);
            whoWon.setText("Computer won!");
        }
    }
    //scoreboard display label
    public void scoreBoard(){
        score.setOpaque(false);
        score.setFocusable(true);
        score.setBounds(100, 0, 1000, 100);
        score.setFont(new Font("Comic Sans", Font.BOLD, 50));
        score.setVisible(true);
        score.setText("Score:" + playerScore + "-" + cpuScore);
        this.add(score);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        buttonSelected(e);
        reset(e);
    }
}
//city of stars.......are u shining just for me.....