package pl.kurs.bitcoindobijaczapp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  This class is responsible for configuring a beans
 */
@Configuration
public class BeansConfig {
    /**
     * Creates and  returns a new instance of ObjectMapper
     * @return instance of objectMapper
     */
    @Bean
    public ObjectMapper createObjectMapper(){
        return new ObjectMapper();
    }
}
