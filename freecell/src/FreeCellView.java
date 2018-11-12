import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * The main window for dealing from a deck of cards.
 * @author lambertk
 * @author pusztayj
 * @author dut
 * @author babikr
 * @author brandl
 * @version 1.0
 */

public class FreeCellView extends JFrame {
    private Game game;
    private ArrayList<CardPanel> freeCellList;

    /**
     * Sets up the display (panels, buttons, and labels) for the game of war
     * @param game - the WarGame object
     */
    public FreeCellView(Game game){
        this.game = game;
        this.setTitle("The Game of Free Cell");

        // Top panel with labels
        JPanel headerPanel = new JPanel(new GridLayout(1,2));
        headerPanel.add(new JLabel("Free Cells", 0));
        headerPanel.add(new JLabel("Home Cells", 0));

        // Top panel with Free Cell and Foundation Piles
        CardPanel FreeCell1 = new CardPanel();
        CardPanel FreeCell2 = new CardPanel();
        CardPanel FreeCell3 = new CardPanel();
        CardPanel FreeCell4 = new CardPanel();
        CardPanel Foundation1 = new CardPanel();
        CardPanel Foundation2 = new CardPanel();
        CardPanel Foundation3 = new CardPanel();
        CardPanel Foundation4 = new CardPanel();

        JPanel mainPanel1 = new JPanel(new GridLayout(1,8));
        mainPanel1.setBackground(new Color(0, 150, 0));
        mainPanel1.add(FreeCell1);
        mainPanel1.add(FreeCell2);
        mainPanel1.add(FreeCell3);
        mainPanel1.add(FreeCell4);
        mainPanel1.add(Foundation1);
        mainPanel1.add(Foundation2);
        mainPanel1.add(Foundation3);
        mainPanel1.add(Foundation4);

        // Main panel with tableau piles
        CardPanel Tableau1 = new CardPanel();
        CardPanel Tableau2 = new CardPanel();
        CardPanel Tableau3 = new CardPanel();
        CardPanel Tableau4 = new CardPanel();
        CardPanel Tableau5 = new CardPanel();
        CardPanel Tableau6 = new CardPanel();
        CardPanel Tableau7 = new CardPanel();
        CardPanel Tableau8 = new CardPanel();

        JPanel mainPanel2 = new JPanel(new GridLayout(1,8));
        mainPanel2.setBackground(new Color(0, 150, 0));
        mainPanel2.add(Tableau1);
        mainPanel2.add(Tableau2);
        mainPanel2.add(Tableau3);
        mainPanel2.add(Tableau4);
        mainPanel2.add(Tableau5);
        mainPanel2.add(Tableau6);
        mainPanel2.add(Tableau7);
        mainPanel2.add(Tableau8);


        //Bottom panel with button
        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
//        		game.reset();
//        		gameStatus.setText("New Game");
//        		leftCardPanel.setCard(null);
//        		rightCardPanel.setCard(null);
        	}
        });

        JPanel buttonPanel = new JPanel(new GridLayout(1,3));
        buttonPanel.add(newGameButton);

        //Container
        Container c = getContentPane();
        Container d = getContentPane();
        d.add(mainPanel1, BorderLayout.NORTH);
        d.add(mainPanel2,BorderLayout.SOUTH);
        c.add(headerPanel, BorderLayout.NORTH);
        c.add(d, BorderLayout.CENTER);
        c.add(buttonPanel, BorderLayout.SOUTH);

    }
}
