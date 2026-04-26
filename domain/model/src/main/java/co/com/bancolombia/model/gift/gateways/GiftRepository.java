package co.com.bancolombia.model.gift.gateways;

import co.com.bancolombia.model.gift.Gift;

import java.util.List;


public interface GiftRepository {
    List<Gift> findAll();
    Gift save(Gift gift);
}