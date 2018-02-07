package com.sea.ad.register.client;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

/**
 * @author lx48475
 * @version Id: HealthMonitor.java, v 0.1 2018年02月07 11:01 lx48475 Exp $
 */
public class HealthMonitor implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up().withDetail("Hello", "World !").build();
    }
}
