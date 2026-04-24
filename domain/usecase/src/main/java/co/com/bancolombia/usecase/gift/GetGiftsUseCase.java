package co.com.bancolombia.usecase.gift;

import co.com.bancolombia.model.gift.Gift;
import co.com.bancolombia.model.gift.gateways.GiftRepository;

import java.util.List;

public class GetGiftsUseCase {

    private final GiftRepository giftRepository;

    public GetGiftsUseCase(GiftRepository giftRepository) {
        this.giftRepository = giftRepository;
    }

    public List<Gift> getGifts() {
        return giftRepository.findAll();
    }
}