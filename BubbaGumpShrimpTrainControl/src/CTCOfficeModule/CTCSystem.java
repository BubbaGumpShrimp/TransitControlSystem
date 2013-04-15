///Bubba Gump Shrimp Co.
///System Class for CTC Office
///Jabari Dawkins
///April 10, 2013

package CTCOfficeModule;

import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.awt.*;


public class CTCSystem{
	private CTC_Comm comm;
	private CTCFrame frame;
	private CTCSimUI simUI;
	private CTCEditUI editUI;
	private int authority;
	private ArrayList<Block> blockList;
	private ArrayList<Train> trainTable;
	private Schedule s;
	private boolean mode;	//Mode 
	private final int MODULE_ID = 1;
	
	public CTCSystem{
		comm = new CTC_Comm(MODULE_ID);
		ui = new CTCUI();
		s = new Schedule("schedule.txt");
		frame = new CTCFrame();
	}
	
	//Receives list of Trains to display to UI, as well as to 
	private void populateTrainTable(){
		
	}
	
	private void populateBlockList(){
		
	}
	
	private void loadMap(){
		
	}
	
	private void setSchedule(s){
		
	}
	
	private void closeBlock(Block b){
		
	}
	
	private void routeTrain(Train t){
		
	}
	
	private void addBlock(){
		
	}
	
	private void removeBlock(Block b){
		
	}
	
	private void setAuthority(int auth){
		
	}
	
	private void tick(){
		
	}
}
