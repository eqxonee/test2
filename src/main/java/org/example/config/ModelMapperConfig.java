package org.example.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Класс, регистирующий modelMapper для приложения
 *
 * @see ModelMapper
 */
@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); // Строгая стратегия сопоставления

        // Настройка преобразования LocalDateTime в OffsetDateTime
        modelMapper.createTypeMap(LocalDateTime.class, OffsetDateTime.class)
                .setConverter(context -> context.getSource().atOffset(ZoneOffset.UTC));

        return modelMapper;
    }
}
