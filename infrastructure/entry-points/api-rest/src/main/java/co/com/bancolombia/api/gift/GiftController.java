package co.com.bancolombia.api.gift;

import co.com.bancolombia.api.gift.model.GiftResponse;
import co.com.bancolombia.api.util.ApiResponse;
import co.com.bancolombia.usecase.gift.GiftsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/gifts")
@RequiredArgsConstructor
public class GiftController {

    private final GiftsUseCase getGiftsUseCase;

    @GetMapping
    public ApiResponse<List<GiftResponse>> getGifts() {

        List<GiftResponse> response = getGiftsUseCase.getGifts()
                .stream()
                .map(gift -> new GiftResponse(
                        gift.getId().toString(),
                        gift.getName(),
                        gift.getStatus().name()
                ))
                .toList();

        return new ApiResponse<>(response);
    }
}