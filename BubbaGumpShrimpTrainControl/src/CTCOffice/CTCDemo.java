///Bubba Gump Shrimp Co.
///Schedule Class for CTC Office
///Jabari Dawkins
///April 11, 2013


//package CTCOffice;

import java.util.*;
import java.lang.*;
import java.io.*;

public class CTCDemo{
	
	public static void main(String[] args){
		CTCSystem sys = new CTCSystem(0);
		Scanner scan = new Scanner(System.in);
		String header = "--------CTC Office Demo: Scheduling Menu--------";
		System.out.println(header);
		sys.displaySchedule();
		sys.addToSchedule();
		sys.displaySchedule();
		sys.saveSchedule();
	}
}
