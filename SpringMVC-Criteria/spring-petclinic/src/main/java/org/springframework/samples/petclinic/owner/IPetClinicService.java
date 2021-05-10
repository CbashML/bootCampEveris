package org.springframework.samples.petclinic.owner;

import java.util.HashMap;
import java.util.List;

import org.springframework.samples.petclinic.visit.Visit;

public interface IPetClinicService {
	
	List<Pet> findPetsByBirthYear(int year);
	
	List<Visit> findPetVisitsByPetId(Integer petId);
	
	List<Visit> findLastVisits();
	
	List<Visit> getData(HashMap<String, Object> hashmap);
	
	List<Pet> getPetData(HashMap<String, Object> hashmap);
	
	List<Owner> getOwnerData(HashMap<String, Object> hashmap);
	
	List<Bill> getBillData(HashMap<String, Object> hashmap);
}
