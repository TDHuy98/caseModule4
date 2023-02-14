package com.codegym.casemodule4.controllers;

import com.codegym.casemodule4.dao.BillDAO;
import com.codegym.casemodule4.models.BillDetailInfo;
import com.codegym.casemodule4.models.BillInfo;
import com.codegym.casemodule4.pagination.PaginationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Transactional
public class AdminController {

    @Autowired
    private BillDAO billDAO;


    //Hiển thị danh sách đơn
    @GetMapping(value = {"/admin/billList"})
    public String billList(Model model, //
                           @RequestParam(value = "page", defaultValue = "1") String pageStr) {
        int page = 1;
        try {
            page = Integer.parseInt(pageStr);
        } catch (Exception e) {
        }
        final int MAX_RESULT = 5;
        final int MAX_NAVIGATION_PAGE = 10;

        PaginationResult<BillInfo> paginationResult //
                = billDAO.listBillInfo(page, MAX_RESULT, MAX_NAVIGATION_PAGE);

        model.addAttribute("paginationResult", paginationResult);
        return "billList";
    }

    //Xem chi tiết đơn
    @GetMapping(value = {"/admin/bill"})
    public String billView(Model model, @RequestParam("billId") String billId) {
        BillInfo billInfo = null;
        if (billId != null) {
            billInfo = this.billDAO.getBillInfo(billId);
        }
        if (billInfo == null) {
            return "redirect:/admin/orderList";
        }
        List<BillDetailInfo> details = this.billDAO.listBillDetailInfos(billId);
        billInfo.setDetails(details);

        model.addAttribute("billInfo", billInfo);

        return "order";
    }

}