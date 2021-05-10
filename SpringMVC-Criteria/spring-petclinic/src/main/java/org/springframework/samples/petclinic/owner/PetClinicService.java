package org.springframework.samples.petclinic.owner;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.CustomRepositoryImpl;
import org.springframework.samples.petclinic.vet.SpecialtyRepository;
import org.springframework.samples.petclinic.vet.VetRepository;
import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.samples.petclinic.visit.VisitRepository;
import org.springframework.stereotype.Service;

@Service
public class PetClinicService implements IPetClinicService {
	
	@Autowired
	private VisitRepository visitRepository;
	
	@Autowired
	private VetRepository vetRepository;
	
	@Autowired
	private SpecialtyRepository specRepository;
	
	@Autowired
	private PetRepository petRepository;
	
	@Autowired
	private CustomRepositoryImpl customRepository;
	
	@Autowired
	private CustomPetRepositoryImpl customPetRepository;
	
	@Autowired
	private CustomOwnerRepositoryImpl customOwnerRepository;
	
	@Autowired
	private CustomBillRepositoryImpl customBillRepository;

	@Override
	public List<Pet> findPetsByBirthYear(int year) {
		// TODO Auto-generated method stub
		return petRepository.findByBirthDate(year);
	}

	@Override
	public List<Visit> findPetVisitsByPetId(Integer petId) {
		// TODO Auto-generated method stub
		return visitRepository.findByPetId(petId);
	}

	@Override
	public List<Visit> findLastVisits() {
		// TODO Auto-generated method stub
		return visitRepository.findTop4ByOrderByDateDesc();
	}

	@Override
	public List<Visit> getData(HashMap<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return customRepository.getData(hashmap);
	}

	@Override
	public List<Pet> getPetData(HashMap<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return customPetRepository.getData(hashmap);
	}

	@Override
	public List<Owner> getOwnerData(HashMap<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return customOwnerRepository.getData(hashmap);
	}

	@Override
	public List<Bill> getBillData(HashMap<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return customBillRepository.getData(hashmap);
	}

}
