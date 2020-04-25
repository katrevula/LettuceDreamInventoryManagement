package com.lettucedream.api.service;


import com.lettucedream.api.model.ProductCatalog;

import java.util.List;

public interface ProductCatalogService {


    public List<ProductCatalog> getAllProductCatalogs();
    public Boolean isProductCatalogExists(ProductCatalog productCatalog);
    public Boolean isProductCatalogNameExists(ProductCatalog productCatalog);

    public ProductCatalog getProductCatalogByID(int ID);

    public ProductCatalog getProductCatalogByName(String Name);
    public ProductCatalog addProductCatalog(ProductCatalog productCatalog);

    public ProductCatalog editProductCatalog(ProductCatalog productCatalog);

    public void deleteProductCatalog(ProductCatalog productCatalog);
}
