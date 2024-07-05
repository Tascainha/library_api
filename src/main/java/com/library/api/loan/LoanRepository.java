package com.library.api.loan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
	@Query("SELECT l FROM Loan l WHERE l.userId = :userId")
	List<Loan> findByUserId(Long userId);
}
