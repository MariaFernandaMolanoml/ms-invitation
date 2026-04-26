package co.com.bancolombia.jpa.gift;

import co.com.bancolombia.model.gift.Gift;
import co.com.bancolombia.model.gift.gateways.GiftRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.StreamSupport;

@Repository
public class GiftRepositoryAdapterImpl implements GiftRepository {

    private final GiftDataRepository repository;

    public GiftRepositoryAdapterImpl(GiftDataRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Gift> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(this::toDomain)
                .toList();
    }

    @Override
    public Gift save(Gift gift) {

        GiftData data = toData(gift);
        GiftData saved = repository.save(data);

        return toDomain(saved);
    }

    private Gift toDomain(GiftData data) {
        return new Gift(
                data.getId(),
                data.getName(),
                data.getStatus()
        );
    }

    private GiftData toData(Gift gift) {
        GiftData data = new GiftData();
        data.setId(gift.getId());
        data.setName(gift.getName());
        data.setStatus(gift.getStatus());
        return data;
    }
}