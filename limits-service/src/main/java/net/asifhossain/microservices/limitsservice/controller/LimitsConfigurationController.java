package net.asifhossain.microservices.limitsservice.controller;

import net.asifhossain.microservices.limitsservice.bean.LimitConfiguration;
import net.asifhossain.microservices.limitsservice.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retriveLimitsFromConfigurations() {

        return new LimitConfiguration(configuration.getMinimum(), configuration.getMaximum());
    }
}
