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

public class CustomBillRepositoryImpl implements CustomBillRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<Bill> getData(HashMap<String, Object> conditions) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Bill> query = cb.createQuery(Bill.class);
		Root<Bill> root = query.from(Bill.class);

		List<Predicate> predicates = new ArrayList<>();
		conditions.forEach((field, value) -> {
			switch (field) {
			case "paymentDate":
				predicates.add(cb.greaterThan(root.<Date>get(field), (Date) value));
				break;
			case "money":
				predicates.add(cb.equal(root.get(field),(Double) value));
				break;
			case "idNumber":
				predicates.add(cb.equal(root.get(field),(Integer) value));
				break;
			}
		});
		query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
		return entityManager.createQuery(query).getResultList();
	}

}
