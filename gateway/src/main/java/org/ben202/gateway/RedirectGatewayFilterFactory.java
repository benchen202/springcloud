package org.ben202.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class RedirectGatewayFilterFactory extends AbstractGatewayFilterFactory<Object>{

	@Override
	public GatewayFilter apply(Object config) {
		return new RedirectGatewayFilter();
	}

}
