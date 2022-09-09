package com.example.first.reactor;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.netty.Connection;
import reactor.netty.tcp.TcpClient;

@Slf4j
public class Client {
    public void start() {
        Connection c = TcpClient.create()
                .host("localhost")
                .port(8088)
                .handle((inbound,outbound) -> outbound.sendString(Mono.just("message from client")).then())
                .connectNow();
        c.onDispose().block();
    }
}
