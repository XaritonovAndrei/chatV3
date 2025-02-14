package com.chatAppV3.app.controller;

import com.chatAppV3.app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    // когда клиент отправляет сообщение на эндпоинт sendMessage,
    //      этот метод его обрабатывает и отправляет return в /broker/messages
    // аннотация sendTo конвертирует return этого метода в сообщение и броадкастит его всем клиентам,
    //      подключенным к /broker/messages
    @MessageMapping("/sendMessage") // полный эндпоинт /app/sendMessage
    @SendTo("/broker/messages")
    public ChatMessage sendMessage(ChatMessage message){
        return message;
    }

    @GetMapping("chat")
    public String chat(){
        // chat - темплейт для таймлифа
        return "chat";
    }

}
