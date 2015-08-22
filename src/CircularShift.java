import java.util.ArrayList;
import java.util.Vector;


public class CircularShift {
	Storage storage;
	private static CircularShift mCircularShift = null;
	private ArrayList<String> shiftedLlineList;
	
	public CircularShift(){
		setup();
	}
	
	public void setup(){
		this.storage = Storage.getInstance();
		int inputListLength = storage.getLengthInputData();
		this.shiftedLlineList = new ArrayList<String>();
		for (int i = 0; i < inputListLength; i++) {
			String line = storage.getLineAtPos(i);
			shiftedLlineList.addAll(shiftLineInList(line));
		}
	}
	
	public static CircularShift getInstance(){ 
		if(mCircularShift == null){
			mCircularShift = new CircularShift();
		}
		return mCircularShift;
	}
	
	public ArrayList<String> getShiftedList(){
		return mCircularShift.shiftedLlineList;
	}
	
	private ArrayList<String> shiftLineInList(String extractedLine){
		String[] spaceDelimitedArray = tokenizeLine(extractedLine);
		ArrayList<String> completedList = new ArrayList<String>();
		for (int i = 0; i < spaceDelimitedArray.length; i++) {
			String firstWord = spaceDelimitedArray[i];
			if(storage.isIgnoredWordPresent(firstWord)){
				continue;
			}else{
				completedList.add(joinLine(i, spaceDelimitedArray));
			}
		}
		return completedList;
	}
	
	private String joinLine(int posNo, String[] arr){
		StringBuffer sb = null;
		for (int i = posNo; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		if(posNo != 0){
			for (int i = 0; i < posNo; i++) {
				sb.append(arr[i]);
			}
		}
		String outputString = sb.toString();
		outputString = capitalizeFirstWord(outputString);
		return outputString;
	}
	
	private String capitalizeFirstWord(String line){
		return line.substring(0, 1).toUpperCase() + line.substring(1);
	}
	private String[] tokenizeLine(String line){
		String[] delimitedArray = line.split("\\s+");
		return delimitedArray;
	}
}
