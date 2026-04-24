package co.com.bancolombia.drivenadapters;

import co.com.bancolombia.model.gift.Gift;
import co.com.bancolombia.model.gift.gateways.GiftRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class GiftRepositoryImpl implements GiftRepository {

    @Override
    public List<Gift> findAll() {
        return Arrays.asList(
                new Gift("1", "Pañales", "AVAILABLE"),
                new Gift("2", "Biberón", "RESERVED"),
                new Gift("3", "Ropa bebé", "TAKEN")
        );
    }
}