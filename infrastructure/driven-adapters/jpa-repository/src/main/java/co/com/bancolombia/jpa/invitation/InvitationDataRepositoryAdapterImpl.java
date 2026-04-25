package co.com.bancolombia.jpa.invitation;

import co.com.bancolombia.jpa.gift.GiftData;
import co.com.bancolombia.model.gift.Gift;
import co.com.bancolombia.model.invitations.Invitation;
import co.com.bancolombia.model.invitations.gateways.InvitationRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class InvitationDataRepositoryAdapterImpl implements InvitationRepository {

    private final InvitationDataRepository invitationDataRepository;

    public InvitationDataRepositoryAdapterImpl(InvitationDataRepository invitationDataRepository) {
        this.invitationDataRepository = invitationDataRepository;
    }


    @Override
    public Invitation save(Invitation invitation) {
        return null;
    }

    @Override
    public Optional<Invitation> findById(UUID id) {
        return invitationDataRepository.findById(id)
                .map(this::toDomain);
    }

    private Invitation toDomain(InvitationData data) {
        if (data == null) {
            return null;
        }

        return new Invitation(
                data.getId(),
                data.getName_person(),
                data.getNumber_cell(),
                data.getStatus(),
                data.getCreate_date(),
                data.getConfirm_date(),
                data.getGift() != null ? toDomainGift(data.getGift()) : null
        );
    }

    private Gift toDomainGift(GiftData data) {
        if (data == null) {
            return null;
        }
        return new Gift(
                data.getId(),
                data.getName(),
                data.getStatus()
        );
    }
}
