package service.offers;

import com.codecool.seasonalproductdiscounter.model.offers.Offer;
import com.codecool.seasonalproductdiscounter.service.offers.OfferService;
import com.codecool.seasonalproductdiscounter.service.offers.OfferServiceImpl;
import com.codecool.seasonalproductdiscounter.service.products.provider.RandomProductGenerator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OfferServiceImplTest {
    private final OfferService offerService;
    private final RandomProductGenerator provider;

    public OfferServiceImplTest() {
        this.provider = new RandomProductGenerator(4, 10, 50);
        this.offerService = new OfferServiceImpl(provider.getProducts());
    }

    @Test
    public void getOffersTest (){
        LocalDate date = LocalDate.now();
        List <Offer> actual = offerService.getOffers(date);
        for(Offer offer : actual){
            System.out.println(offer);
        }
        boolean countOffers = actual.size() > 0;
        assertTrue(countOffers);
    }

}
