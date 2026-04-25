package co.com.bancolombia.api.gift;

import co.com.bancolombia.model.gift.Gift;
import co.com.bancolombia.usecase.gift.GiftsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gifts")
@RequiredArgsConstructor
public class GiftController {

    private final GiftsUseCase getGiftsUseCase;

    @GetMapping
    public List<Gift> getGifts() {

        return getGiftsUseCase.getGifts();
    }
}
