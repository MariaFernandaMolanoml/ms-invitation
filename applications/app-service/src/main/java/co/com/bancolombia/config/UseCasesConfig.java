package co.com.bancolombia.config;

import co.com.bancolombia.model.gift.gateways.GiftRepository;
import co.com.bancolombia.model.invitations.gateways.InvitationRepository;
import co.com.bancolombia.usecase.gift.GiftsUseCase;
import co.com.bancolombia.usecase.gift.GiftsUseCaseImpl;
import co.com.bancolombia.usecase.invitation.InvitationUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfig {

        @Bean
        public GiftsUseCase getGiftsUseCase(GiftRepository giftRepository) {
                return new GiftsUseCaseImpl(giftRepository);
        }

        @Bean
        public InvitationUseCaseImpl invitationUseCase(
                InvitationRepository invitationRepository,
                GiftRepository giftRepository) {

                return new InvitationUseCaseImpl(invitationRepository, giftRepository);
        }
}