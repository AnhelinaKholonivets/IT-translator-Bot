package com.example.ittranslatorbot;

import com.example.ittranslatorbot.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Component
public class ItTranslatorBot extends TelegramLongPollingBot {

    @Value("${bot.token}")
    private String botToken;

    @Value("${bot.username}")
    private String botUsername;

    private final Dispatcher dispatcher;

    public ItTranslatorBot(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String textFromUser = update.getMessage()
                    .getText();

            Long userId = update.getMessage()
                    .getFrom()
                    .getId();

            String userFirstName = update.getMessage()
                    .getFrom()
                    .getFirstName();

            log.info("[{}, {}] : {}", userId, userFirstName, textFromUser);

            Long chatId = update.getMessage().getChatId();

            UserRequest userRequest = UserRequest.builder()
                    .update(update)
                    .chatId(chatId)
                    .build();

//            boolean dispatched = dispatcher.dispatch(userRequest); useless

            if (!dispatcher.dispatch(userRequest)) {
                log.warn("Unexpected update from user");
            }

        } else {
            log.warn("Unexpected update from user");
        }
    }

    /**
     * We do not like using server methods in POJO classes.
     */
    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
