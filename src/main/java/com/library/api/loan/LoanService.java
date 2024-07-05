package com.library.api.loan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

	@Autowired
	private LoanRepository loanRepository;

	public Loan save(Loan loan) {
		return loanRepository.save(loan);
	}

	public List<Loan> findByUserId(Long userId) {
		return loanRepository.findByUserId(userId);
	}

}
