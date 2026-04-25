package co.com.bancolombia.api;

import co.com.bancolombia.model.gift.Gift;
import co.com.bancolombia.usecase.gift.GetGiftsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gifts")
@RequiredArgsConstructor
public class GiftController {

    private final GetGiftsUseCase getGiftsUseCase;

    @GetMapping
    public List<Gift> getGifts() {

        return getGiftsUseCase.getGifts();
    }
}
