package com.zaghir.excelPoi.dao;

import java.util.List;

import com.zaghir.excelPoi.entities.Commande;

public interface ICommandeDao {
	
	public List<Commande> retrieveCommandes();

}
