package com.example.ittranslatorbot.handler.iml;

import com.example.ittranslatorbot.handler.UserRequestHandler;
import com.example.ittranslatorbot.model.UserRequest;
import com.example.ittranslatorbot.service.TelegramService;
import org.springframework.stereotype.Component;

@Component
public class StartCommandHandler extends UserRequestHandler {

    private final TelegramService telegramService;

    public StartCommandHandler(TelegramService telegramService) {
        this.telegramService = telegramService;
    }

    @Override
    public boolean isApplicable(UserRequest userRequest) {
        String command = "/start";
        return isCommand(userRequest.getUpdate(), command);
    }

    @Override
    public void handle(UserRequest request) {
        telegramService.sendMessage(request.getChatId(),
                "Думає я зможу хоть чимось тобі допомогти? Давай, пиши своє слово");
    }

    @Override
    public boolean isGlobal() {
        return true;
    }
}