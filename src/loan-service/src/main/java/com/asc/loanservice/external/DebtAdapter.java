package com.asc.loanservice.external;

import com.asc.loanservice.infrastructure.rule.port.DebtPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class DebtAdapter implements DebtPort {

    private final RestTemplate restTemplate;

    @Value("${debt.registry.uri}")
    private String deptRegistryUri;

    public DebtAdapter(@Qualifier("debtCustomerRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public DebtCustomerResult checkDebtClient(String customerTaxId) {
        Map<String, String> id = new HashMap<>();
        id.put("id", customerTaxId);
        URI uri = UriComponentsBuilder.fromUriString(deptRegistryUri).build(id);

        ResponseEntity<CustomerCheckResultDto> exchange =
                restTemplate.exchange(uri, HttpMethod.GET, null, CustomerCheckResultDto.class);
        Boolean isRegisteredDebtor = Optional
                .of(exchange)
                .map(HttpEntity::getBody)
                .map(CustomerCheckResultDto::getIsRegisteredDebtor)
                .orElse(false);

        return isRegisteredDebtor ? DebtCustomerResult.FAILURE : DebtCustomerResult.SUCCESS ;
    }
}
