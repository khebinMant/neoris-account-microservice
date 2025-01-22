package com.neoris.account.account.repositories;


import com.neoris.account.account.entities.AccountEntity;
import com.neoris.account.account.vo.CreateAccountVo;
import com.neoris.account.account.vo.UpdateAccountVo;
import com.neoris.account.common.exceptions.EntityNotFoundException;
import com.neoris.account.common.repositories.IQueryDslBaseRepository;
import com.neoris.account.movements.entities.MovementsEntity;

/**
 * AccountRepository
 *
 * @author Kevin
 * @version 1.0
 */
public interface IAccountRepository extends IQueryDslBaseRepository<AccountEntity> {

    /**
     * Create Account.
     *
     * @author Kevin on 20/01/2025
     * @param createAccount CreateAccount
     * @return AccountEntity
     */
    AccountEntity create(CreateAccountVo createAccount);

    /**
     * Get a Account given an ID.
     *
     * @author Kevin on 20/01/2025
     * @return a AccountEntity
     */
    AccountEntity findById(Long accountId);

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
    //AccountEntity findByIdentificationPersonNumber(String identificationNumber);

    /**
     * Update Account
     * is also used to inactivate (delete)
     * (logical delete not physically delete)
     * @author Kevin on 20/01/2025
     * @param updateAccountVo UpdateAccount
     * @param accountId Long
     */
    void updateAccount(UpdateAccountVo updateAccountVo, Long accountId);
}
