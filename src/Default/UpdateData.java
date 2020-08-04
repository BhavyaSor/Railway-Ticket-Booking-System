package Default;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import Default.*;

import TIER.*;
import Train.*;
public class UpdateData extends Train{ 
	public void setSeat()
	{
		String temp=GetData.dt.data[supobj.index-1];
		//System.out.println("Data received:"+temp);
		if(supobj.tier==1)
		{
			//System.out.println("Converting:"+temp.charAt(16)+""+temp.charAt(17));
			t1.seatAvail=t1.seatTotal=Integer.parseInt(temp.charAt(16)+""+temp.charAt(17));
			t1.seatBook=0;
			//System.out.println("Available seat:"+t1.seatAvail);
			//System.out.println("Available seat:"+t1.seatTotal);
		}
		else if(supobj.tier==2)
		{
			//System.out.println("Converting:"+temp.charAt(16)+""+temp.charAt(17));
			t2.seatAvail=t2.seatTotal=Integer.parseInt(temp.charAt(25)+""+temp.charAt(26));
			t2.seatBook=0;
		}
		else if(supobj.tier==3)
		{
			//System.out.println("Converting:"+temp.charAt(16)+""+temp.charAt(17));
			t3.seatAvail=t3.seatTotal=Integer.parseInt(temp.charAt(34)+""+temp.charAt(35));
			t3.seatBook=0;
		}
		else
		{
			System.out.println("Invalid Tier by default taking Tier 2");
			//System.out.println("Converting:"+temp.charAt(16)+""+temp.charAt(17));
			t2.seatAvail=t2.seatTotal=Integer.parseInt(temp.charAt(25)+""+temp.charAt(26));
			t2.seatBook=0;
		}
		
	}
	public void update()
	{
		 ArrayList<String> lines = new ArrayList<String>();
		 String line = null;
		 boolean contain=false,first=false,b=false;
		 int n=-1,k=0,x=0,y=0,z=0;
		 String temp="";
		 

		 try {
			 File file = new File("/Users/manthansoriya/Desktop/Study/2 YEAR/InnovativeAssigment/OOP/src/trainDataBase.txt");
			 File file1 = new File("/Users/manthansoriya/Desktop/Study/2 YEAR/InnovativeAssigment/OOP/src/Output1.txt");
			 File file2 = new File("/Users/manthansoriya/Desktop/Study/2 YEAR/InnovativeAssigment/OOP/src/Output2.txt");
			 File file3 = new File("/Users/manthansoriya/Desktop/Study/2 YEAR/InnovativeAssigment/OOP/src/Output3.txt");
			 File file4 = new File("/Users/manthansoriya/Desktop/Study/2 YEAR/InnovativeAssigment/OOP/src/Output4.txt");
			 File file5 = new File("/Users/manthansoriya/Desktop/Study/2 YEAR/InnovativeAssigment/OOP/src/Output5.txt");
			 File file6 = new File("/Users/manthansoriya/Desktop/Study/2 YEAR/InnovativeAssigment/OOP/src/Output6.txt");
			 File file7 = new File("/Users/manthansoriya/Desktop/Study/2 YEAR/InnovativeAssigment/OOP/src/Output7.txt");
			 
			 FileReader fr = null;
			 BufferedReader br = null;

			 switch(supobj.date)
			 {
			 case 1:{fr = new FileReader(file1);
			 		br = new BufferedReader(fr);
			 		break;}
			 case 2:{fr = new FileReader(file2);
		 			br = new BufferedReader(fr);
		 			break;}
			 case 3:{fr = new FileReader(file3);
		 			br = new BufferedReader(fr);
		 			break;}
			 case 4:{fr = new FileReader(file4);
		 			br = new BufferedReader(fr);
		 			break;}
			 case 5:{fr = new FileReader(file5);
		 			br = new BufferedReader(fr);
		 			break;}
			 case 6:{fr = new FileReader(file6);
		 			br = new BufferedReader(fr);
		 			break;}
			 case 7:{fr = new FileReader(file7);
		 			br = new BufferedReader(fr);
		 			break;}
			 }
			 
			 //FileReader fr = new FileReader(file);
			 //BufferedReader br = new BufferedReader(fr);
//			 FileReader fr2 = new FileReader(file2);
//			 BufferedReader br2 = new BufferedReader(fr2);
//			 //System.out.println("UserCode:"+Main.obj.usercode);
			 while ((line = br.readLine()) != null) {
				 if (line.contains(supobj.usercode))
				 {
					 temp=line;
					 contain=true;
					 if(line.charAt(10)=='1')//Tier 1
					 {
						 if(line.charAt(line.length()-2)=='-')					
							 x=x+Integer.parseInt(""+line.charAt(line.length()-1));
						 else
							 x=x+Integer.parseInt(""+line.charAt(line.length()-2)+""+line.charAt(line.length()-1)); 
					 }
					 if(line.charAt(10)=='2')
					 {
						 if(line.charAt(line.length()-2)=='-')					
							 y=y+Integer.parseInt(""+line.charAt(line.length()-1));
						 else
							 y=y+Integer.parseInt(""+line.charAt(line.length()-2)+""+line.charAt(line.length()-1));
					 }
					 if(line.charAt(10)=='3')
					 {
						 if(line.charAt(line.length()-2)=='-')					
							 z=z+Integer.parseInt(""+line.charAt(line.length()-1));
						 else
							 z=z+Integer.parseInt(""+line.charAt(line.length()-2)+""+line.charAt(line.length()-1));
					 }
					 
				 }
				 
			 }
			 //System.out.println("X:"+x+"Y:"+y+"Z:"+z);
			 if(supobj.tier==1)
			 {
				 t1.seatAvail=t1.seatTotal-x;
				 t1.seatBook=t1.seatTotal-t1.seatAvail;
				 //System.out.println("Final Seats available:"+t1.seatAvail);
			 }
			 if(supobj.tier==2)
			 {
				 t2.seatAvail=t2.seatTotal-y;
				 t2.seatBook=t2.seatTotal-t2.seatAvail;
				 //System.out.println("Final Seats available:"+t2.seatAvail);
			 }
			 if(supobj.tier==3)
			 {
				 t3.seatAvail=t3.seatTotal-z;
				 t3.seatBook=t3.seatTotal-t3.seatAvail;
				 //System.out.println("Final Seats available:"+t3.seatAvail);
			 }
			 br.close();
			 fr.close();
			 /*if(contain==true)
			 {
				 
				 FileReader fr2 = new FileReader(file);
				 BufferedReader br2 = new BufferedReader(fr2);
				 TierSeats ts = new TierSeats();
				 while ((line = br2.readLine()) != null) {		
		 	   		if(b==true)
		 	   		{
		 	   		//System.out.println("New line"+contentLine);
		 	   			
		 	   			if(first==true)
		 	   			{
		 	   				n=Integer.parseInt(line);
		 	   				//arr=new String[n];
		 	   				first=false;
		 	   				lines.add(line);
		 	   			}
		 	   			else if(k++<n)
		 	   			{
		 	   				//System.out.println("Extra->"+line.substring(0,8));
		 	   				if(line.contains(supobj.usercode))
		 	   				{
		 	   					//System.out.println("Line:"+line);
		 	   					String aux="";
		 	   					//System.out.println("Seattotal"+t1.seatTotal);
		 	   					//t1.seatAvail=Math.abs(t1.seatTotal-x);
		 	   					//t1.seatTotal=t1.seatTotal;
		 	   					//t2.seatAvail=Math.abs(t2.seatTotal-y);
		 	   					//t2.seatTotal=t2.seatTotal;
		 	   					//t3.seatAvail=Math.abs(t3.seatTotal-z);
		 	   					//t3.seatTotal=t3.seatTotal;
		 	   					if(supobj.tier==1)
		 	   					{
		 	   						for(int j=0;j<=15;j++)
		 	   							aux+=""+line.charAt(j);
			 	   					if(t1.seatAvail>=10)
		 	   						aux+=""+t1.seatAvail;//+" TIER2-"+t2.seatAvail+" TIER3-"+t3.seatAvail;
			 	   					else
			 	   						aux+="0"+t1.seatAvail;
			 	   					for(int j=18;j<=38;j++)
			 	   						aux+=""+line.charAt(j);
		 	   					}
		 	   					if(supobj.tier==2)
		 	   					{
		 	   						for(int j=0;j<=24;j++)
		 	   							aux+=""+line.charAt(j);
		 	   						if(t2.seatAvail>=10)
		 	   						aux+=""+t2.seatAvail;//+" TIER2-"+t2.seatAvail+" TIER3-"+t3.seatAvail;
		 	   						else
		 	   							aux+="0"+t2.seatAvail;
		 	   						for(int j=27;j<=38;j++)
		 	   							aux+=""+line.charAt(j);
		 	   					}
			 	   				if(supobj.tier==3)
		 	   					{
		 	   						for(int j=0;j<=33;j++)
		 	   							aux+=""+line.charAt(j);
		 	   						if(t3.seatAvail>=10)
		 	   						aux+=""+t3.seatAvail;//+" TIER2-"+t2.seatAvail+" TIER3-"+t3.seatAvail;
		 	   						else
		 	   							aux+=t3.seatAvail;
		 	   						for(int j=36;j<=38;j++)
		 	   							aux+=""+line.charAt(j);
		 	   					}
			 	   					//aux+=""+line.charAt(36)+""+line.charAt(37)+""+line.charAt(38);
		 	   					System.out.println("Aux:"+aux);
		 	   					lines.add(aux);
		 	   				}
		 	   				else
		 	   				{
		 	   					lines.add(line);
		 	   				}
		 	   			}
		 	   			
		 	   			else
		 	   			{
		 	   				b=false;
		 	   				lines.add(line);
		 	   			}
		 	   		}
		 	   		
		 	   		else if(supobj.code.equals(line))
		 	   		{
		 	   			b=true;
		 	   			first=true;
		 	   			lines.add(line);
		 	   		}
		 	   		else
		 	   		{
		 	   			lines.add(line);
		 	   		}
		 	   		
				 }
				 br2.close();
				 fr2.close();
				 
				 FileWriter fw = new FileWriter(file);
				 BufferedWriter out = new BufferedWriter(fw);
				 for(String s : lines)
				 {
					 out.write(s);
					 out.newLine();
				 }
				 out.flush();
				 out.close();
			 }*/
			 
					 /*switch(Main.obj.tier)
					 {
					 case 1:x=x-booking;
					 		break;
					 case 2:y=y-booking;
					 		break;
					 case 3:z=z-booking;
					 		break;
					 default:throw new InvalidEx("Invalid Tier");
					 }
					 String temp="";
					 for(int j=0;j<=9;j++)
						 temp+=line.charAt(j);
					 temp+="TIER1-"+x+" TIER2-"+y+" TIER3-"+z;
					 temp+=""+line.charAt(36)+""+line.charAt(37)+""+line.charAt(38);
					  lines.add(temp);
				 }
				 else
					 lines.add(line);*/
				 
			 
			 
			 
			
		 }
		 //catch(InvalidEx e)
			//{
				//setSeat();
		//	}
		 catch(InputMismatchException ioe)
		 {
				System.out.println("Enter valid Number");
				setSeat();
		 }
		 catch(FileNotFoundException fnfe)
		 {
	            System.out.println("The specified file not found" + fnfe);
	     }
		 catch (IOException ioe) 
		 {
		    	ioe.printStackTrace();
		 }
		 catch (Exception ex) {
			 System.out.println(ex);
			 //ex.printStackTrace();
		 }
	}

}
