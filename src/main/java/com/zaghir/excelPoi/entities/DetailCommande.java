package com.zaghir.excelPoi.entities;

import java.io.Serializable;

public class DetailCommande implements Serializable{

	private Produit produit;
	private Integer quantite;
	private Double montant ;
	
	public DetailCommande(){
		
	}
	public DetailCommande(Produit produit, Integer quantite) {	
		this.produit = produit;
		this.quantite = quantite;
		this.montant = produit.getPrixUnitaire() * quantite;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Integer getQuantite() {
		return quantite;
	}
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	@Override
	public String toString() {
		return "DetailCommande [produit=" + produit + ", quantite=" + quantite + ", montant=" + montant + "]";
	}	
	
	
	
	
}
