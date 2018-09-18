package com.tmy.onetoone.jpa;

import org.springframework.data.repository.CrudRepository;

import javax.annotation.Resource;

@Resource
public interface PoiRepository extends CrudRepository<Poi, Long> {

}
