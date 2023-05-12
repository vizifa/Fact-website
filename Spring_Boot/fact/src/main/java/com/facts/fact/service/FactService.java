package com.facts.fact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.facts.fact.domain.*;
import com.facts.fact.repository.*;

@Service
public class FactService {
	
	@Autowired
    private FactRepository repo;
	
	public List<Fact> listAll() {
        return repo.findAll();
    }
     
    public void save(Fact std) {
        repo.save(std);
    }
     
    public Fact get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }

}