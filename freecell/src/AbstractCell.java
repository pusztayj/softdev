import java.util.Stack;

public class AbstractCell implements CellInterface {

	 public int size(){
	 	return this.size();
	 }

	 public Card remove() {
	    return stack.remove(stack.size() - 1)
	 }

}
