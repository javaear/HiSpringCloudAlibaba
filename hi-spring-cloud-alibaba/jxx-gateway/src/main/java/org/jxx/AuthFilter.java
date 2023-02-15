package org.jxx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class AuthFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info("=========1=======AuthFilter=====================");
        log.info("=2==访问链接===localhost:6006/jxx-request-order/order/test/restById?id=dsafdas==");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
