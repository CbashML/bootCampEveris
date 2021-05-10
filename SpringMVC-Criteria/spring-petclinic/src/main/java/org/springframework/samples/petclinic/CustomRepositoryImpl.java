package org.springframework.samples.petclinic;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.samples.petclinic.visit.Visit;

public class CustomRepositoryImpl implements CustomRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Visit> getData(HashMap<String, Object> conditions) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Visit> query = cb.createQuery(Visit.class);
		Root<Visit> root = query.from(Visit.class);

		List<Predicate> predicates = new ArrayList<>();
		conditions.forEach((field, value) -> {
			switch (field) {
			case "date":
				predicates.add(cb.greaterThan(root.<Date>get(field), (Date) value));
				break;
			case "description":
				predicates.add(cb.like(root.get(field), "%" + (String) value + "%"));
				break;
			case "petId":
				predicates.add(cb.equal(root.get(field), (Integer) value));
				break;
			/*
			 * case "created": String dateCondition=(String)
			 * conditions.get("dateCondition"); switch (dateCondition) { case GREATER_THAN:
			 * predicates.add(cb.greaterThan(root.<Date>get(field),(Date)value)); break;
			 * case LESS_THAN:
			 * predicates.add(cb.lessThan(root.<Date>get(field),(Date)value)); break; case
			 * EQUAL: predicates.add(cb.equal(root.<Date>get(field),(Date)value)); break; }
			 * break;
			 */
			}
		});
		query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
		return entityManager.createQuery(query).getResultList();
	}

}
