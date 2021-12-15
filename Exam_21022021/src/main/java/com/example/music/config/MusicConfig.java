package com.example.music.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class MusicConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }


    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

//        modelMapper.addConverter(new Converter<String, LocalTime>() {
//            @Override
//            public LocalTime convert(MappingContext<String, LocalTime> mappingContext) {
//                return LocalTime.parse(mappingContext.getSource(), LocalTime.of("HH,mm,ss"));
//            }
//        });

//        modelMapper.addConverter(new Converter<String, LocalDate>() {
//
//            @Override
//            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
//                return LocalDate
//                        .parse(mappingContext.getSource(),
//                                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//            }
//        });
        return new ModelMapper();
    }

}
