package io.github.vitalikulsha.telegrambot.util;

import java.util.*;
import java.util.regex.Pattern;

public class DatabaseAdmin {
    public static final String PASSWORD = "adminpassword";
    public static final String REFERENCE = "Возможности меню администратора:\n" +
            "Добавление рейса - добавить новый рейс с количеством билетов\n" +
            "Просмотр рейсов - просмотр рейсов на заданную дату и направление, выводит информацию о времени отправления и количестве свободных мест\n" +
            "Просмотр броней - просмотр данных клиентов (номер телефона и имя), забронировавших билеты на заданный рейс.\n";


    public static Map<String, List<String>> reserveTripClientMap = new HashMap<>() {
        {
            this.put("МнМг0803211020", new ArrayList<>() {
                {
                    this.add("+375291234567 Светлана");
                    this.add("+375331111111 Пётр");
                }
            });
            this.put("МгМн0803210810", new ArrayList<>() {
                {
                    this.add("+375290000000 Сергей");
                    this.add("+375332222222 Антон");
                    this.add("+375333333333 Иван");
                }
            });
        }
    };

    public static List<String> tripDataList = new ArrayList<>(){
        {
            this.add("08-03-21");
            this.add("09-03-21");
            this.add("10-03-21");
            this.add("11-03-21");
        }
    };

    public static Map<String, List<String>> tripClientMap = new HashMap<>() {
        {
            this.put("08-03-21", new ArrayList<>() {
                {
                    this.add("Мн-Мг 10:20 свободно 15");
                    this.add("Мн-Мг 12:30 свободно 12");
                    this.add("Мн-Мг 14:40 свободно 11");
                    this.add("Мн-Мг 16:50 свободно 14");
                    this.add("Мг-Мн 08:10 свободно 8");
                    this.add("Мг-Мн 11:15 свободно 10");
                    this.add("Мг-Мн 13:10 свободно 12");
                    this.add("Мг-Мн 18:40 свободно 9");
                }
            });
            this.put("09-03-21", new ArrayList<>() {
                {
                    this.add("Мн-Мг 10:20 свободно 5");
                    this.add("Мн-Мг 12:30 свободно 5");
                    this.add("Мн-Мг 14:40 свободно 4");
                    this.add("Мн-Мг 16:50 свободно 3");
                    this.add("Мг-Мн 08:10 свободно 2");
                    this.add("Мг-Мн 11:15 свободно 1");
                    this.add("Мг-Мн 13:10 свободно 10");
                    this.add("Мг-Мн 18:40 свободно 0");
                }
            });
            this.put("10-03-21", new ArrayList<>() {
                {
                    this.add("Мн-Мг 10:20 свободно 15");
                    this.add("Мн-Мг 12:30 свободно 15");
                    this.add("Мн-Мг 14:40 свободно 14");
                    this.add("Мн-Мг 16:50 свободно 13");
                    this.add("Мг-Мн 08:10 свободно 12");
                    this.add("Мг-Мн 11:15 свободно 11");
                    this.add("Мг-Мн 13:10 свободно 10");
                    this.add("Мг-Мн 18:40 свободно 10");
                }
            });
            this.put("11-03-21", new ArrayList<>() {
                {
                    this.add("Мн-Мг 10:20 свободно 2");
                    this.add("Мн-Мг 12:30 свободно 3");
                    this.add("Мн-Мг 14:40 свободно 4");
                    this.add("Мн-Мг 16:50 свободно 5");
                    this.add("Мг-Мн 08:10 свободно 14");
                    this.add("Мг-Мн 11:15 свободно 11");
                    this.add("Мг-Мн 13:10 свободно 1");
                    this.add("Мг-Мн 18:40 свободно 10");
                }
            });
        }
    };

}
