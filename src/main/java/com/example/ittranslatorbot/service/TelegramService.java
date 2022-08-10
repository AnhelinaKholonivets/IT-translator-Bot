package com.example.ittranslatorbot.service;

import com.example.ittranslatorbot.model.sender.ItTranslatorBotSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Slf4j
@Component
public class TelegramService {
    private final ItTranslatorBotSender botSender;

    public TelegramService(ItTranslatorBotSender botSender) {
        this.botSender = botSender;
    }

    public void sendMessage(Long chatId, String text) {
        sendMessage(chatId, text, null);
    }

    /**
     * How to write a builder:
     */
    public void sendMessage(Long chatId,
                            String text,
                            ReplyKeyboard replyKeyboard) {
        SendMessage sendMessage = SendMessage.builder()
                .text(text)
                .chatId(chatId.toString())
                .parseMode(ParseMode.HTML)
                .replyMarkup(replyKeyboard)
                .build();

        execute(sendMessage); // separate main goal of the method from its body.
    }

    private void execute(BotApiMethod botApiMethod) {
        try {
            botSender.execute(botApiMethod);
        } catch (Exception e) {
            log.error("Exception: ", e);
        }
    }
}
