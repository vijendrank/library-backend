package com.vk.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vk.library.model.ReturnHistory;
import com.vk.library.repository.ReturnHistoryRepository;

@Service
@Transactional
public class ReturnHistoryService {

	@Autowired
	public ReturnHistoryRepository returnHistoryRepository;

	public ReturnHistory addReturnHistory(ReturnHistory returnHistory) {
		return returnHistoryRepository.save(returnHistory);
	}

	public ReturnHistory updateReturn(ReturnHistory returnHistory) {
		return returnHistoryRepository.save(returnHistory);
	}

	public void deleteReturn(ReturnHistory returnHistory) {
		returnHistoryRepository.delete(returnHistory);
	}

	public void deleteReturnById(Long id) {
		returnHistoryRepository.deleteById(id);
	}

	public List<ReturnHistory> getAllReturnHistory() {
		List<ReturnHistory> all = new ArrayList<ReturnHistory>();
		for (ReturnHistory returnHistory : returnHistoryRepository.findAll()) {
			all.add(returnHistory);
		}
		return all;
	}

	public ReturnHistory findReservationById(Long id) {
		Optional<ReturnHistory> returnHistory = returnHistoryRepository.findById(id);
		return returnHistory.get();
	}
}
