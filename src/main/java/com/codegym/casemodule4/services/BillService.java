package com.codegym.casemodule4.services;

import com.codegym.casemodule4.entities.Bill;
import com.codegym.casemodule4.entities.BillDetail;

import java.util.List;


public interface BillService {
   Iterable<BillDetail> getAllBillDetail();

    List<BillDetail> getBillDetailById(Long id);

    List<BillDetail> getBillDetailByUserId(Long userId);

    Bill createBill(Bill bill);
}


