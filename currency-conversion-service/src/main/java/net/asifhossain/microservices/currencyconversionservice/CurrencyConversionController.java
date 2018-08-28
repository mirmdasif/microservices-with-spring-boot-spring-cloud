package net.asifhossain.microservices.currencyconversionservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    private static final Logger LOG = LoggerFactory.getLogger(CurrencyConversionController.class);

    private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    public CurrencyConversionController(CurrencyExchangeServiceProxy currencyExchangeServiceProxy) {
        this.currencyExchangeServiceProxy = currencyExchangeServiceProxy;
    }

    @GetMapping("currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from,
                                                  @PathVariable String to,
                                                  @PathVariable BigDecimal quantity) {

        CurrencyConversionBean conversionEntity = currencyExchangeServiceProxy.retrieveExchangeValue(from, to);

        LOG.info("{}", conversionEntity);

        return new CurrencyConversionBean(1L, from, to, conversionEntity.getConversionMultiple(), quantity,
                quantity.multiply(conversionEntity.getConversionMultiple()), conversionEntity.getPort());
    }
}
