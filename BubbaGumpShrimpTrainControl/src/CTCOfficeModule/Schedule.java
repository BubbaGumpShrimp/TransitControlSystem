///Bubba Gump Shrimp Co.
///Schedule Class for CTC Office
///Jabari Dawkins
///April 11, 2013

package CTCOfficeModule;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Schedule{
	private File infile;
	private File outfile;
	private ArrayList<String> schedule;
	private String scheduleAddr;
	
	public Schedule(String addr){
		scheduleAddr = addr;
		infile = new File(addr);
		schedule = new ArrayList<String>();
		try{
				Scanner scan = new Scanner(infile);
				while(scan.hasNextLine()){
					schedule.add(scan.nextLine());
				}
		}
		catch(FileNotFoundException fnfe){
			fnfe = new FileNotFoundException();
			System.out.println("Error fetching scheudle");
		}
	}
	
	public void display(){
		for(String s: schedule){
			System.out.println(s);
		}
	}
	
	public void edit(String train, ArrayList<String> stations){
		String newStringLine = train+" | ";
		for(int i = 0; i < stations.size()-1; i++){
			newStringLine += stations.get(i)+" -> ";
		}
		newStringLine += stations.get(stations.size()-1);
		schedule.add(newStringLine);
	}
	
	public void writeToFile(){
		try{
			File outfile = new File(scheduleAddr);
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outfile)));
			for(String s: schedule){
				pw.println(s);
			}
			pw.close();
		}
		catch(IOException e){
			e = new IOException();
			System.out.println("Error fetching scheudle");
		}
	}
}
