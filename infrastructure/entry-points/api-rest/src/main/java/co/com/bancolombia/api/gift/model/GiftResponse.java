package co.com.bancolombia.api.gift.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GiftResponse {
    private String id;
    private String name;
    private String status;
}