package io.github.vitalikulsha.telegrambot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Service
public class Keyboard {
    public SendMessage sendInlineKeyBoardMessage(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton buttonReserve = new InlineKeyboardButton();
        InlineKeyboardButton buttonView = new InlineKeyboardButton();
        InlineKeyboardButton buttonSetting = new InlineKeyboardButton();
        InlineKeyboardButton buttonHelp = new InlineKeyboardButton();
        buttonReserve.setText("Бронь");
        buttonReserve.setCallbackData("Reserve");
        buttonView.setText("Просмотр");
        buttonView.setCallbackData("View");
        buttonSetting.setText("Настройки");
        buttonSetting.setCallbackData("/settings");
        buttonHelp.setText("Помощь");
        buttonHelp.setCallbackData("/help");
        List<InlineKeyboardButton> keyboardButtonsFirst = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsSecond = new ArrayList<>();
        keyboardButtonsFirst.add(buttonReserve);
        keyboardButtonsFirst.add(buttonView);
        keyboardButtonsSecond.add(buttonSetting);
        keyboardButtonsSecond.add(buttonHelp);
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsFirst);
        rowList.add(keyboardButtonsSecond);
        inlineKeyboardMarkup.setKeyboard(rowList);
        return new SendMessage().setChatId(chatId).setText("Hello!").setReplyMarkup(inlineKeyboardMarkup);
    }
}
