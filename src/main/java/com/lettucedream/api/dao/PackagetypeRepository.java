package com.lettucedream.api.dao;


import com.lettucedream.api.model.Packagetype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PackagetypeRepository extends JpaRepository<Packagetype, Integer> {

    @Query("select t from Packagetype t where t.packagetype_Id = :id")
    Packagetype findByPackagetypeId(@Param("id") int id);

    @Query("select t from Packagetype t where (t.packagetype_name = :name)")
    Packagetype findByPackagetypeName(@Param("name") String name);




    @Modifying
    @Query("UPDATE Packagetype t SET t.packagetype_name = :name,t.weight = :weight,t.count = :count WHERE t.packagetype_Id = :id")
    Packagetype editPackagetype(@Param("id") int id,@Param("name") String name, @Param("weight") double weight, @Param("count") int count);

}
