package Default;
import java.io.BufferedReader;
import Train.*;
import Date.*;
import TIER.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GetData extends Train{
	public String data[];
	public static GetData dt = new GetData();
	public void setData(String arr[])
	{
		data=new String[arr.length];
		for(int i=0;i<arr.length;i++)
			data[i]=arr[i];
		/*for(int i=0;i<data.length;i++)
		{
			System.out.println(data[i]);
		}*/
	}
	public void generateData()
	{
		
		BufferedReader br = null;
	    try
	    {
	    	File file = new File("/Users/manthansoriya/Desktop/Study/2 YEAR/InnovativeAssigment/OOP/src/trainDataBase.txt");
	    	br = new BufferedReader(new FileReader(file));
			boolean b=false,first=true;
			int n=-1,i=0;
			String arr[]=new String[1];
	 	   	String contentLine ="Abc";
	 	   	while (contentLine != null) {
	 	   		contentLine = br.readLine();
	 	   		
	 	   		if(b==true)
	 	   		{
	 	   		
	 	   			//System.out.println("New line"+contentLine);
	 	   			if(first)
	 	   			{
	 	   				n=Integer.parseInt(contentLine);
	 	   				//System.out.println("N:"+n);
	 	   				arr=new String[n];
	 	   				first=false;
	 	   			}
	 	   			else if(i<n)
	 	   			{
	 	   				arr[i++]=new String(contentLine);
	 	   			}
	 	   			else
	 	   			{
	 	   				b=false;
	 	   				dt.setData(arr);
	 	   			}
	 	   		}
	 	   		
	 	   		if(supobj.code.equals(contentLine))
	 	   		{
	 	   			//System.out.println("Here Code found.");
	 	   			b=true;
	 	   			first=true;
	 	   		}
	 	   }
	 	   	for(i=0;i<n;i++)
	 	   	{
	 	   		System.out.print(i+1+")");
	 	   		for(int j=2;j<=8;j++)
	 	   			System.out.print(arr[i].charAt(j));
	 	   		System.out.print("  Total Seats:");
	 	   		for(int j=9;j<arr[i].length()-2;j++)
	 	   			System.out.print(arr[i].charAt(j));
	 	   		System.out.println();	
	 	   	}
	    } 
	    catch(FileNotFoundException fnfe)
        {
            System.out.println("The specified file not found" + fnfe);
        }
	    catch (IOException ioe) 
	    {
	    	ioe.printStackTrace();
	    } 
	    finally 
	    {
	    	try 
	    	{
	    		if (br != null)
	   				br.close();
	   		} 
    		catch (IOException ioe) 
	    	{
    			System.out.println("Error in closing the BufferedReader");
	    	}
		}
	}
}
