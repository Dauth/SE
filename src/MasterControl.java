import java.io.FileNotFoundException;
import java.io.IOException;



public class MasterControl {
	static Input input;
	static CircularShift circularShift;
	static AlphabeticSort alphabeticSort;
	static Output output;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		input = Input.getInstance();
		String[] fileNameArr = Cli.start();
		input.setup(fileNameArr[0], fileNameArr[1]);
		circularShift = CircularShift.getInstance();
		circularShift.execute();
		alphabeticSort = AlphabeticSort.getInstance();
		alphabeticSort.execute();
		output = Output.getInstance();
		output.print();
	}
}