package io.github.vitalikulsha.telegrambot.service;

import com.google.common.base.Ticker;
import io.github.vitalikulsha.telegrambot.util.HolderTicket;
import io.github.vitalikulsha.telegrambot.util.Ticket;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

import static io.github.vitalikulsha.telegrambot.util.TextMessage.HELP;

@Service
public class KeyboardButtonMessage {
    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
    private String string = "Выберите из предложенного меню.\u2B07\u2B07\u2B07\u2B07\u2B07";
    List<Ticket> ticketList = new ArrayList<>();
    private String route;
    private String date;
    private String time;

    public String getMessage(String msg) {
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        KeyboardRow keyboardRequestRow = new KeyboardRow();

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        if (msg.equals("/start")) {
            keyboard.clear();
            //keyboardFirstRow.clear();
            keyboardFirstRow.add("Заказать билет");
            keyboardFirstRow.add("Мои билеты");
            keyboardSecondRow.add("Отменить бронь");
            keyboardSecondRow.add("Помощь");
            keyboardRequestRow.add(new KeyboardButton("Отправить контакт").setRequestContact(true));
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            keyboard.add(keyboardRequestRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return string;
        }

        if (msg.equalsIgnoreCase("Меню")) {
            keyboard.clear();
            //keyboardFirstRow.clear();
            keyboardFirstRow.add("Заказать билет");
            keyboardFirstRow.add("Мои билеты");
            keyboardSecondRow.add("Отменить бронь");
            keyboardSecondRow.add("Помощь");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return string;
        }

        if (msg.equals("Заказать билет")) {
            keyboard.clear();
            //keyboardFirstRow.clear();
            keyboardFirstRow.add("Выбор направления");
            keyboardFirstRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return string;
        }

        if (msg.equals("Выбор направления")) {
            keyboard.clear();
            //keyboardFirstRow.clear();
            keyboardFirstRow.add("Минск-Могилев");
            keyboardFirstRow.add("Могилев-Минск");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выбери направление";
        }

        if (msg.equals("Минск-Могилев")) {
            route = "Минск-Могилев";
            keyboard.clear();
            //keyboardFirstRow.clear();
            keyboardFirstRow.add("08-03-2021");
            keyboardFirstRow.add("09-03-2021");
            keyboardSecondRow.add("10-03-2021");
            keyboardSecondRow.add("11-03-2021");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выбери дату отправления";
        }

        if (msg.equals("Могилев-Минск")) {
            route = "Могилев-Минск";
            keyboard.clear();
            //keyboardFirstRow.clear();
            keyboardFirstRow.add("08-03-2021");
            keyboardFirstRow.add("09-03-2021");
            keyboardSecondRow.add("10-03-2021");
            keyboardSecondRow.add("11-03-2021");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выбери дату отправления";
        }

        if (msg.equals("08-03-2021")) {
            date = "08-03-2021";
            keyboard.clear();
            keyboardFirstRow.add("10:20");
            keyboardFirstRow.add("12:30");
            keyboardSecondRow.add("14:40");
            keyboardSecondRow.add("16:50");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выбери дату отправления";
        }

        if (msg.equals("09-03-2021")) {
            date = "09-03-2021";
            keyboard.clear();
            keyboardFirstRow.add("10:20");
            keyboardFirstRow.add("12:30");
            keyboardSecondRow.add("14:40");
            keyboardSecondRow.add("16:50");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выбери время отправления";
        }

        if (msg.equals("10-03-2021")) {
            date = "10-03-2021";
            keyboard.clear();
            keyboardFirstRow.add("10:20");
            keyboardFirstRow.add("12:30");
            keyboardSecondRow.add("14:40");
            keyboardSecondRow.add("16:50");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выбери время отправления";
        }
        if (msg.equals("11-03-2021")) {
            date = "11-03-2021";
            keyboard.clear();
            keyboardFirstRow.add("10:20");
            keyboardFirstRow.add("12:30");
            keyboardSecondRow.add("14:40");
            keyboardSecondRow.add("16:50");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выбери время отправления";
        }

        if (msg.equals("10:20")) {
            time = "10:20";
            Ticket ticket = new Ticket(route, date, time, 3.5);
            ticketList.add(ticket);
            keyboard.clear();
            keyboardFirstRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return ticket.toString() + " - забронирован";
        }

        if (msg.equals("12:30")) {
            time = "12:30";
            Ticket ticket = new Ticket(route, date, time, 3.5);
            ticketList.add(ticket);
            keyboard.clear();
            keyboardFirstRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return ticket.toString() + " - забронирован";
        }

        if (msg.equals("14:40")) {
            time = "14:40";
            Ticket ticket = new Ticket(route, date, time, 3.5);
            ticketList.add(ticket);
            keyboard.clear();
            keyboardFirstRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return ticket.toString() + " - забронирован";
        }

        if (msg.equals("16:50")) {
            time = "16:50";
            Ticket ticket = new Ticket(route, date, time, 3.5);
            ticketList.add(ticket);
            keyboard.clear();
            keyboardFirstRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return ticket.toString() + " - забронирован";
        }

        if (msg.equals("Мои билеты")) {
            if (ticketList.size() > 0) {
                StringBuilder str = new StringBuilder();
                for (Ticket ticket : ticketList) {
                    str.append(ticket.toString() + ";\n");
                }
                return str.toString();
            }
            return "Доступных билетов нет.";
        }

        if (msg.equals("Отменить бронь")) {
            if (ticketList.size() > 0) {
                StringBuilder str = new StringBuilder("Выберите номер брони для отмены:\n");
                for (int i = 0; i < ticketList.size(); i++) {
                    str.append("[ " + i + " ] " + ticketList.get(i).toString() + ";\n");
                }
                return str.toString();
            }
            return "Доступных билетов нет.";
        }

        if (msg.equals("0")) {
            ticketList.remove(0);
            return "Бронь снята";
        }
        if (msg.equals("1")) {
            ticketList.remove(0);
            return "Бронь снята";
        }
        if (msg.equals("2")) {
            ticketList.remove(0);
            return "Бронь снята";
        }

        if (msg.equals("Помощь")) {
            return HELP;
        }

        return "Я тебя не понял, попробуй еще раз!";
    }


    public synchronized void setButtons(SendMessage sendMessage) {
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardRequestRow = new KeyboardRow();
        keyboardRequestRow.add(new KeyboardButton("Отправить контакт").setRequestContact(true));
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("Заказать билет"));
        keyboardFirstRow.add(new KeyboardButton("Мои билеты"));
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(new KeyboardButton("Отменить бронь"));
        keyboardSecondRow.add(new KeyboardButton("Помощь"));
        keyboard.add(keyboardRequestRow);
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
    }
}
