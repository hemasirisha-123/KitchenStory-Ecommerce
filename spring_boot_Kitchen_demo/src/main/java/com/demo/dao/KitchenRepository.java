package com.demo.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Kitchen;


@Repository
public interface KitchenRepository  extends JpaRepository<Kitchen, Integer> {

		public List<Kitchen> findByCost(int cost);
	}
