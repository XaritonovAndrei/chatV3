package com.chatAppV3.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


// интерфейс с методами для конфига сообщений по протоколу STOMP для вебсокета
// вебсокет - поддерживаемый коннект
// стомп - структура. организация/роуты
@Configuration
@EnableWebSocketMessageBroker // MessageBroker - роутер для сообщений
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // addEndpoint - эндпоинт для самого чата, порт 8080
        // setAllowedOrigins - для фронтэнда
        // withSockJS - для тех клиентов, которые не поддерживают вебсокет
        registry.addEndpoint("/chat")
                .setAllowedOrigins("http://localhost:8080")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // enableSimpleBroker - включает брокер, далее url /broker/chatRoom1 и т.п. броадкастит всем клиентам,
//                которые на него подписаны
        // сообщения ожидаются с /app/sendMessage
        // setApplicationDestinationPrefixes - указание обрабатывать сообщения с префиксом /app
        registry.enableSimpleBroker("/broker");
        registry.setApplicationDestinationPrefixes("/app");
    }
}
