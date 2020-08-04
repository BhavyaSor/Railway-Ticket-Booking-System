package Default;
import TIER.*;

import Train.*;
import Default.*;
import Date.*;
public class TierSeats extends Train{
    public void bookSeat(String[] args) {
        //Cost tierS=new Cost();
        //tierS.generateCost();
        t3.setSeat();
        t2.setSeat();
        t1.setSeat();
        if(t1.tier==1)
        {
            t1.book_Seats();
        }
        else if(t2.tier==2)
        {
            t2.book_Seats();

        }
        else if(t3.tier==3)
        {
            t3.book_Seats();

        }


    }
}
