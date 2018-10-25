import javax.swing.*;
import java.awt.*;

public class WarGUI {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setTitle("The Game of War");
    frame.setLayout(new BorderLayout());
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JPanel northPanel = new JPanel(new GridLayout(2, 1));

    JPanel welcomePanel = new JPanel(new GridLayout(1,3));
    welcomePanel.add(new JLabel("Player 1",SwingConstants.CENTER));
    welcomePanel.add(new JLabel("Game Status",SwingConstants.CENTER));
    welcomePanel.add(new JLabel("Player 2",SwingConstants.CENTER));
    
    northPanel.add(welcomePanel);
    
    JPanel westPanel = new JPanel();
    westPanel.add(new CardPanel());
    
    JPanel middlePanel = new JPanel(new GridLayout(1,1));;
    middlePanel.setBackground(Color.white);
    middlePanel.add(new JLabel("some text"));

    JPanel eastPanel = new JPanel();
    eastPanel.add(new CardPanel());
    
    
    JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

    southPanel.add(new JButton("Move"));
    southPanel.add(new JButton("New Game"));

    frame.add(northPanel, BorderLayout.NORTH);
    frame.add(westPanel, BorderLayout.WEST);
    frame.add(middlePanel, BorderLayout.CENTER);
    frame.add(eastPanel, BorderLayout.EAST);
    frame.add(southPanel, BorderLayout.SOUTH);

    frame.pack();
    frame.setVisible(true);
  }
}