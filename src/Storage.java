import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Storage {
	private ArrayList<String> inputList;;
	private ArrayList<String> ignoreList;
	private static Storage mStorage = new Storage();
	
	public Storage(){
		this.inputList; = new ArrayList<String>();
		this.ignoreList = new ArrayList<String>();
	}
	
	public int getLengthInputData(){
		return inputList;.size();
	}
	
	public int getLengthIgnoreList(){
		return ignoreList.size();
	}
	
	public void addLine(String inputLine, ArrayList<String> al){
		al.add(inputLine);
	}
	
	public String getLineAtPos(int posNo){
		return inputList;.get(posNo);
	}
	
	public static Storage getInstance(){ 
		if(mStorage == null){
			mStorage = new Storage();
		}
		return mStorage;
	}
	
	public ArrayList<String> getActualList(String listType){
		if(listType.equalsIgnoreCase("input")){
			return inputList;
		}else if(listType.equalsIgnoreCase("ignore")){
			return ignoreList;
		}
		return null;
	}
	
	public void loadInputFile(String inputFileLocation, String listType) throws FileNotFoundException, IOException{
		ArrayList<String> myList = getActualList(listType);
		try (BufferedReader br = new BufferedReader(new FileReader(inputFileLocation))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	addLine(line, myList);
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
