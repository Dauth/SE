import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class MasterControl {
	static Input input;
	public static void main(String[] args) throws FileNotFoundException, IOException {
		input = Input.getInstance();
		String[] fileNameArr = Cli.start();
		input.setup(fileNameArr[0], fileNameArr[1]);

	}
}



//private static MasterControl mMasterControl = null;
//
//public MasterControl(){
//	
//}
//
//public MasterControl getInstance(){
//	if(mMasterControl == null){
//		mMasterControl = new MasterControl();
//	}
//	return mMasterControl;
//}
//