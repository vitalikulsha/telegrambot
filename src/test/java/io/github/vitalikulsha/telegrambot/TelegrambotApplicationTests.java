package io.github.vitalikulsha.telegrambot;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.vitalikulsha.telegrambot.config.Mapper;
import io.github.vitalikulsha.telegrambot.service.MessageService;
import io.github.vitalikulsha.telegrambot.service.TelegramBot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TelegramBot.class, Mapper.class, MessageService.class})
public class TelegrambotApplicationTests {

    //@Test
    void contextLoads() {
    }

}
