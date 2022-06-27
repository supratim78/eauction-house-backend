package com.cts.eauction.microservices.buyer.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.eauction.microservices.buyer.model.Buyer;
import com.cts.eauction.microservices.buyer.repository.BuyerRepository;

@Service
@Transactional
public class BuyerService {

	@Autowired
	private BuyerRepository buyerRepository;

	public Buyer registerBuyer(Buyer buyer) {

		//LOG.info("Entering registerSeller method with " + seller);

		buyer = buyerRepository.save(buyer);

		//LOG.info("Seller is saved in database " + seller);

		return buyer;
	}
	
	public Buyer findBuyerByEmail(String email) {
		Buyer buyer = buyerRepository.findByEmail(email);
		return buyer;
	}
}
