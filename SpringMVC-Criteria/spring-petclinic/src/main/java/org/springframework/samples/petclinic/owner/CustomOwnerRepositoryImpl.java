package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CustomOwnerRepositoryImpl implements CustomOwnerRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<Owner> getData(HashMap<String, Object> conditions) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Owner> query = cb.createQuery(Owner.class);
		Root<Owner> root = query.from(Owner.class);

		List<Predicate> predicates = new ArrayList<>();
		conditions.forEach((field, value) -> {
			switch (field) {
			case "firstName":
				predicates.add(cb.equal(root.get(field),(String) value));
				break;
			case "lastName":
				predicates.add(cb.equal(root.get(field),(String) value));
				break;
			case "address":
				predicates.add(cb.equal(root.get(field),(String) value));
				break;
			case "city":
				predicates.add(cb.equal(root.get(field),(String) value));
				break;
			case "telephone":
				predicates.add(cb.equal(root.get(field), (String) value));
				break;
			}
		});
		query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
		return entityManager.createQuery(query).getResultList();
	}

}
