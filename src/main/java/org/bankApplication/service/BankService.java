package org.bankApplication.service;

import org.bankApplication.dao.BankRepository;
import org.bankApplication.model.BankBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;

    @Transactional
    public void saveBranch(BankBranch bankBranch) {
        bankRepository.saveBranch(bankBranch);
    }
    @Transactional
    public void saveBranchUser(BankBranch bankUser) {
        bankRepository.saveBranchUser(bankUser);
    }

    @Transactional
    public void updateBranch(BankBranch branch) {
        bankRepository.updateBranch(branch);
    }
    @Transactional
    public List<BankBranch> getAll() {
        return bankRepository.getAll();
    }
    @Transactional
    public void deleteBranch(BankBranch bankBranch) {
        bankRepository.deleteBranch(bankBranch);
    }


}
