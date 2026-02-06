package com.service.currency_service.infrastructure.adapter.out.persistence.jdbc.adapter;

import com.service.currency_service.domain.model.CountryCurrency;
import com.service.currency_service.domain.repository.CountryCurrencyQueryRepository;
import com.service.currency_service.infrastructure.adapter.out.persistence.jdbc.mapper.CountryCurrencyRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryCurrencyQueryAdapter implements CountryCurrencyQueryRepository {

    private static final Logger log = LoggerFactory.getLogger(CountryCurrencyQueryAdapter.class);

    private final JdbcTemplate jdbcTemplate;
    private final CountryCurrencyRowMapper rowMapper;

    public CountryCurrencyQueryAdapter(JdbcTemplate jdbcTemplate,
                                       CountryCurrencyRowMapper rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public List<CountryCurrency> findCountriesByCurrency(String currencyCode) {
        log.debug("Calling stored procedure get_countries_by_currency with code {}", currencyCode);
        String sql = "SELECT * FROM get_countries_by_currency(?)";
        List<CountryCurrency> result = jdbcTemplate.query(sql, rowMapper, currencyCode);
        log.debug("Found {} countries using currency {}", result.size(), currencyCode);

        return result;
    }

}
