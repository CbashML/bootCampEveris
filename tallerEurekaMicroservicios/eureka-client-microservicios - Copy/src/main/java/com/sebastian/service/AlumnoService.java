package com.sebastian.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.sebastian.domain.Alumno;
import com.sebastian.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    AlumnoRepository alumnoRepository;

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;


    public Mono<Alumno> searchById(String id){
       return alumnoRepository.findById(id);
    }

    public Mono<Alumno> createAlumno(Alumno a){
        return alumnoRepository.save(a);
    }

//    public Flux<Alumno> searchAll(){
//        return alumnoRepository.findAll();
//    }



    public List<Alumno> searchAll(){
        RestTemplate restTemplate = new RestTemplate();

        Application application =
                eurekaClient.getApplication("client");
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String hostname = instanceInfo.getHostName();
        int port = instanceInfo.getPort();
        String uri =  "http://" + hostname + ":" + port + "/api/alumnos"; //TODO
        Alumno[] alumnos = restTemplate.getForObject(uri, Alumno[].class);
        return Arrays.asList(alumnos);
    }


}
