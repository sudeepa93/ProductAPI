package com.sudo.productapi.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomizeHealthCheckDetails implements HealthIndicator {

	@Override
	public Health health() {
		boolean error = false;
		if(error) {
			return Health.down().withDetail("Error occured !",123).build();
		}
		return Health.up().build();
	}

}
