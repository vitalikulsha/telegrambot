package io.github.vitalikulsha.telegrambot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.IOException;

@Component
@PropertySource("application.properties")
public class TelegramBot extends TelegramLongPollingBot {
    @Value("${bot.username}")
    private String botUsername;
    @Value("${bot.token}")
    private String botToken;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    KeyboardMessage keyboardMessage;


    @Override
    public void onUpdateReceived(Update update) {
        //SendMessage keyboardMessage = keyBoardMessage.sendInlineKeyBoardMessage(update.getMessage().getChatId());
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(update.getMessage().getChatId());

        //SendMessage sendMessageService = messageService.onUpdateReceived(update);
        sendMessage.setReplyMarkup(keyboardMessage.replyKeyboardMarkup);
        sendMessage.setText(keyboardMessage.getMessage(update));

        try {

            execute(sendMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void saveJson(Update update) {
        try {
            objectMapper.writeValue(new File("src/test/resources/update.json"), update);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
