package io.github.vitalikulsha.telegrambot.util;

import java.util.ArrayList;
import java.util.List;

public class HolderTicket {
    public List<Ticket> holderTicket = new ArrayList<>() {
        {
            //this.add(new Ticket("Минск-Могилев", "10-03-2021", "18:20", 3.2));
          //  this.add(new Ticket("Могилев-Минск", "08-03-2021", "10:20", 3.2));
        }
    };

    public String print() {
        StringBuilder str = new StringBuilder();
        for (Ticket ticket : holderTicket) {
            str.append(ticket.toString() + ";\n");
        }
        return str.toString();
    }
}
