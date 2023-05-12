package com.facts.fact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.facts.fact.domain.*;


@Repository
public interface FactRepository extends JpaRepository<Fact, Long> {
	
}