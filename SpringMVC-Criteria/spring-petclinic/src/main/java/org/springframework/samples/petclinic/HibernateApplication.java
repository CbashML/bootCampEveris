package org.springframework.samples.petclinic;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.samples.petclinic.owner.Account;
import org.springframework.samples.petclinic.owner.Bill;
import org.springframework.samples.petclinic.owner.BillRepository;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetClinicService;
import org.springframework.samples.petclinic.owner.PetRepository;
import org.springframework.samples.petclinic.vet.Specialty;
import org.springframework.samples.petclinic.vet.SpecialtyRepository;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.samples.petclinic.vet.VetRepository;
import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.samples.petclinic.visit.VisitRepository;

@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {
	
	@Autowired 
	private BillRepository billRepository;
	
	@Autowired
	private VisitRepository visitRepository;
	@Autowired
	private PetRepository petRepository;
	@Autowired
	private VetRepository vetRepository;
	@Autowired
	private SpecialtyRepository specialtyRepository;
	@Autowired
	private OwnerRepository ownerRepository;
	
	@Autowired
	private PetClinicService petClinicService;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(HibernateApplication.class, args);
	}
	
	@Override
	@Transactional
	public void run(String... args) {
		/*System.out.println("\n\nPruebas de Hibernate\n=====================\n\n");
		Pet p = petRepository.findById(8);
		List<Visit> visits = visitRepository.findByPetId(p.getId());
		for(Visit v : visits) {
			System.out.println(v.toString());
		}*/
		
		/***
		 * Crear aquí las facturas y enlazarlas, por último, volver a mostrar dichas visitas
		 */
		/*Bill b = new Bill();
		b.setIdNumber(1234567890);
		b.setMoney(1.0);
		b.setPaymentDate(new Date());
		List<Bill> listaFacturas = new ArrayList<Bill>();
		listaFacturas.add(b);
		listaFacturas = billRepository.save(listaFacturas);
		visits.get(0).setBill(b);
		visitRepository.save(visits.get(0));

		p = petRepository.findById(8);
		visits = visitRepository.findByPetId(p.getId());
		for(Visit v : visits) {
			System.out.println(v.toString());
		}*/
			
		Vet vet = new Vet();
		vet.setFirstName("Luis");
		vet.setLastName("López");
		vet.setId(7);
		vetRepository.save(vet);
		Vet vetfind = vetRepository.findById(7);
		System.out.println(vetfind.getFirstName() + " " + vetfind.getLastName());
		Specialty specialty = specialtyRepository.findOne(1);
		vetfind.addSpecialty(specialty);
		vetRepository.save(vetfind);
		
		for (Vet v : vetRepository.findAll()) {
			System.out.println("Vet:" + v.getFirstName() + " " + v.getLastName());
		}
		
		System.out.println("Buscamos por lastname");
		for(Vet v: vetRepository.findByLastName("Carter")) {
			System.out.println(v.getFirstName() + " " + v.getLastName());
		}
		
		System.out.println("Buscamos por firstname y lastname");
		for(Vet v: vetRepository.findByFirstNameAndLastName("Helen","Leary")) {
			System.out.println(v.getFirstName() + " " + v.getLastName());
		}
		
		System.out.println("Buscamos por firstname o lastname");
		for(Vet v: vetRepository.findByFirstNameOrLastName("Henry","Douglas")) {
			System.out.println(v.getFirstName() + " " + v.getLastName());
		}
		
		System.out.println("Buscamos veterinarios de una especialidad");
		for(Vet v: vetRepository.findBySpecialtyName("radiology")) {
			System.out.println(v.getFirstName() + " " + v.getLastName());
		}
		
		
		System.out.println("Obtener owners según contengan nombre o apellido");
		for(Owner o: ownerRepository.findByFirstNameContainingOrLastNameContaining("Je", "co")) {
			System.out.println(o.getFirstName() + " " + o.getLastName());
		}
		
		System.out.println("Obtener owners según contengan nombre o apellido con query");
		for(Owner o: ownerRepository.searchOwner("Je")) {
			System.out.println(o.getFirstName() + " " + o.getLastName());
		}
		
		System.out.println("Obtener owners ordenador por apellido");
		for(Owner o: ownerRepository.findByOrderByLastName()) {
			System.out.println(o.getFirstName() + " " + o.getLastName());
		}
		
		System.out.println("Mostrar mascotas nacidas en 2010");
		for(Pet p: petClinicService.findPetsByBirthYear(2010)) {
			System.out.println(p.getName());
		}
		
		/*Visit visit = new Visit();
		visit.setDate(new Date());
		visit.setDescription("vacuna");
		visit.setPetId(3);
		Visit visit2 = new Visit();
		visit2.setDate(new Date());
		visit2.setDescription("revisión");
		visit2.setPetId(3);
		Visit visit3 = new Visit();
		visit3.setDate(new Date());
		visit3.setDescription("operación");
		visit3.setPetId(3);
		visitRepository.save(visit);
		visitRepository.save(visit2);
		visitRepository.save(visit3);*/
		
		
		System.out.println("Mostrar visitas de una mascota");
		for(Visit v: petClinicService.findPetVisitsByPetId(3)) {
			System.out.println(v.getDescription());
		}
		
		System.out.println("Obtener 4 visitas mas recientes");
		for(Visit v: petClinicService.findLastVisits()) {
			System.out.println(v.getDescription());
		}
		
		System.out.println("Obtener visitas con getData");
		
		HashMap<String, Object> criterios = new HashMap<String, Object>();
        Date fecha = new Date().from(LocalDate.of(2010, 2, 2).atStartOfDay(ZoneId.of("Europe/Madrid")).toInstant());
        criterios.put("date", fecha);
        //criterios.put("petId", 3);
        criterios.put("description", "rabies");
       
        for(Visit v: petClinicService.getData(criterios)) {
            if(v.getBill() == null) {
                System.out.println(v.getDescription() + " no BILL NUMBER");
            }else {
                System.out.println(v.getDescription() +  " " + v.getBill().getIdNumber());
            }
        }
        
        System.out.println("GetData con Pets");
        
        HashMap<String, Object> criteriosPets = new HashMap<String, Object>();
        Date fecha2 = new Date().from(LocalDate.of(2009, 2, 2).atStartOfDay(ZoneId.of("Europe/Madrid")).toInstant());
        criteriosPets.put("birthDate", fecha2);
        criteriosPets.put("name","Leo");
        criteriosPets.put("owner", "George");
        
        for(Pet p: petClinicService.getPetData(criteriosPets)) {
            System.out.println(p.getName());
            System.out.println(p.getOwner().getFirstName());
        }
        
System.out.println("GetData con Owners");
        
        HashMap<String, Object> criteriosOwners = new HashMap<String, Object>();
        criteriosOwners.put("firstName","George");
        criteriosOwners.put("lastName","Franklin");
        criteriosOwners.put("address","110 W. Liberty St.");
        criteriosOwners.put("city","Madison");
        criteriosOwners.put("telephone","6085551023");
        
        for(Owner o: petClinicService.getOwnerData(criteriosOwners)) {
            System.out.println(o.getFirstName());
            System.out.println(o.getLastName());
            System.out.println(o.getAddress());
            System.out.println(o.getCity());
            System.out.println(o.getTelephone());
        }
        
        System.out.println("GetData Bills");
        
        /*Bill bill = new Bill();
        bill.setIdNumber(1);
        bill.setMoney(15.42d);
        bill.setPaymentDate(new Date());
        billRepository.save(bill);*/
        
        HashMap<String, Object> criteriosBills = new HashMap<String, Object>();
        Date fecha3 = new Date().from(LocalDate.of(2020, 2, 2).atStartOfDay(ZoneId.of("Europe/Madrid")).toInstant());
        criteriosBills.put("paymentDate",fecha3);
        criteriosBills.put("money",15.42d);
        criteriosBills.put("idNumber",1);
        
        for(Bill b: petClinicService.getBillData(criteriosBills)) {
            System.out.println(b.getIdNumber());
            System.out.println(b.getMoney());
        }
		
		
		
	}
}
