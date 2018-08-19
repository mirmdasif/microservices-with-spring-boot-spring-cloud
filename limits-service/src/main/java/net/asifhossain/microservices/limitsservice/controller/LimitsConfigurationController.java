package net.asifhossain.microservices.limitsservice.controller;

import net.asifhossain.microservices.limitsservice.bean.LimitConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @GetMapping("/limits")
    public LimitConfiguration retriveLimitsFromConfigurations() {

        return new LimitConfiguration(1, 1000);
    }
}
