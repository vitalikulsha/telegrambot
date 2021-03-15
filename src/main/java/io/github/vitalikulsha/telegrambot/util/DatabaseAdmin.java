package io.github.vitalikulsha.telegrambot.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DatabaseAdmin {
  protected static final String PASSWORD = "adminpassword";
  public static final String REFERENCE = "Возможности меню администратора:\n"+
    "Добавление рейса - добавить новый рейс с количеством билетов\n"+
    "Просмотр рейсов - просмотр рейсов на заданную дату и направление, выводит информацию о времени отправления и количестве свободных мест\n"+
    "Просмотр броней - просмотр данных клиентов (номер телефона и имя), забронировавших билеты на заданный рейс.\n";
  
  public static Set<String> reserveTripSet = new HashSet<>() {
        {
            this.add("МнМг0803211020");
            this.add("МнМг0803211230");
            this.add("МнМг0803211440");
            this.add("МнМг0803211650");
            this.add("МнМг0903211020");
            this.add("МнМг0903211230");
            this.add("МнМг0903211440");
            this.add("МнМг0903211650");
            this.add("МнМг1003211020");
            this.add("МнМг1003211230");
            this.add("МнМг1003211440");
            this.add("МнМг1003211650");
            this.add("МнМг1003211020");
            this.add("МнМг1103211230");
            this.add("МнМг1103211440");
            this.add("МнМг1103211650");
            this.add("МгМн0803210810");
            this.add("МгМн0803211115");
            this.add("МгМн0803211310");
            this.add("МгМн0803211840");
            this.add("МгМн0903210810");
            this.add("МгМн0903211115");
            this.add("МгМн0903211310");
            this.add("МгМн0903211840");
            this.add("МгМн1003210810");
            this.add("МгМн1003211115");
            this.add("МгМн1003211310");
            this.add("МгМн1003211840");
            this.add("МгМн1103210810");
            this.add("МгМн1103211115");
            this.add("МгМн1103211310");
            this.add("МгМн1103211840");          
        }
    };
  
  public static Map<String, List<String>> reserveTripKlientMap = new HashMap<>(){
    {
      this.put("МнМг0803211020", new ArrayList<>(){
        {
          this.add("+375291234567 Светлана");
          this.add("+375331111111 Пётр");
        }
      };)
        this.put("МгМн0803210810", new ArrayList<>(){
        {
          this.add("+375290000000 Сергей");
          this.add("+375332222222 Антон");
          this.add("+375333333333 Иван");
        }
      };)
    }
  };
  
   public static Set<String> tripSet = new HashSet<>() {
        {
            this.add("Мн-Мг 08-03-2021");
            this.add("Мн-Мг 09-03-2021");
            this.add("Мн-Мг 10-03-2021");
            this.add("Мн-Мг 11-03-2021");
            this.add("Мг-Мн 08-03-2021");
            this.add("Мг-Мн 09-03-2021");
            this.add("Мг-Мн 10-03-2021");
            this.add("Мг-Мн 11-03-2021");
        }
    };
  
    public static Map<String, List<String>> tripKlientMap = new HashMap<>(){
    {
      this.put("Мн-Мг 08-03-2021", new ArrayList<>(){
        {
          this.add("10:20 свободно 15");
          this.add("12:30 свободно 12");
          this.add("14:40 свободно 11");
          this.add("16:50 свободно 14");
        }
      };)
        this.put("Мн-Мг 08-03-2021", new ArrayList<>(){
        {
          this.add("08:10 свободно 8");
          this.add("11:15 свободно 10");
          this.add("13:10 свободно 12");
          this.add("18:40 свободно 9");
        }
      };)
    }
  };
  
}
