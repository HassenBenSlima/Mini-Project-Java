 package com.cp.metier;

import org.springframework.data.domain.Page;

import com.cp.entities.Operation;

public interface OperationMetier {
	
	  public boolean retirer(String CodeCpte, double montant, Long codeEmp);
	  public boolean virement(String cp1,String cp2,double montant,Long codeEmp); 
	//  public Page<Operation> listOperation(String codeCpte,int page, int size );//page =le numero de la page /size=nombre d'operation dans chaque page
      public PageOperation getOperations(String codeCompte,int page, int size) ;
	boolean verser(String CodeCpte, double montant, Long codeEmp);
	  
}
