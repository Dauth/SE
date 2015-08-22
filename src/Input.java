import java.io.FileNotFoundException;
import java.io.IOException;


public class Input {
	Storage storage;
	private static Input mInput = null;
	
	public Input(){
		storage = Storage.getInstance();
	}
	
	public Input getInstance(){
		if (mInput == null){
			mInput = new Input();
		}
		return mInput;
	}
	
	public void setup(String inputLoc, String ignoreLoc) throws FileNotFoundException, IOException{
		storage.loadInputFile(inputLoc, "input");
		storage.loadInputFile(ignoreLoc, "ignore");
	}
	
}
