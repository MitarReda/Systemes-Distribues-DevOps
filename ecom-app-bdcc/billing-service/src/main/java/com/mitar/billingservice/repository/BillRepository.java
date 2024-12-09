package com.mitar.billingservice.repository;

import com.mitar.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface BillRepository extends JpaRepository<Bill,Long> {
}
