package com.codecool.seasonalproductdiscounter.ui;

import com.codecool.seasonalproductdiscounter.model.offers.Offer;
import com.codecool.seasonalproductdiscounter.service.offers.OfferService;
import com.codecool.seasonalproductdiscounter.service.users.AuthenticationService;

import java.time.LocalDate;

public class OffersUi extends UiBase{
    private final OfferService offerService;
    public OffersUi(String title, OfferService offerService, boolean authenticationNeeded) {
        super(title, authenticationNeeded);
        this.offerService = offerService;
    }

    @Override
    public void run() {
        for(Offer offer : offerService.getOffers(LocalDate.now())){
            System.out.println(String.format("Offer: %s", offer));
        }
    }

    @Override
    public boolean authenticate() {
        return false;
    }
}
