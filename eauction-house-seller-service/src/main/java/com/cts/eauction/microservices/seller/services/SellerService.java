package com.cts.eauction.microservices.seller.services;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.eauction.microservices.seller.model.Seller;
import com.cts.eauction.microservices.seller.repository.SellerRepository;


@Service
@Transactional
public class SellerService {
	
	private static final Logger LOG = LoggerFactory.getLogger(SellerService.class);
	@Autowired
    private SellerRepository sellerRepository;
	

	public Seller registerSeller(Seller seller) {
		
		LOG.info("Entering registerSeller method with " + seller);
		
		seller = sellerRepository.save(seller);
		
		LOG.info("Seller is saved in database " + seller);
		
		return seller;
	}
}
