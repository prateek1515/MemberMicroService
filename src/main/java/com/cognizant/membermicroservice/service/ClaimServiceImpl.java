package com.cognizant.membermicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.membermicroservice.dto.ViewBillsDTO;
import com.cognizant.membermicroservice.exception.RecordNotFoundException;
import com.cognizant.membermicroservice.model.MemberPremium;
import com.cognizant.membermicroservice.repository.PremiumRepository;

@Service
/**
 * This class is used to load the bill details from the database.
 *
 */
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	private PremiumRepository premiumRepository;

	@Autowired
	private ViewBillsDTO viewBillsDto;

	/**
	 * 
	 * @param memberId
	 * @param policyId
	 * @return viewBillsDto
	 * @throws RecordNotFoundException
	 */

	@Override
	public ViewBillsDTO viewBills(int memberId, int policyId) throws RecordNotFoundException {
		MemberPremium premium = premiumRepository.getById(memberId);

		if (premium.getMemberId() == memberId && premium.getPolicyId() == policyId) {
			viewBillsDto.setPaidDate(premium.getPaidDate());
			viewBillsDto.setPremium(premium.getPremium());
			viewBillsDto.setLatePayment(premium.isLatePayment());
			viewBillsDto.setLatePaymentCharges(premium.getLatePaymentCharges());
			viewBillsDto.setDueDate(premium.getDueDate());
		} else {
			throw new RecordNotFoundException("Data Not Found!!!");
		}
		return viewBillsDto;

	}
}
