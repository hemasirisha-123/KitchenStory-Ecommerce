package com.demo.service.impl;

import java.util.List;



import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.KitchenRepository;
import com.demo.exception.BusinessException;
import com.demo.model.Kitchen;
import com.demo.service.KitchenService;

@Service
public class KitchenServiceImpl implements KitchenService {
	@Autowired
	private KitchenRepository dao;

	@Override
	public Kitchen addKitchen(Kitchen kitchen) {

		return dao.save(kitchen);
	}

	@Override
	public Kitchen updateKitchen(Kitchen kitchen) {

		return dao.save(kitchen);
	}

	@Override
	public Kitchen getKitchenById(int id)  throws BusinessException{
		if(id<=0) {
			throw new BusinessException("Entered id "+id+" is invalid");
		}
		Kitchen kitchen=null;
		try {
			kitchen=dao.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("No Kitchen Item found for the id "+id);
		}
		
		return kitchen;
	}

	@Override
	public void deleteKitchenById(int id) {
		dao.deleteById(id);

	}

	@Override
	public List<Kitchen> getAllKitchens() {
		
		return dao.findAll();
	}
	@Override
	public List<Kitchen> getAllKitchensByCost(int cost) {
		
		return dao.findByCost(cost);
	}

	@Override
	public List<Kitchen> getAllKitchensByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

}