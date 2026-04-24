package co.com.bancolombia.config;

import co.com.bancolombia.model.gift.gateways.GiftRepository;
import co.com.bancolombia.usecase.gift.GetGiftsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfig {

        @Bean
        public GetGiftsUseCase getGiftsUseCase(GiftRepository giftRepository) {
                return new GetGiftsUseCase(giftRepository);
        }
}