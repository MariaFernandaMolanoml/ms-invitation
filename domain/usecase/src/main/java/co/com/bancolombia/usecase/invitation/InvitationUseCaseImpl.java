package co.com.bancolombia.usecase.invitation;

import co.com.bancolombia.model.gift.Gift;
import co.com.bancolombia.model.gift.gateways.GiftRepository;
import co.com.bancolombia.model.invitations.Invitation;
import co.com.bancolombia.model.invitations.gateways.InvitationRepository;
import co.com.bancolombia.model.status.Status;
import co.com.bancolombia.usecase.exception.NoAvailableGiftsException;
import co.com.bancolombia.model.status.Status;

import java.util.Date;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

public class InvitationUseCaseImpl implements InvitationUseCase {

    private final InvitationRepository invitationRepository;
    private final GiftRepository giftRepository;
    private final Random random = new Random();

    public InvitationUseCaseImpl(InvitationRepository invitationRepository,
                                 GiftRepository giftRepository) {
        this.invitationRepository = invitationRepository;
        this.giftRepository = giftRepository;
    }

    @Override
    public Invitation createInvitation(Invitation invitation) {

        invitation.setId(UUID.randomUUID());
        invitation.setStatus(Status.PENDING);
        invitation.setCreate_date(new Date());

        List<Gift> allGifts = giftRepository.findAll();

        List<UUID> usedGiftIds = invitationRepository.findAll()
                .stream()
                .map(Invitation::getGift)
                .filter(Objects::nonNull)
                .map(Gift::getId)
                .toList();

        List<Gift> availableGifts = allGifts.stream()
                .filter(g -> !usedGiftIds.contains(g.getId()))
                .toList();

        if (availableGifts.isEmpty()) {
            throw new NoAvailableGiftsException();
        }

        Gift randomGift = availableGifts.get(random.nextInt(availableGifts.size()));

        invitation.setGift(randomGift);

        return invitationRepository.save(invitation);
    }

    @Override
    public Optional<Invitation> getInvitationById(UUID id) {
        return invitationRepository.findById(id);
    }
    @Override
    public Invitation acceptInvitation(UUID id) {

        Invitation invitation = invitationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invitación no encontrada"));

        if (invitation.getStatus() != Status.PENDING) {
            throw new RuntimeException("La invitación no está en estado válido");
        }
        invitation.setStatus(Status.ACCEPTED);
        invitation.setConfirm_date(new Date());

        return invitationRepository.save(invitation);
    }
}
