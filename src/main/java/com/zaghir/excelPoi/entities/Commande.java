package com.zaghir.excelPoi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Commande implements Serializable{

	private Integer id ;
	private Date dateCommande;
	private List<DetailCommande> detailCommand = new ArrayList()  ;
	private String statutCommande ;
	
	public Commande(){
		
	}
	public Commande(Integer id, Date dateCommande, List<DetailCommande> detailCommand, String statutCommande) {
		this.id = id;
		this.dateCommande = dateCommande;
		this.detailCommand = detailCommand;
		this.statutCommande = statutCommande;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	public List<DetailCommande> getDetailCommand() {
		return detailCommand;
	}
	public void setDetailCommand(List<DetailCommande> detailCommand) {
		this.detailCommand = detailCommand;
	}
	public String getStatutCommande() {
		return statutCommande;
	}
	public void setStatutCommande(String statutCommande) {
		this.statutCommande = statutCommande;
	}
	@Override
	public String toString() {
		return "Commande [id=" + id + ", dateCommande=" + dateCommande + ", detailCommand=" + detailCommand
				+ ", statutCommande=" + statutCommande + "]";
	}
	
	
	
}
