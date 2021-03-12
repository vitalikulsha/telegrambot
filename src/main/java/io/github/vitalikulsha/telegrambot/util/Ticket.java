package io.github.vitalikulsha.telegrambot.util;

import java.util.Objects;

public class Ticket {
    private String route;
    private String date;
    private String time;
    private double price;

    public Ticket() {
    }

    public Ticket(String route, String date, String time, double price) {
        this.route = route;
        this.date = date;
        this.time = time;
        this.price = price;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Double.compare(ticket.price, price) == 0 && route.equals(ticket.route) && date.equals(ticket.date) && time.equals(ticket.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(route, date, time, price);
    }

    @Override
    public String toString() {
        return "Билет: " +
                "маршрут = '" + route + '\'' +
                ", дата = '" + date + '\'' +
                ", время = '" + time + '\'' +
                ", цена =" + price + " BYN";
    }
}
