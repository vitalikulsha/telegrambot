package io.github.vitalikulsha.telegrambot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.vitalikulsha.telegrambot.TelegrambotApplicationTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MessageServiceTest extends TelegrambotApplicationTests {

    @Autowired
    TelegramBot telegramBot;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MessageService messageService;
    @Autowired
    Keyboard keyboard;

    //@Test
    void onUnknownReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/update.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("Do no");
        assertEquals(expectedResult, actualResult);
    }

    //@Test
    void onStartReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/start.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("Hello");
        assertEquals(expectedResult, actualResult);
    }

    //@Test
    void onSettingsReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/settings.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("Settings");
        assertEquals(expectedResult, actualResult);
    }

    //@Test
    void onHelpReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/help.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("Help");
        assertEquals(expectedResult, actualResult);
    }

    private SendMessage makeMessage(String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(1360362063L);
        sendMessage.setText(text);
        return sendMessage;
    }

}