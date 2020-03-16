package org.ben202.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class RedirectGatewayFilter implements GatewayFilter, Ordered {

	@Override
	public int getOrder() {
		return 1;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		//转换成服务的注册名
		ServerHttpRequest request = exchange.getRequest().mutate()
                .path("/service-web/ok")
                .build();
		System.out.println(request.getURI().getHost()+request.getURI().getPath());
		return chain.filter(exchange.mutate().request(request).build());
	}

}
