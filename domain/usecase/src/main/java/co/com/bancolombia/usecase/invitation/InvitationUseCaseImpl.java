package co.com.bancolombia.usecase.invitation;

import co.com.bancolombia.model.invitations.Invitation;
import co.com.bancolombia.model.invitations.gateways.InvitationRepository;

import java.util.Optional;
import java.util.UUID;

public class InvitationUseCaseImpl implements InvitationUseCase{

    private final InvitationRepository invitationRepository;

    public InvitationUseCaseImpl(InvitationRepository invitationRepository) {
        this.invitationRepository = invitationRepository;
    }

    @Override
    public Invitation createInvitation(Invitation invitation) {
        return null;
    }

    @Override
    public Optional<Invitation> getInvitationById(UUID id) {
        return invitationRepository.findById(id);
    }
}
