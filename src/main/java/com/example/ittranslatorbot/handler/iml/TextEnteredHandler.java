package com.example.ittranslatorbot.handler.iml;

import com.example.ittranslatorbot.handler.UserRequestHandler;
import com.example.ittranslatorbot.model.UserRequest;
import com.example.ittranslatorbot.service.TelegramService;
import com.example.ittranslatorbot.service.WordService;
import org.springframework.stereotype.Component;

@Component
public class TextEnteredHandler extends UserRequestHandler {
    private final TelegramService telegramService;
    private final WordService wordService;

    public TextEnteredHandler(TelegramService telegramService, WordService wordService) {
        this.telegramService = telegramService;
        this.wordService = wordService;
    }

    @Override
    public boolean isApplicable(UserRequest userRequest) {
        return isTextMessage(userRequest.getUpdate());
    }

    @Override
    public void handle(UserRequest userRequest) {
        String text = userRequest.getUpdate().getMessage().getText();
        telegramService.sendMessage(userRequest.getChatId(), wordService.getWordMeaning(text));
    }

    @Override
    public boolean isGlobal() {
        return false;
    }
}
