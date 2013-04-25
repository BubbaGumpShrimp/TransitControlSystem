package TrackControlModule;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import jxl.*;
import jxl.read.biff.BiffException;

public class TrackLine {
	private String name;
	private Hashtable<Integer,TrackController> trackControllers;
	private ArrayList<TrackController> trackControllerList;
	
	public TrackLine(String name, String fileName) {
		this.name = name;
		trackControllers = new Hashtable<Integer,TrackController>();
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(fileName));
		} catch (BiffException e) {
			System.out.println("BiffException");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		}
		System.out.println(name);
		System.out.println(workbook.getSheet(0).getName());
		System.out.println(workbook.getSheet(1).getName());
		Sheet sheet = workbook.getSheet(name);
		System.out.println(sheet.getRows());
		for (int i=1; i<sheet.getRows(); i++) {
			int currentController = Integer.parseInt(sheet.getCell(0,i).getContents());
			if (!trackControllers.containsKey(currentController)) {
				trackControllers.put(currentController, new TrackController(currentController));
			}
			trackControllers.get(currentController).addBlock(getCellInt(sheet,2,i), getCellInt(sheet,3,i), getCellInt(sheet,4,i), getCellInt(sheet,5,i), getCellInt(sheet,6,i), getCellInt(sheet,7,i));
		}
		fillList();
	}
	
	private int getCellInt(Sheet sheet, int column, int row) {
		return Integer.parseInt(sheet.getCell(column,row).getContents());
	}
	
	public String getName() {
		return name;
	}
	
	public TrackController getTrackController(int controllerID) {
		return trackControllers.get(controllerID);
	}
	
	public ArrayList<TrackController> getTrackControllerList() {
		return trackControllerList;
	}
	
	private void fillList() {
		trackControllerList = new ArrayList<TrackController>();
		ArrayList<Integer> keys = new ArrayList<Integer>();
		keys.addAll(trackControllers.keySet());
		Collections.sort(keys);
		for (int key: keys) {
			trackControllerList.add(trackControllers.get(key));
			System.out.println(trackControllers.get(key).getBlockList());
		}
	}
}
