package co.com.bancolombia.usecase.invitation;

import co.com.bancolombia.model.invitations.Invitation;

import java.util.Optional;
import java.util.UUID;

public interface InvitationUseCase {

    Invitation createInvitation(Invitation invitation);

    Optional<Invitation> getInvitationById(UUID id);

    Invitation acceptInvitation(UUID id);

}
