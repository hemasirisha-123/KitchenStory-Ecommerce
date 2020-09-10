package com.demo.service;

import java.util.List;


import com.demo.exception.BusinessException;
import com.demo.model.Kitchen;

public interface KitchenService {
 
	public Kitchen addKitchen(Kitchen kitchen);
	public Kitchen updateKitchen(Kitchen kitchen);
	public Kitchen getKitchenById(int id) throws BusinessException;
	public void deleteKitchenById(int id);
	public List<Kitchen> getAllKitchens();
	public List<Kitchen> getAllKitchensByCost(int cost);
	public List<Kitchen> getAllKitchensByCategory(String category);
}

