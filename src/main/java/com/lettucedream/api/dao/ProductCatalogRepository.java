package com.lettucedream.api.dao;

import com.lettucedream.api.controller.ProductCatalogController;
import com.lettucedream.api.model.ProductCatalog;
import com.lettucedream.api.model.ProductCatalog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductCatalogRepository extends JpaRepository<ProductCatalog,Integer> {

    @Query("select t from ProductCatalog t where t.productcatalog_Id = :id")
    ProductCatalog findByProductCatalogId(@Param("id") int id);

    @Query("select t from ProductCatalog t where (t.productcatalog_Name = :name)")
    ProductCatalog findByProductCatalogName(@Param("name") String name);

//    @Query("select t from ProductCatalog t")
//    List<ProductCatalog> findAllbyProductCatalod();

}
