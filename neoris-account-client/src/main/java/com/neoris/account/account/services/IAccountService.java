package com.neoris.account.account.services;

import com.neoris.account.account.entities.AccountEntity;
import com.neoris.account.account.vo.CreateAccountVo;
import com.neoris.account.account.vo.ReportAccountVo;
import com.neoris.account.account.vo.UpdateAccountVo;
import com.neoris.account.common.exceptions.EntityNotFoundException;

import java.util.Date;
import java.util.List;

/**
 * AccountService
 *
 * @author Kevin
 * @version 1.0
 */
public interface IAccountService {

    /**
     * Create Account.
     *
     * @author Kevin on 20/01/2025
     * @param createAccount CreateAccount
     * @return AccountEntity
     */
    AccountEntity create(CreateAccountVo createAccount) throws EntityNotFoundException;

    /**
     * Get a Account given an ID.
     *
     * @author Kevin on 20/01/2025
     * @return a AccountEntity
     */
    AccountEntity findById(Long accountId) throws EntityNotFoundException;

    /**
     * Get a Account given an ID.
     * @author Kevin on 20/01/2025
     * @param accountNumber String
     * @return a AccountEntity
     */
    AccountEntity findByAccounNumber(String accountNumber) throws EntityNotFoundException;

    /**
     * Get a Account given an Identification Person.
     *
     * @author Kevin on 20/01/2025
     * @param identificationNumber String
     * @return AccountEntity
     */
    //AccountEntity findByIdentificationPersonNumber(String identificationNumber) throws EntityNotFoundException;

    /**
     * Update Account
     * is also used to inactivate (delete)
     * (logical delete not physically delete)
     * @author Kevin on 20/01/2025
     * @param updateAccountVo UpdateAccount
     */
    void updateAccount(UpdateAccountVo updateAccountVo, String accountNumber) throws EntityNotFoundException;

    List<AccountEntity> findAllAccounts();

    List<ReportAccountVo> generateReportAccountState(Long identityNumber, Date minDate, Date maxDate);

    List<AccountEntity> findAllAccountsByClientId(Long clientId);

}
