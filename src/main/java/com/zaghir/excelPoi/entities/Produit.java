package com.zaghir.excelPoi.entities;

import java.io.Serializable;

public class Produit implements Serializable {
	
	private Integer idProduit ;
	private String nomProduit ;
	private Double prixUnitaire;
	
	public Produit(){
		
	}
	public Produit(Integer idProduit, String nomProduit, Double prixUnitaire) {		
		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
		this.prixUnitaire = prixUnitaire;
	}
	public Integer getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Integer idProduit) {
		this.idProduit = idProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public Double getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(Double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", prixUnitaire=" + prixUnitaire
				+ "]";
	}
	
	

}
