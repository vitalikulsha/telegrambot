package io.github.vitalikulsha.telegrambot.service;

import io.github.vitalikulsha.telegrambot.util.Ticket;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.*;

import org.telegram.telegrambots.meta.api.objects.Message;

import static io.github.vitalikulsha.telegrambot.util.TextMessageUtil.*;

@Service
public class KeyboardButtonMessage {
    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
    private String string = "Выбери из предложенного меню.\u2B07";
    Map<Long, List<Ticket>> ticketsUser = new HashMap<>();
    List<Ticket> ticketList = new ArrayList<>();
    private String route;
    private String date;
    private String time;
    private String numberPhone;
    private long chatId;


    public String getMessage(Update update) {
        //List<Ticket> ticketList = new ArrayList<>();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        KeyboardRow keyboardRequestRow = new KeyboardRow();

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        String msg = update.getMessage().getText();
        //numberPhone = update.getMessage().getContact().getPhoneNumber();


        if (msg.equals("/start") || msg.equalsIgnoreCase("Меню")) {
            keyboard.clear();
            keyboardFirstRow.add("Заказать билет");
            keyboardFirstRow.add("Мои билеты");
            keyboardSecondRow.add("Отменить бронь");
            keyboardSecondRow.add("Помощь");
            keyboardRequestRow.add("Отправить контакт");
            //keyboardRequestRow.add(new KeyboardButton("Отправить контакт").setRequestContact(true));
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            keyboard.add(keyboardRequestRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return string;
        }

        if (msg.equals("Отправить контакт")) {
            chatId = update.getMessage().getChatId();
            ticketsUser.put(chatId, ticketList);
            //numberPhone = update.getMessage().getContact().getPhoneNumber();
            //System.out.println("chatId = " + chatId);
            return "ChatId отправлен";
        }

        if (msg.equals("Заказать билет")) {
            keyboard.clear();
            if (chatId != 0) {
                List<Ticket> myTickets = ticketsUser.get(chatId);
                if (myTickets.size() > 3) {
                    keyboard.clear();
                    keyboardFirstRow.add("Меню");
                    keyboard.add(keyboardFirstRow);
                    replyKeyboardMarkup.setKeyboard(keyboard);
                    return "Превышен лимит доступных билетов";
                } else {
                    keyboardFirstRow.add("Выбор направления");
                    keyboardFirstRow.add("Меню");
                    keyboard.add(keyboardFirstRow);
                    replyKeyboardMarkup.setKeyboard(keyboard);
                    return string;
                }
            } else {
                keyboardFirstRow.add("Меню");
                keyboard.add(keyboardFirstRow);
                replyKeyboardMarkup.setKeyboard(keyboard);
                return "Отправь сначала контакт для заказа билета";
            }
        }

        if (msg.equals("Выбор направления")) {
            keyboard.clear();
            keyboardFirstRow.add("Минск-Могилев");
            keyboardFirstRow.add("Могилев-Минск");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выбери направление из списка";
        }

        if (routeList.contains(msg)) {
            keyboard.clear();
            if (routeList.get(0).equals(msg)) {
                route = routeList.get(0);
            } else if (routeList.get(1).equals(msg)) {
                route = routeList.get(1);
            }
            keyboardFirstRow.add(dateList.get(0));
            keyboardFirstRow.add(dateList.get(1));
            keyboardSecondRow.add(dateList.get(2));
            keyboardSecondRow.add(dateList.get(3));
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выбери дату отправления из списка";
        }

        if (dateList.contains(msg)) {
            keyboard.clear();
            for (int i = 0; i < dateList.size(); i++) {
                if (dateList.get(i).equals(msg)) {
                    date = dateList.get(i);
                }
            }
            if (route.equals(routeList.get(0))) {
                keyboardFirstRow.add(timesMinsk.get(0));
                keyboardFirstRow.add(timesMinsk.get(1));
                keyboardSecondRow.add(timesMinsk.get(2));
                keyboardSecondRow.add(timesMinsk.get(3));
            } else if (route.equals(routeList.get(1))) {
                keyboardFirstRow.add(timesMogilev.get(0));
                keyboardFirstRow.add(timesMogilev.get(1));
                keyboardSecondRow.add(timesMogilev.get(2));
                keyboardSecondRow.add(timesMogilev.get(3));
            }
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выбери время отправления из списка";
        }

        if (timesMinsk.contains(msg) && route.equals(routeList.get(0))) {
            keyboard.clear();
            for (int i = 0; i < timesMinsk.size(); i++) {
                if (timesMinsk.get(i).equals(msg)) {
                    time = timesMinsk.get(i);
                }
            }
            Ticket ticket = new Ticket(route, date, time, 3.5);
            ticketList.add(ticket);
            ticketsUser.put(chatId, ticketList);
            keyboard.clear();
            keyboardFirstRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return ticket.toString() + " - забронирован";
        }

        if (timesMogilev.contains(msg) && route.equals(routeList.get(1))) {
            keyboard.clear();
            for (int i = 0; i < timesMogilev.size(); i++) {
                if (timesMogilev.get(i).equals(msg)) {
                    time = timesMogilev.get(i);
                }
            }
            Ticket ticket = new Ticket(route, date, time, 3.5);
            ticketList.add(ticket);
            ticketsUser.put(chatId, ticketList);
            keyboard.clear();
            keyboardFirstRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return ticket.toString() + " - забронирован";
        }

        if (msg.equals("Мои билеты")) {
            List<Ticket> myTickets = ticketsUser.get(chatId);
            if (myTickets.size() > 0) {
                StringBuilder str = new StringBuilder();
                for (Ticket ticket : myTickets) {
                    str.append(ticket.toString() + ";\n");
                }
                return str.toString();
            }
            return "Доступных билетов нет.";
        }

        if (msg.equals("Отменить бронь")) {
            List<Ticket> myTickets = ticketsUser.get(chatId);
            if (myTickets.size() > 0) {
                StringBuilder str = new StringBuilder("Введите номер брони для отмены:\n");
                for (int i = 0; i < myTickets.size(); i++) {
                    str.append("\'" + i + "\': " + myTickets.get(i).toString() + ";\n");
                }
                keyboard.clear();
                for (int i = 0; i < myTickets.size(); i++) {
                    keyboardFirstRow.add("Билет " + i);
                }
                keyboardSecondRow.add("Меню");
                keyboard.add(keyboardFirstRow);
                keyboard.add(keyboardSecondRow);
                replyKeyboardMarkup.setKeyboard(keyboard);
                return str.toString();
            }
            return "Доступных билетов нет.";
        }

        if (numberTickets.contains(msg)) {
            List<Ticket> myTickets = ticketsUser.get(chatId);
            for (int i = 0; i < numberTickets.size(); i++) {
                if (msg.equals(numberTickets.get(i))) {
                    myTickets.remove(i);
                }
            }
            ticketsUser.put(chatId, myTickets);
            keyboard.clear();
            keyboardFirstRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Бронь снята";
        }

        if (msg.equals("Помощь")) {
            keyboard.clear();
            keyboardFirstRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return HELP;
        }

        return "Я тебя не понял, попробуй еще раз!";
    }
}
