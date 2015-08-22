import java.util.ArrayList;
import java.util.Collections;


public class AlphabeticSort {
	CircularShift circularShift;
	private static AlphabeticSort mAlphabeticSort = null;
	private ArrayList<String> sortedList = new ArrayList<String>();

	public AlphabeticSort(){
		this.circularShift = CircularShift.getInstance();
	}
	
	public void execute(){
		this.sortedList = circularShift.getShiftedList();
		sort();
	}

	public static AlphabeticSort getInstance(){ 
		if(mAlphabeticSort == null) {
			mAlphabeticSort = new AlphabeticSort();
		}
		return mAlphabeticSort;
	}

	public ArrayList<String> getSortedList(){
		return sortedList;
	}
	public void sort(){
		Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);;
	}

}
