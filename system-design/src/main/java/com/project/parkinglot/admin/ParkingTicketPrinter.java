package com.project.parkinglot.admin;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import com.project.parkinglot.ticket.Ticket;

public class ParkingTicketPrinter {
    private PrintWriter printWriter ;

    public ParkingTicketPrinter() {
        try {
            this.printWriter = new PrintWriter("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printTicket(Ticket ticket) {
        printWriter.write(ticket.getPrintableString());
    }
}