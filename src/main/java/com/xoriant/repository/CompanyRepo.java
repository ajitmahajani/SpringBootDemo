package com.xoriant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.entity.Company;

/**
 * Company JPA repository
 * @author mahajan_a
 *
 */

public interface CompanyRepo extends JpaRepository<Company, Long> {

}
