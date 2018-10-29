import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The main window for dealing from a deck of cards.
 * @author lambertk
 * @author pusztayj
 * @author dot
 * @author babikr
 * @author brandl
 * @version 1.0
 */
public class WarView extends JFrame{

    private WarGame game;

    /**
     * Sets up the display (panels, buttons, and labels) for the game of war
     * @param game - the WarGame object
     */
    public WarView(WarGame game){
        this.game = game;
        this.setTitle("The Game of War");

        // Top panel with labels
        JPanel headerPanel = new JPanel(new GridLayout(1,3));
        headerPanel.add(new JLabel("Player 1", 0));
        headerPanel.add(new JLabel("Game Status", 0));
        headerPanel.add(new JLabel("Player 2", 0));

        // Main panel with cards and game status
        CardPanel leftCardPanel = new CardPanel();
        CardPanel rightCardPanel = new CardPanel();
        JTextArea gameStatus = new JTextArea("Welcome to the game of War!");
        gameStatus.setEditable(false);


        JPanel mainPanel = new JPanel(new GridLayout(1,3));
        mainPanel.add(leftCardPanel);
        mainPanel.add(gameStatus);
        mainPanel.add(rightCardPanel);


        //Bottom panel with buttons
        JButton moveButton = new JButton("Move");
        moveButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		if (!game.isDone()) {
        			game.step();
        			gameStatus.setText(game.toString());
        			Card card1 = game.getCard1();
        			Card card2 = game.getCard2();
        			card1.turn();
        			card2.turn();
        			leftCardPanel.setCard(card1);
        			rightCardPanel.setCard(card2);
        		}
        		else {
        			JOptionPane.showMessageDialog(WarView.this, game.winner());
        		}
        	}
        });
        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		game.reset();
        		gameStatus.setText("New Game");
        		leftCardPanel.setCard(null);
        		rightCardPanel.setCard(null);
        	}
        });

        JPanel buttonPanel = new JPanel(new GridLayout(1,3));
        buttonPanel.add(moveButton);
        buttonPanel.add(newGameButton);

        //Container
        Container c = getContentPane();
        c.add(headerPanel, BorderLayout.NORTH);
        c.add(mainPanel, BorderLayout.CENTER);
        c.add(buttonPanel, BorderLayout.SOUTH);

    }
}
