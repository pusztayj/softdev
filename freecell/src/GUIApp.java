import javax.swing.JFrame;

/**
 * Generic main method template for any GUI-based application.
 * Instantiates a free cell model and passes it to a new view.
 * @author lambertk
 * @author pusztayj
 * @author dut
 * @author babikr
 * @author brandl
 */
public class GUIApp{

  /**
   * Sets the JFrame window and instantiates a war game object
   * @param args - optional string arguments
   */
    public static void main(String[] args){
        final Game game = new Game();
        final JFrame view = new FreeCellView(game);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(1050, 600);
        view.setVisible(true);
    }
}
