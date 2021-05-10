package org.springframework.samples.petclinic;

import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.visit.Visit;

public interface CustomRepository extends Repository<Visit, Integer>{

}
