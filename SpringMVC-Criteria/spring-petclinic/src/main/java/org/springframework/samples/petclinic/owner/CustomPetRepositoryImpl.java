package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.samples.petclinic.visit.Visit;

public class CustomPetRepositoryImpl implements CustomPetRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Pet> getData(HashMap<String, Object> conditions) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Pet> query = cb.createQuery(Pet.class);
		Root<Pet> root = query.from(Pet.class);
		root.join("owner", JoinType.LEFT);
		List<Predicate> predicates = new ArrayList<>();
		conditions.forEach((field, value) -> {
			switch (field) {
			case "birthDate":
				predicates.add(cb.greaterThan(root.<Date>get(field), (Date) value));
				break;
			case "name":
				predicates.add(cb.equal(root.get(field), (String) value));
				break;
			}
		});
		query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
		List<Pet> pets = entityManager.createQuery(query).getResultList();
		List<Pet> petsFiltradas = new ArrayList<Pet>();
		for (Pet p : pets) {
			if (p.getOwner().getFirstName().equals(conditions.get("owner"))) {
				petsFiltradas.add(p);
			}
		}

		return petsFiltradas;
	}
}
