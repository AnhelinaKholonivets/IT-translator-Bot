package com.example.ittranslatorbot.handler.iml;

import com.example.ittranslatorbot.handler.UserRequestHandler;
import com.example.ittranslatorbot.model.UserRequest;
import com.example.ittranslatorbot.service.TelegramService;
import org.springframework.stereotype.Component;

/**
 *  This class has to have comments on what it does.
 */
@Component
public class StartCommandHandler extends UserRequestHandler {

    // this must be commented on what this is used for.
    private final TelegramService telegramService;

    public StartCommandHandler(TelegramService telegramService) {
        this.telegramService = telegramService;
    }

    @Override
    public boolean isApplicable(UserRequest userRequest) {
        String command = "/start";

        // we are to separate what method returns with its body itself.
        return isCommand(userRequest.getUpdate(), command);
    }

    @Override
    public void handle(UserRequest request) {
        // when method arguments are too long, we put them under each other so to master readability of the code.
        telegramService.sendMessage(request.getChatId(),
                "Думає я зможу хоть чимось тобі допомогти? Давай, пиши своє слово");

    }

    @Override
    public boolean isGlobal() {
        return true;
    }
}