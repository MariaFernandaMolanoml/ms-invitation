package co.com.bancolombia.usecase.gift;

import co.com.bancolombia.model.gift.Gift;
import co.com.bancolombia.model.gift.gateways.GiftRepository;

import java.util.List;

public interface GiftsUseCase {

    List<Gift> getGifts();

}