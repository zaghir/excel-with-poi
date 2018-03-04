package com.zaghir.excelPoi.service;

import java.util.List;

import com.zaghir.excelPoi.dao.CommandeDao;
import com.zaghir.excelPoi.dao.ICommandeDao;
import com.zaghir.excelPoi.entities.Commande;

public class CommandeService implements ICommandeService {

	private ICommandeDao commandeDao = new CommandeDao();
	
	
	public List<Commande> retrieveCommandes() {		
		return commandeDao.retrieveCommandes();
	}

}
