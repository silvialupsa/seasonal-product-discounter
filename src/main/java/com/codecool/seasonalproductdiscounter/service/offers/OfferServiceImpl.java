package com.codecool.seasonalproductdiscounter.service.offers;

import com.codecool.seasonalproductdiscounter.model.offers.Offer;
import com.codecool.seasonalproductdiscounter.model.products.Product;
import com.codecool.seasonalproductdiscounter.service.discounts.DiscountProviderImpl;
import com.codecool.seasonalproductdiscounter.service.discounts.DiscountServiceImpl;
import com.codecool.seasonalproductdiscounter.service.products.provider.ProductProvider;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OfferServiceImpl implements OfferService {
    List <Product> products;

    public OfferServiceImpl(List<Product> products){
        this.products = products;
    }

    @Override
    public List<Offer> getOffers(LocalDate date) {
        List<Offer> offersForToday = new ArrayList<>();

        for(Product product: products){
            Offer currentProductOffer = new DiscountServiceImpl(new DiscountProviderImpl()).getOffer(product, date);
            if(currentProductOffer.discounts().size() > 0){
                offersForToday.add(currentProductOffer);
            }

        }
        return offersForToday;
    }
}
