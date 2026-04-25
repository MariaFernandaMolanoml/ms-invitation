package co.com.bancolombia.jpa.gift;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface GiftDataRepository extends CrudRepository<GiftData, UUID> {
}