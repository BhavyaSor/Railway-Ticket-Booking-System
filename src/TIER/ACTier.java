package TIER;

import  java.util.*;
import Train.*;
import Default.*;
import Date.*;
public class ACTier extends Train {
    public void book_Seats()
    {
        boolean b=true;
        do {
            b=false;
            try {
                int x=seat;//Unknow Seats
                //Scanner sc = new Scanner(System.in);
                //System.out.println("ENTER SEATS YOU WATN TO BOOK");
                //x = sc.nextInt();
                if (x > seatAvail) {
                    System.out.println(x+"SEATS ARE NOT AVAILABLE");
                    b=true;
                }
                else if(x<=0)
                {
                    System.out.println("INVALID SEAT NUMBER TRY AGAIN");
                    b=true;
                }
                else
                {
                    System.out.println(x+" SEATS ARE BOOKED");
                    seatAvail=seatAvail-x;
                    seatBook=seatBook+x;
                }

            } catch (InputMismatchException e) {
                System.out.println("INVALID INPUT TRY AGAIN");
                b=true;
            }
        }while (b==true);
    }
}
