package com.tmy.onetoone.controller;

import com.tmy.onetoone.jpa.ECRParams;
import com.tmy.onetoone.jpa.Poi;
import com.tmy.onetoone.jpa.PoiRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloController {

    @Autowired
    private PoiRepository poiRepository;

    @RequestMapping("/")
    public String index() {

        Poi poi = new Poi();
        poi.setName(RandomStringUtils.randomAlphanumeric(5, 10));
        poi.setEnabled(1L);
        ECRParams ecrParams = new ECRParams();

        ecrParams.setName(RandomStringUtils.randomAlphanumeric(5, 10));
        ecrParams.setEnabled(0L);
        poi.setEcrParams(ecrParams);

        poiRepository.save(poi);

        Optional<Poi> result = poiRepository.findById(20L);

        System.out.println(result);
        return "Greetings from Spring Boot!";
    }

}
