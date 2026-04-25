package co.com.bancolombia.jpa.invitation;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface InvitationDataRepository extends CrudRepository <InvitationData, UUID> {
}