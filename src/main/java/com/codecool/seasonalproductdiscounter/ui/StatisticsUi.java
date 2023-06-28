package com.codecool.seasonalproductdiscounter.ui;

import com.codecool.seasonalproductdiscounter.service.products.statistics.ProductStatistics;
import com.codecool.seasonalproductdiscounter.service.users.AuthenticationService;

public class StatisticsUi extends UiBase {
    private final ProductStatistics productStatistics;

    public StatisticsUi( ProductStatistics productStatistics, String title, boolean authenticationNeeded) {
        super(title, authenticationNeeded);
        this.productStatistics = productStatistics;
    }

    @Override
    public void run() {
        System.out.println("Total products: " + productStatistics.totalProducts());
        System.out.println("Average price of products: " + productStatistics.getAveragePrice());
        System.out.println("Cheapest product: " + "[" + productStatistics.getCheapest() + "]");
        System.out.println("Most expensive product: " + "[" + productStatistics.getMostExpensive() + "]");
    }

    @Override
    public boolean authenticate() {
        return false;
    }
}


