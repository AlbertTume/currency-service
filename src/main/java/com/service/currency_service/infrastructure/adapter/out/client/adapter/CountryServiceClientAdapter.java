package com.service.currency_service.infrastructure.adapter.out.client.adapter;

import com.service.currency_service.application.dto.CountryCurrencyResponseDTO;
import com.service.currency_service.application.port.out.CountryServiceClient;
import com.service.currency_service.infrastructure.adapter.out.client.dto.CountryValidationResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;


@Component
public class CountryServiceClientAdapter implements CountryServiceClient {

    private static final Logger log = LoggerFactory.getLogger(CountryServiceClientAdapter.class);

    private final RestClient restClient;
    private final String basePath;

    public CountryServiceClientAdapter(
            RestClient.Builder restClientBuilder,
            @Value("${services.country-service.url}") String baseUrl,
            @Value("${services.country-service.base-path}") String basePath){
        this.restClient = restClientBuilder.baseUrl(baseUrl).build();
        this.basePath = basePath;
    }

    @Override
    public boolean validateCountryExists(String countryIsoCode) {
        String uri = basePath + "/countries/validate/" + countryIsoCode;
        log.debug("Validating country existence: {}", uri);

        try {
            CountryValidationResponseDTO responseDTO = restClient.get()
                    .uri(uri)
                    .retrieve()
                    .body(CountryValidationResponseDTO.class);

            boolean exists = responseDTO != null && responseDTO.isExists();
            log.debug("Country {} exists: {}", countryIsoCode, exists);
            return exists;
        } catch (RestClientException e) {
            log.error("Error validation country {}: {}", countryIsoCode, e.getMessage());
            return false;
        }
    }

}
