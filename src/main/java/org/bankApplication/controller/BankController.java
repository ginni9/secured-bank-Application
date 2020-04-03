package org.bankApplication.controller;

import org.bankApplication.model.BankBranch;
import org.bankApplication.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BankController {

    @Autowired
    BankService bankService;

    @ResponseBody
    @RequestMapping(value="/admin/saveBranch",method = RequestMethod.POST)
    public String addBranch(@RequestBody BankBranch bankBranch)
    {
        bankService.saveBranch(bankBranch);
        return "Success";
    }

    @ResponseBody
    @RequestMapping(value = "/admin/saveBranchUser", method = RequestMethod.POST)
    public String addBranchUser(@RequestBody BankBranch bankUser)
    {
        bankService.saveBranchUser(bankUser);
        return "Success";
    }

    @ResponseBody
    @RequestMapping(value = "/admin/getBranch" )
    public List<BankBranch> getBranch()
    {
        return bankService.getAll();
    }


    @ResponseBody
    @RequestMapping(value="/admin/deleteBranch", method = RequestMethod.POST)
    public String removeBranch(@RequestBody BankBranch bank )
    {
        bankService.deleteBranch(bank);
        return "Success";
    }

    @ResponseBody
    @RequestMapping(value="/admin/updateBranch", method = RequestMethod.POST)
    public String update(@RequestBody BankBranch bank)
    {
        bankService.updateBranch(bank);
        return "Success";
    }
}
