package com.codecool.seasonalproductdiscounter.service.products.browser;

import com.codecool.seasonalproductdiscounter.model.enums.Color;
import com.codecool.seasonalproductdiscounter.model.enums.Season;
import com.codecool.seasonalproductdiscounter.model.products.PriceRange;
import com.codecool.seasonalproductdiscounter.model.products.Product;
import com.codecool.seasonalproductdiscounter.service.products.provider.ProductProvider;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class ProductBrowserImpl implements ProductBrowser {
    private final ProductProvider provider;

    public ProductBrowserImpl(ProductProvider provider) {
        this.provider = provider;
    }

    public List<Product> getAll() {
        return provider.getProducts();
    }

    public List<Product> getByName(String name) {
        return provider.getProducts().stream()
                .filter(p -> p.name().contains(name))
                .collect(toList());
    }

    public List<Product> getByColor(Color color) {
        return provider.getProducts().stream()
                .filter(p -> p.color() == color)
                .collect(toList());
    }

    public List<Product> getBySeason(Season season) {
        return provider.getProducts().stream()
                .filter(p -> p.season() == season)
                .collect(toList());
    }

    public List<Product> getByPriceSmallerThan(double price) {
        return provider.getProducts().stream()
                .filter(p -> p.price() < price)
                .collect(toList());
    }

    public List<Product> getByPriceGreaterThan(double price) {
        return provider.getProducts().stream()
                .filter(p -> p.price() > price)
                .collect(Collectors.toList());
    }

    public List<Product> getByPriceRange(double minimumPrice, double maximumPrice) {
        return provider.getProducts().stream()
                .filter(p -> p.price() > minimumPrice && p.price() < maximumPrice)
                .collect(toList());
    }

    public Map<String, List<Product>> groupByName() {
        return provider.getProducts().stream()
                .collect(groupingBy(Product::name));
    }

    public Map<Color, List<Product>> groupByColor() {
        return provider.getProducts().stream()
                .collect(groupingBy(Product::color));
    }

    public Map<Season, List<Product>> groupBySeason() {
        return provider.getProducts().stream()
                .collect(groupingBy(Product::season));
    }

    public Map<PriceRange, List<Product>> groupByPriceRange() {
        double minPrice = getMinimumPrice();
        double maxPrice = getMaximumPrice();
        double diff = maxPrice - minPrice;

        PriceRange cheap = new PriceRange(minPrice, minPrice + diff / 3);
        PriceRange medium = new PriceRange(cheap.maximum(), cheap.maximum() + diff / 3);
        PriceRange expensive = new PriceRange(medium.maximum(), medium.maximum() + diff / 3);

        return provider.getProducts().stream()
                .collect(groupingBy(p -> {
                    if (cheap.contains(p.price())) {
                        return cheap;
                    } else if (medium.contains(p.price())) {
                        return medium;
                    } else {
                        return expensive;
                    }
                }));
    }

        return provider.getProducts().stream()
                .mapToDouble(Product::price)
                .min()
                .orElse(0);
    }

    private double getMaximumPrice() {
        return provider.getProducts().stream()
                .mapToDouble(Product::price)
                .max()
                .orElse(0);
    }

    public List<Product> orderByName() {
        return provider.getProducts().stream()
                .sorted(Comparator.comparing(Product::name))
                .collect(toList());
    }

    public List<Product> orderByColor() {
        return provider.getProducts().stream()
                .sorted(Comparator.comparing(Product::color))
                .collect(toList());
    }

    public List<Product> orderBySeason() {
        return provider.getProducts().stream()
                .sorted(Comparator.comparing(Product::season))
                .collect(toList());
    }

    public List<Product> orderByPrice() {
        return provider.getProducts().stream()
                .sorted(Comparator.comparing(Product::price))
                .collect(toList());
    }


