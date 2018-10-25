import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The main window for dealing from a deck of cards.
 * @author lambertk
 *
 */
public class WarGUI extends JFrame{

    private Deck deck;

    public WarGUI(Deck deck){
        this.deck = deck;
        this.setTitle("The Game of War");
	    JPanel northPanel = new JPanel(new GridLayout(2, 1));
		
	    JPanel welcomePanel = new JPanel(new GridLayout(1,3));
	    welcomePanel.add(new JLabel("Player 1",SwingConstants.CENTER));
	    welcomePanel.add(new JLabel("Game Status",SwingConstants.CENTER));
	    welcomePanel.add(new JLabel("Player 2",SwingConstants.CENTER));
	    northPanel.add(welcomePanel);
	    
        CardPanel westPanel = new CardPanel();
        CardPanel eastPanel = new CardPanel();
        JButton button = new JButton("Deal");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (! deck.isEmpty()){
                    Card card = deck.deal();
                    card.turn();
                    westPanel.setCard(card);
                    eastPanel.setCard(card);
                }
            }});
        JTextField gameStatus = new JTextField(" ");
        westPanel.setPreferredSize(new Dimension(80, 80));
        westPanel.setMaximumSize(westPanel.getPreferredSize());
        eastPanel.setPreferredSize(new Dimension(80, 80));
        eastPanel.setMaximumSize(eastPanel.getPreferredSize()); 
        Container c = getContentPane();
        c.add(northPanel, BorderLayout.NORTH);
        c.add(westPanel, BorderLayout.WEST);
        c.add(button, BorderLayout.SOUTH);
        c.add(gameStatus, BorderLayout.CENTER);
        c.add(eastPanel, BorderLayout.EAST);
    }
}

/*public class WarGUI extends JFrame{
	
	private Deck deck;
	
	public WarGUI(Deck deck) { 
		this.deck = deck;
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
	    
	    CardPanel westPanel = new CardPanel();
	    
	    JPanel middlePanel = new JPanel(new GridLayout(1,1));
	    middlePanel.setBackground(Color.white);
	    middlePanel.add(new JLabel("some text"));
	
	    JPanel eastPanel = new JPanel();
	    eastPanel.add(new CardPanel());
	    
	        
	    JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	
	    JButton move = new JButton("Move");
	    southPanel.add(move);
	    move.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	            if (! deck.isEmpty()){
	                Card card = deck.deal();
	                card.turn();
	                westPanel.setCard(card);
	            }
	        }});
	    southPanel.add(new JButton("New Game"));
	
	    frame.add(northPanel, BorderLayout.NORTH);
	    frame.add(westPanel, BorderLayout.WEST);
	    frame.add(middlePanel, BorderLayout.CENTER);
	    frame.add(eastPanel, BorderLayout.EAST);
	    frame.add(southPanel, BorderLayout.SOUTH);
	
	    frame.pack();
	    frame.setVisible(true);
	  }
}*/