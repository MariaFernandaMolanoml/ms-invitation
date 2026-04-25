package co.com.bancolombia.usecase.gift;

import co.com.bancolombia.model.gift.Gift;
import co.com.bancolombia.model.gift.gateways.GiftRepository;

import java.util.List;

public class GiftsUseCaseImpl implements GiftsUseCase {

    private final GiftRepository giftRepository;

    public GiftsUseCaseImpl(GiftRepository giftRepository) {
        this.giftRepository = giftRepository;
    }

    @Override
    public List<Gift> getGifts() {
        return giftRepository.findAll();
    }
}
