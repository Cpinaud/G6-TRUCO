package com.tallerwebi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/partida");
    }

    @Bean
    public MyChannelInterception channelInterceptor() {
        return new MyChannelInterception();
    }


//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        registry.addHandler(myHandler(), "/myHandler")
//            .setHandshakeHandler(handshakeHandler())
//            .addInterceptors(new HttpSessionHandshakeInterceptor())
//            .setAllowedOrigins( "*" ); //configurar los orígenes permitidos (CORS) para tu aplicación WebSocket
//            ;
//    }
//
//
//    /* definir un punto de entrada WebSocket que permite a los clientes enviar datos al servidor a través de una
//     * conexión WebSocket.*/
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("home");
//    }
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//        config.setApplicationDestinationPrefixes("/app");
//        config.enableSimpleBroker("/topic", "/queue");
//    }
//
//    @Bean
//    public WebSocketHandler myHandler() {
//        return new ControladorWebSocket();
//    }
//
//
//    /* ServletServerContainerFactoryBeana xpone propiedades de configuración que controlan las características del
//     * tiempo de ejecución, como el tamaño del búfer de mensajes, el tiempo de espera de inactividad y otros. */
//    @Bean
//    public ServletServerContainerFactoryBean createWebSocketContainer() {
//        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
//        container.setMaxTextMessageBufferSize(8192);
//        container.setMaxBinaryMessageBufferSize(8192);
//        return container;
//    }
//
//
//    /* Para Jetty, deberá proporcionar un Jetty preconfigurado WebSocketServerFactoryy conectarlo a Spring
//     * DefaultHandshakeHandlera través de su configuración WebSocket Java:*/
//    @Bean
//    public DefaultHandshakeHandler handshakeHandler() {
//
//        WebSocketPolicy policy = new WebSocketPolicy(WebSocketBehavior.SERVER);
//        policy.setInputBufferSize(8192);
//        policy.setIdleTimeout(600000);
//
//        return new DefaultHandshakeHandler(
//                new JettyRequestUpgradeStrategy(policy));
//    }

}