package com.facts.fact.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fact_table")
public class Fact {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
	@Column(name = "factdata")
    private String factdata;
	@Column(name = "facttype")
    private String facttype;
	
	public Fact() {

	}
	public Fact(Long id, String factdata, String facttype) {
		this.id = id;
		this.factdata = factdata;
		this.facttype = facttype;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFactData() {
		return factdata;
	}
	public void setFactData(String factdata) {
		this.factdata = factdata;
	}
	public String getFactType() {
		return facttype;
	}
	public void setFactType(String facttype) {
		this.facttype = facttype;
	}

}