package sample.entity;

import java.util.Date;

public class Shuttle {


    //private String shuttleID;
    private String startTime;
    private Float ticketsPrices;
    private Integer ticketsNumber;



    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Float getTicketsPrices() {
        return ticketsPrices;
    }

    public void setTicketsPrices(Float ticketsPrices) {
        this.ticketsPrices = ticketsPrices;
    }

    public Integer getTicketsNumber() {
        return ticketsNumber;
    }

    public void setTicketsNumber(Integer ticketsNumber) {
        this.ticketsNumber = ticketsNumber;
    }



    public Shuttle() {
    }

    public Shuttle(String startTime, Float ticketsPrices, Integer ticketsNumber) {
        this.startTime = startTime;
        this.ticketsPrices = ticketsPrices;
        this.ticketsNumber = ticketsNumber;
    }
}
