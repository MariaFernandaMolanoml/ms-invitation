package co.com.bancolombia.jpa.invitation;

import co.com.bancolombia.jpa.gift.GiftData;
import co.com.bancolombia.model.gift.Gift;
import co.com.bancolombia.model.invitations.Invitation;
import co.com.bancolombia.model.invitations.gateways.InvitationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Repository
public class InvitationDataRepositoryAdapterImpl implements InvitationRepository {

    private final InvitationDataRepository invitationDataRepository;

    public InvitationDataRepositoryAdapterImpl(InvitationDataRepository invitationDataRepository) {
        this.invitationDataRepository = invitationDataRepository;
    }


    @Override
    public Invitation save(Invitation invitation) {

        InvitationData data = toData(invitation);

        InvitationData saved = invitationDataRepository.save(data);

        return toDomain(saved);
    }
    @Override
    public List<Invitation> findAll() {
        return StreamSupport
                .stream(invitationDataRepository.findAll().spliterator(), false)
                .map(this::toDomain)
                .toList();
    }

    @Override
    public Optional<Invitation> findById(UUID id) {
        return invitationDataRepository.findById(id)
                .map(this::toDomain);
    }

    private InvitationData toData(Invitation invitation) {
        if (invitation == null) {
            return null;
        }

        InvitationData data = new InvitationData();
        data.setId(invitation.getId());
        data.setName_person(invitation.getName_person());
        data.setNumber_cell(invitation.getNumber_cell());
        data.setStatus(invitation.getStatus());
        data.setCreate_date(invitation.getCreate_date());
        data.setConfirm_date(invitation.getConfirm_date());

        if (invitation.getGift() != null) {
            GiftData giftData = new GiftData();
            giftData.setId(invitation.getGift().getId());
            data.setGift(giftData);
        }

        return data;
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
