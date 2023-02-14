package com.codegym.casemodule4.services;

import com.codegym.casemodule4.entities.Bill;

public interface BillService {
    Iterable<Bill> getAllBills();

    Bill createBill(Bill bill);

    void update(Bill bill);
}
