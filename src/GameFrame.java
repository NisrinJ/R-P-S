import javax.swing.*;

public class GameFrame extends JFrame {

    GameFrame(){
        this.add(new GamePane());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Rock Paper Scissors");
        this.setVisible(true);
    }
}
