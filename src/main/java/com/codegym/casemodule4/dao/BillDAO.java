package com.codegym.casemodule4.dao;

import java.util.Date;
import java.util.List;
import java.util.UUID;


import com.codegym.casemodule4.entities.Bill;
import com.codegym.casemodule4.entities.BillDetail;
import com.codegym.casemodule4.entities.Product;
import com.codegym.casemodule4.models.*;
import com.codegym.casemodule4.pagination.PaginationResult;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class BillDAO {

    @Autowired
    private SessionFactory sessionFactory;


//    @Autowired
//    private ProductDAO productDAO;

    private int getMaxBillNum() {
        String sql = "Select max(o.billNum) from " + Bill.class.getName() + " o ";
        Session session = this.sessionFactory.getCurrentSession();
        Query<Integer> query = session.createQuery(sql, Integer.class);
        Integer value = query.getSingleResult();
        if (value == null) {
            return 0;
        }
        return value;
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveBill(CartInfo cartInfo) {
        Session session = this.sessionFactory.getCurrentSession();

        int billNum = this.getMaxBillNum() + 1;
        Bill bill = new Bill();

        bill.setId(Long.valueOf(UUID.randomUUID().toString()));
        bill.setBillNum(billNum);
        bill.setBillDate(new Date());
        bill.setAmount(cartInfo.getAmountTotal());

        CustomerInfo customerInfo = cartInfo.getCustomerInfo();
        bill.setCustomerName(customerInfo.getName());
        bill.setCustomerEmail(customerInfo.getEmail());
        bill.setCustomerPhone(customerInfo.getPhone());
        bill.setCustomerAddress(customerInfo.getAddress());

        session.persist(bill);

        List<CartLineInfo> lines = cartInfo.getCartLines();

        for (CartLineInfo line : lines) {
            BillDetail detail = new BillDetail();
            detail.setId(Long.valueOf(UUID.randomUUID().toString()));
            detail.setBill(bill);
            detail.setAmount(line.getAmount());
            detail.setPrice(line.getProductInfo().getPrice());
            detail.setQuanity(line.getQuantity());

            String code = line.getProductInfo().getCode();
//            Product product = this.productDAO.findProduct(code);
//            detail.setProduct(product);

            session.persist(detail);
        }

        // Order Number!
//        cartInfo.setBillNum(billNum);
        // Flush
        session.flush();
    }

    // @page = 1, 2, ...
    public PaginationResult<BillInfo> listBillInfo(int page, int maxResult, int maxNavigationPage) {
        String sql = "Select new " + BillInfo.class.getName()//
                + "(ord.id, ord.orderDate, ord.orderNum, ord.amount, "
                + " ord.customerName, ord.customerAddress, ord.customerEmail, ord.customerPhone) " + " from "
                + Bill.class.getName() + " ord "//
                + " order by ord.orderNum desc";

        Session session = this.sessionFactory.getCurrentSession();
        Query<BillInfo> query = session.createQuery(sql, BillInfo.class);
        return new PaginationResult<BillInfo>(query, page, maxResult, maxNavigationPage);
    }

    public Bill findBill(String billId) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.find(Bill.class, billId);
    }

    public BillInfo getBillInfo(String billId) {
        Bill bill = this.findBill(billId);
        if (bill == null) {
            return null;
        }
        return new BillInfo(String.valueOf(bill.getId()), bill.getBillDate(), //
                bill.getBillNum(), bill.getAmount(), bill.getCustomerName(), //
                bill.getCustomerAddress(), bill.getCustomerEmail(), bill.getCustomerPhone());
    }

    public List<BillDetailInfo> listBillDetailInfos(String billId) {
        String sql = "Select new " + BillDetailInfo.class.getName() //
                + "(d.id, d.product.code, d.product.name , d.quanity,d.price,d.amount) "//
                + " from " + BillDetail.class.getName() + " d "//
                + " where d.bill.id = :billId ";

        Session session = this.sessionFactory.getCurrentSession();
        Query<BillDetailInfo> query = session.createQuery(sql, BillDetailInfo.class);
        query.setParameter("billId", billId);

        return query.getResultList();
    }

}