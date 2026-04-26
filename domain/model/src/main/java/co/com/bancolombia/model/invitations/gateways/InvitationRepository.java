package co.com.bancolombia.model.invitations.gateways;

import co.com.bancolombia.model.invitations.Invitation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InvitationRepository {

    Invitation save(Invitation invitation);

    Optional<Invitation> findById(UUID id);
    List<Invitation> findAll();

}


