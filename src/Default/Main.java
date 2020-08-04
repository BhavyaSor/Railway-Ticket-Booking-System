/*
Author : Bhavya Soriya
This is the main class File From where all the execution Starts.
I have included the comments wherever necessary
*/


package Default;
import java.util.*;

import Train.*;
import Default.*;
import Date.*;
import TIER.*;

import java.io.*;
public abstract class Main {
	//public static Train obj=Train.supobj;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		//getAllTrains(); This is a method that will search for all available trains for given input
		System.out.println("##########################################################################################");
		System.out.println("WELCOME TO OUR PLATFORM");
		System.out.println("We currently provide our services within four cities Ahmedabad Rajkot Surat Vadodara");
		System.out.println("##########################################################################################");
		//Greeting message
		try {
			//Here supobj is a static Instance of the Train Class and It will Contain all the User information 
			// For any queries refer Train class
			Train.supobj.setSrc();  //Setting our object source
			Train.supobj.setdest();	 //Setting our object Destination
			Train.supobj.generateDate();   //Setting our Object Date
			Train.supobj.setCode();	   //Setting our object User Code
			//System.out.println(obj.src);
			//System.out.println(obj.dest);
			//System.out.println(Train.supobj.code);
		}
		catch(InputMismatchException ioe)
		{
			System.out.println("Enter a valid input");
		}
		System.out.println("Searching for all trains from "+Train.supobj.src+" to "+Train.supobj.dest + "...");
		try {
			Thread.sleep(1000);
			// This is just to give a real world Kind of feel
		}
		catch(Exception e)
		{
			System.out.println("Exception in Waiting.");
		}
		
		//Input section
		// Now that Input is taken it is time to process the Data
		GetData.dt.generateData();
		Train.supobj.setUserCode();
		Train.supobj.setTier();
		Train.supobj.setSeat();
		Train.supobj.setCost();
		System.out.println("Cost is:"+Train.supobj.cost);
		System.out.println("Enter your name to be printed on ticket");
		
		Train.supobj.name=sc.nextLine();
		//String out=obj.usercode+"-"+obj.tier+"-"+obj.seat+"-"+(obj.seatBook+1)+"to"+(obj.seatBook+obj.seat);
		//System.out.println(out);
		Output obj3= new Output();
		obj3.add();
		obj3.genTicket();
        //Getting Train dataSet
		
		try{
			//Runtime objrun = Runtime.getRuntime();
			//String runstr="/System/Applications/TextEdit.app /Users/manthansoriya/Desktop/Study/2 YEAR/InnovativeAssigment/OOP/src/Output.txt";
			//Process objprc = objrun.exec(runstr);
			File f = new File("/Users/manthansoriya/Desktop/Study/2 YEAR/InnovativeAssigment/OOP/src/Final.txt");
			
			Runtime.getRuntime().exec(new String[] {"/usr/bin/open",f.getAbsolutePath()});
		}
		catch(FileNotFoundException fnfe)
        {
            System.out.println("The specified file not found" + fnfe);
        }
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}

}
