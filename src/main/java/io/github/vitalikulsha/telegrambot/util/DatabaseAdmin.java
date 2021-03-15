package io.github.vitalikulsha.telegrambot.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DatabaseAdmin {
  protected static final String PASSWORD = "adminpassword";
  
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
}
