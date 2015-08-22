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
	
	public int getLength(ArrayList<String> al){
		return al.size();
	}
	
	public void addLine(ArrayList<String> al,String inputLine){
		al.add(inputLine);
	}
	
	public String getLineAtPos(ArrayList<String> al, int posNo){
		return al.get(posNo);
	}
	
	public static Storage getInstance(){ 
		return mStorage;
	}
	
	public void loadInputFile(String inputFileLocation) throws FileNotFoundException, IOException{
		try (BufferedReader br = new BufferedReader(new FileReader(inputFileLocation))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	addLine(inputData, line);
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
