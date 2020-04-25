package com.lettucedream.api.dao;

import com.lettucedream.api.model.Bay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BayRepository extends JpaRepository<Bay, Integer> {

    @Query("select t from Bay t where t.bay_id = :id")
    Bay findByBayId(@Param("id") int id);


    @Query("select t from Bay t where (t.bay_Name = :name)")
    Bay findByName(@Param("name") char name);
}