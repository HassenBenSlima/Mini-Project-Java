package com.cp.metier;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cp.dao.CompteRepository;
import com.cp.dao.EmployeRepository;
import com.cp.dao.OperationRepository;
import com.cp.entities.Compte;
import com.cp.entities.Employe;
import com.cp.entities.Operation;
import com.cp.entities.Retrait;
import com.cp.entities.Versement;

@Service
public class OperationMetierImpl implements OperationMetier {

	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private EmployeRepository employeRepository;
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Transactional
	@Override
	public boolean verser(String CodeCpte, double montant,Long codeEmp) {

		Compte cp =compteRepository.findOne(CodeCpte);
		Employe e=employeRepository.findOne(codeEmp);
		Operation o =new Versement();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(e);
		operationRepository.save(o);
		
		cp.setSolde(cp.getSolde()+montant);
		return true;
	}

	@Transactional
	@Override
	public boolean retirer(String code, double montant,Long codeEmp) {
		Compte cp =compteRepository.findOne(code);
		Employe e=employeRepository.findOne(codeEmp);
		Operation o =new Versement();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(e);
		operationRepository.save(o);
		
		cp.setSolde(cp.getSolde()-montant);
		return true;
			}

	@Transactional
	@Override
	public boolean virement(String cp1, String cp2, double montant,Long codeEmp) {

		retirer(cp1, montant,codeEmp);
		verser(cp2, montant,codeEmp);
 	return true;
	}

	/*@Override
	public Page<Operation> listOperation(String codeCpte, int page, int size) {
	
		return null;
	}*/

	public PageOperation getOperations(String codeCompte, int page, int size) {
		 Page<Operation> ops =operationRepository.getOperations(codeCompte,
				new PageRequest(page, size , new Sort(Direction.DESC, "dateOperation")));//on peut ajouter un objet pour le tri de type Sort   
		PageOperation pOp =new PageOperation();
				pOp.setOperations(ops.getContent());
				pOp.setNombreOperations(ops.getNumberOfElements());
				pOp.setPage(ops.getNumber());
				pOp.setTotalPages(ops.getTotalPages());
				
				return pOp;	
		
	}

	
}
