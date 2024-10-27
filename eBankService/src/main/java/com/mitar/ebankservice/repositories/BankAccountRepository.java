package com.mitar.ebankservice.repositories;

import com.mitar.ebankservice.entities.BankAccount;
import com.mitar.ebankservice.enums.AccountType;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
 @RestResource(path = "/byType")
 List<BankAccount> findByType(@Param("t") AccountType type);
}
