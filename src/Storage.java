import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * 
 * 
 * 
 */
public class Storage {
	private ArrayList<String> inputData;
	private ArrayList<String> ignoreList;
	private static final Storage mStorage = new Storage();
	
	public Storage(){
		this.inputData = new ArrayList<String>();
		this.ignoreList = new ArrayList<String>();
	}
	
	public int getLengthInputData(){
		return inputData.size();
	}
	
	public int getLengthIgnoreList(){
		return ignoreList.size();
	}
	
	public void addLine(String inputLine){
		inputData.add(inputLine);
	}
	
	public String getLineAtPos(int posNo){
		return inputData.get(posNo);
	}
	
	public static Storage getInstance(){ 
		return mStorage;
	}
	
	public void loadInputFile(String inputFileLocation) throws FileNotFoundException, IOException{
		try (BufferedReader br = new BufferedReader(new FileReader(inputFileLocation))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	addLine(line);
		    }
		}
	}
	
	public boolean isIgnoredWordPresent(String word){
		for (int i = 0; i < ignoreList.size(); i++) {
			if(word.equalsIgnoreCase(ignoreList.get(i))){
				return true;
			}
		}
		return false;
	}
	
}
