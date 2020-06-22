package com.example.seriestest;
import java.util.*;

public class Theatre {
    private final String  theatreName;
    private List<Seat> seats = new ArrayList<>();
    private List<Shows> shows = new ArrayList<>();
    public boolean setShows(Shows show) {
        if(shows.contains(show))
        {
            System.out.println("This show is already in the list.");
            return false;
        }
            shows.add(show);
            return true;
    }


    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
       @Override
       public int compare(Seat seat1, Seat seat2) {
           return Double.compare(seat1.getPrice(), seat2.getPrice());
       }
   };

    public Theatre(String theatreName,int numRows,int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows-1);
        for (char row ='A';row<=lastRow;row++ )
        {
            for(int i = 1;i<=seatsPerRow;i++)
            {
                int price =10;
                if(row<='E')price+=2;
                if(i>=4 && i<=seatsPerRow-4)price+=2;
                Seat newSeat = new Seat(row + String.format("%02d", i), price);
                seats.add(newSeat);
            }
        }
    }
    public boolean reserveSeat(String seat)
    {
        int first = 0;
        int last = seats.size()-1;
        while (first <= last) {
            System.out.print(".");
            int mid = (first + last) / 2;
            Seat midVal = seats.get(mid);
            int cmp = midVal.getSeatNumber().compareTo(seat);
            if (cmp < 0) {
                first = mid + 1;
            } else if (cmp > 0) {
                last = mid - 1;
            } else {
                return seats.get(mid).reserve();
            }
        }
        System.out.println("There is no seat " + seat);
        return false;

    }
    public List<Seat> getSeats()
    {
        return seats;
    }
    public String getTheatreName() {
        return theatreName;
    }



    static class Seat implements Comparable<Seat>
    {
       private final String seatNumber;
       double price;
       private boolean reserved=false;

        private Seat(String seatNumber,double price) {
            this.seatNumber = seatNumber;
            this.price = price;

        }

        public double getPrice() {
            return price;
        }

        @Override
        public int compareTo(Seat otherSeat) {
            return  this.seatNumber.compareToIgnoreCase(otherSeat.getSeatNumber());
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public boolean isReserved() {
            return reserved;
        }
        public boolean reserve()
        {
           if(this.reserved)
           {
               System.out.println("It is already reserved!");
               return false;
           }
           else
           {
               reserved=true;
               System.out.println("Done!");
               return true;
           }
        }
        public boolean cancel()
        {
            if(!this.reserved)
            {
                System.out.println("It is not reserved!");
                return false;
            }
            else
            {
                reserved=false;
                System.out.println("Done!");
                return true;
            }

        }
    }
}
