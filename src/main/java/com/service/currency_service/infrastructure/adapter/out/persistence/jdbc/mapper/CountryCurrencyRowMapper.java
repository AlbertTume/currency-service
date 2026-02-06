package com.service.currency_service.infrastructure.adapter.out.persistence.jdbc.mapper;

import com.service.currency_service.domain.model.CountryCurrency;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CountryCurrencyRowMapper implements RowMapper<CountryCurrency> {

    public CountryCurrency mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CountryCurrency(
                null,
                rs.getString("country_iso_code"),
                rs.getString("currency_code"),
                rs.getString("currency_name"),
                rs.getBoolean("is_primary")
        );
    }

}