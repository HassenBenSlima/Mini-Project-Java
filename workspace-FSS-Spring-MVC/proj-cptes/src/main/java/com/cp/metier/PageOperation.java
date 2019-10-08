package com.cp.metier;

import java.io.Serializable;
import java.util.List;

import com.cp.entities.Operation;

public class PageOperation implements Serializable {

	private List<Operation>operations;
	private int page ;
	private int nombreOperations;
	private int totalOperation;
	private int totalPages;
	
	
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreOperations() {
		return nombreOperations;
	}
	public void setNombreOperations(int nombreOperations) {
		this.nombreOperations = nombreOperations;
	}
	public int getTotalOperation() {
		return totalOperation;
	}
	public void setTotalOperation(int totalOperation) {
		this.totalOperation = totalOperation;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	} 
	
	
}
