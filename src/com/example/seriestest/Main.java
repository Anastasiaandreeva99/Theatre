package com.example.seriestest;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
           Theatre theatre1 = new Theatre("Sisi",5,10);
           Theatre theatre2 = new Theatre("National",10,10);
           Theatres allTheatres = new Theatres();
           allTheatres.addTheatre(theatre1);
           allTheatres.addTheatre(theatre2);
           Scanner scan =new Scanner(System.in);
           System.out.println("Hello!In which theatre do you want to buy tickets? ");
           String theatreName=scan.next();
           Theatre theatre =allTheatres.getTheatre(theatreName);
           if(theatre==null)
           {
               System.out.println("Sorry,we don't work with this theatre");
           }
           else {
               System.out.println("Hello to theatre " + theatre.getTheatreName());
               System.out.println("Tickets by row or by price?");
               String answer = scan.next();
               if (answer.compareToIgnoreCase("price") == 0) {
                   theatre.getSeats().sort(Theatre.PRICE_ORDER);
               }
               printList(theatre.getSeats());
               System.out.println("Do you want to reserve? ");
               String bool = scan.next();
               if(bool.equals("yes"))
               {

                   System.out.println("How many tickets do you want to buy?");
                   int seatNumber=scan.nextInt();
                   int countTickets=1;
                   while(countTickets<=seatNumber)
                   {
                       System.out.println("Ticket number " + countTickets + "seat number :");
                       String seat = scan.next();
                       if(theatre.reserveSeat(seat)) countTickets++;
                   }
                   System.out.println("Thank you for reservation!");
               }
               else
               {
                   System.out.println("Thank you for visiting us!");
               }


           }

    }
    public static void printList(List<Theatre.Seat> list) {

        for(Theatre.Seat seat : list) {
            System.out.println(" " + seat.getSeatNumber() + "    The price is " + seat.getPrice() +  " - Is it reserved: " + seat.isReserved());
        }
        System.out.println();
        System.out.println("======================================================================");
    }
}
