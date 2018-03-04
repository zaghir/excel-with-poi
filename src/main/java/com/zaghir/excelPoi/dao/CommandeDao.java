package com.zaghir.excelPoi.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zaghir.excelPoi.entities.Commande;
import com.zaghir.excelPoi.entities.DetailCommande;
import com.zaghir.excelPoi.entities.Produit;


public class CommandeDao  implements ICommandeDao{

	public List<Commande> retrieveCommandes() {
		Produit tomate = new Produit(1 , "Tomate" , 1.2);
		Produit poire = new Produit(2 , "Poire" , 2.5);
		Produit banane = new Produit(3 , "Banane" , 1.0);
		Produit orange = new Produit(4 , "Orange" , 1.5);
		
		
		List<DetailCommande> listDetailCommande = new ArrayList();
		listDetailCommande.add(new DetailCommande( tomate , 10));
		listDetailCommande.add(new DetailCommande( poire , 10));
		listDetailCommande.add(new DetailCommande( banane , 10));
		listDetailCommande.add(new DetailCommande( orange , 10));		
				
		List<Commande> commandes = new ArrayList();
		commandes.add(new Commande(1 , new Date(), listDetailCommande, "En prepration" ));
		commandes.add(new Commande(2 , new Date(), listDetailCommande, "En Expedition" ));
		
		return commandes;
	}
	
	

}
