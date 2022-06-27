package com.cts.eauction.microservices.seller.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.eauction.microservices.seller.CategoryEnum;
import com.cts.eauction.microservices.seller.client.ListingClient;
import com.cts.eauction.microservices.seller.client.ProductClient;
import com.cts.eauction.microservices.seller.exception.EauctionHouseException;
import com.cts.eauction.microservices.seller.exception.RequestNotValidException;
import com.cts.eauction.microservices.seller.model.AddNewProductRequest;
import com.cts.eauction.microservices.seller.model.Bid;
import com.cts.eauction.microservices.seller.model.ProductDetails;
import com.cts.eauction.microservices.seller.model.ProductRequest;
import com.cts.eauction.microservices.seller.model.ProductResponse;
import com.cts.eauction.microservices.seller.model.Seller;
import com.cts.eauction.microservices.seller.services.SellerService;

@RestController
@RequestMapping("/e-auction/api/v1/seller")
public class SellerController {

	private static final Logger LOG = LoggerFactory.getLogger(SellerController.class);

	@Autowired
	private SellerService service;

	@Autowired
	private ProductClient productClient;
	
	@Autowired
	private ListingClient listingClient;

	@PostMapping(path = "/add-product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Seller addNewProduct(@RequestBody @Valid AddNewProductRequest request) throws EauctionHouseException{
		LOG.info("Executing addNewProduct method with " + request);
		
		validateAddProductRequest(request);
		
		Seller seller = new Seller(request.getFirstName(), request.getLastName(), request.getAddress(),
				request.getCity(), request.getState(), request.getPin(), request.getPhone(), request.getEmail());
		seller = service.registerSeller(seller);
		ProductRequest productRequest = new ProductRequest(request.getProductName(), request.getShortDescription(),
				request.getDetailedDescription(), request.getDetailedDescription(), request.getStartingPrice(),
				request.getBidEndDate(), seller.getId());

		ProductResponse response = productClient.addNewProduct(productRequest);

		return seller;
	}

	@DeleteMapping("/delete/{productId}")
	public void removeProductFromAuction(@PathVariable Integer productId) throws RequestNotValidException {
		LOG.info("Executing removeProductFromAuction method with productId " + productId);
		validateDeleteProduct(productId);
		productClient.deleteProduct(productId);
	}
	
	private boolean validateAddProductRequest(AddNewProductRequest request) throws RequestNotValidException{
		boolean flag = true; 
		
		LocalDate localDateNow = LocalDate.now(ZoneId.systemDefault());

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate bidEndDate = LocalDate.parse(request.getBidEndDate(), formatter);

		if (!bidEndDate.isAfter(localDateNow)) {
			throw new RequestNotValidException("Bid End Date must be some date in future in format dd/MM/yyyy");
		}
		
		if(!(CategoryEnum.ORNAMENTS.getType().equalsIgnoreCase(request.getCategory()) || 
				CategoryEnum.PAINTING.getType().equalsIgnoreCase(request.getCategory()) || 
				CategoryEnum.SCULPTOR.getType().equalsIgnoreCase(request.getCategory()))) {
			throw new RequestNotValidException("Supported category is Painting,Sculptor or Ornament");
		}
		
		return flag; 
	}
	
	private boolean validateDeleteProduct(Integer productId) throws RequestNotValidException{
		boolean flag = true;
		ProductDetails ProductDetails = listingClient.showProductDetail(productId); 
		LocalDate localDateNow = LocalDate.now(ZoneId.systemDefault());
		if(localDateNow.isAfter(ProductDetails.getBidEndDate())) {
			throw new RequestNotValidException("Sorry! You cannot delete a product whose Bid End Date is over");
		}
		
		List<Bid> bids = listingClient.showBidDetails(productId);
		if(bids!= null && bids.size() > 0) {
			throw new RequestNotValidException("Sorry! You cannot delete the product as there is bids against the same");
		}
		
		
		return flag;
	}

}
