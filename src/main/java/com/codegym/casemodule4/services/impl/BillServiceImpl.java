package com.codegym.casemodule4.services.impl;

import com.codegym.casemodule4.entities.Bill;
import com.codegym.casemodule4.repositories.BillRepository;
import com.codegym.casemodule4.services.BillService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;

@Service
@Transactional
public class BillServiceImpl implements BillService{


    BillRepository billRepository;

    public BillServiceImpl(BillRepository billRepository) {
        super();
        this.billRepository = billRepository;
    }

    @Override
    public Iterable<Bill> getAllBills(){
        return this.billRepository.findAll();
    }

    @Override
    public Bill createBill(Bill bill){
        bill.setDateCreated(Date.valueOf(LocalDate.now()));
        return bill;
    }

    @Override
    public void update(Bill bill){
        this.billRepository.save(bill);
    }
}
