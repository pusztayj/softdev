    /**
     * Executes the Controller and listens for mouse clicks. Updates the model
     * after user attempts to execute a move.
     * @author JPusztay
     * @author dut
     * @author babikr
     * @author brandl
     */
public interface ViewInformer {

	/**
	 * Passes a panel and then assigns clicks based on the user's clicks. Executes a game
	 * move while also checking for loser and winner.
	 */
	public void panelPressed(AbstractPanel panel);
}
