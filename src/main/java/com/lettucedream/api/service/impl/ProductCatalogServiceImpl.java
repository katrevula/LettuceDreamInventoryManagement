package com.lettucedream.api.service.impl;

import com.lettucedream.api.dao.ProductCatalogRepository;
import com.lettucedream.api.model.Packagetype;
import com.lettucedream.api.model.ProductCatalog;
import com.lettucedream.api.service.ProductCatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {

    public static final Logger logger = LoggerFactory.getLogger(ProductCatalogServiceImpl.class);
    @Autowired
    public ProductCatalogRepository productCatalogRepository;

    @Override
    public List<ProductCatalog> getAllProductCatalogs() {
        return productCatalogRepository.findAll();
    }

    @Override
    public Boolean isProductCatalogExists(ProductCatalog productCatalog) {
        return null;
    }

    @Override
    public Boolean isProductCatalogNameExists(ProductCatalog productCatalog) {
        return null;
    }

    @Override
    public ProductCatalog getProductCatalogByID(int ID) {
        return null;
    }

    @Override
    public ProductCatalog getProductCatalogByName(String Name) {
        logger.info("execute and error product catalog Implementaion");
        return productCatalogRepository.findByProductCatalogName(Name);
    }

    @Override
    public ProductCatalog addProductCatalog(ProductCatalog productCatalog) {
        ProductCatalog saveProductCatalog = productCatalogRepository.saveAndFlush(productCatalog);
        return saveProductCatalog;
    }

    @Override
    public ProductCatalog editProductCatalog(ProductCatalog productCatalog) {
        return productCatalogRepository.saveAndFlush(productCatalog);
    }

    @Override
    public void deleteProductCatalog(ProductCatalog productCatalog) {
        logger.info(productCatalog.getProductcatalog_Id()+"");
        productCatalogRepository.deleteById(productCatalog.getProductcatalog_Id());

    }
}
