package com.neoris.account.account.repositories;

import com.neoris.account.account.entities.AccountEntity;
import com.neoris.account.account.vo.CreateAccountVo;
import com.neoris.account.account.vo.UpdateAccountVo;
import com.neoris.account.common.enums.Status;
import com.neoris.account.common.exceptions.EntityNotFoundException;
import com.neoris.account.common.repositories.JPAQueryDslBaseRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAUpdateClause;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import static com.neoris.account.account.entities.QAccountEntity.accountEntity;

    /**
     * {@inheritDoc}
     */
    @Repository
public class AccountRepository extends JPAQueryDslBaseRepository<AccountEntity> implements IAccountRepository {

    public AccountRepository(){
        super(AccountEntity.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AccountEntity create(CreateAccountVo createAccountVo) {
        AccountEntity entity = AccountEntity.builder()
            .accountNumber(createAccountVo.getAccountNumber())
            .accountType(createAccountVo.getAccountType())
            .openingBalance(createAccountVo.getOpeningBalance())
            .clientId(createAccountVo.getClientId())
            .status(Status.ACTIVE.value)
            .createdByUser(createAccountVo.getCreatedByUser())
            .lastModifiedDate(createAccountVo.getLastModifiedDate())
            .createdFromIp(createAccountVo.getCreatedFromIp())
            .updatedFromIp(createAccountVo.getUpdatedFromIp())
            .build();
        this.save(entity);
        return entity;
    }

    @Override
    public AccountEntity findById(Long accountId) {
        return from(accountEntity)
                .where(this.activeAccountCondition(accountId))
                .fetchFirst();
    }

    @Override
    public AccountEntity findByAccounNumber(String accountNumber) throws EntityNotFoundException {
        return from(accountEntity)
                .where(accountEntity.status.eq(Status.ACTIVE.value))
                .where(accountEntity.accountNumber.eq(accountNumber))
                .fetchFirst();
    }

    @Override
    public void updateAccount(UpdateAccountVo updateAccountVo, Long accountId) {
        JPAUpdateClause updateClause = new JPAUpdateClause(entityManager, accountEntity);
        updateClause.where(this.activeAccountCondition(accountId));

        if (updateAccountVo.getAccountType() != null) {
            updateClause.set(accountEntity.accountType, updateAccountVo.getAccountType());
        }

        if (updateAccountVo.getBalance() != null) {
            updateClause.set(accountEntity.openingBalance, updateAccountVo.getBalance());
        }
        /*
        * Used to logical delete
        * */
        if (updateAccountVo.getStatus() != null) {
            updateClause.set(accountEntity.status, updateAccountVo.getStatus());
        }

        updateClause.execute();
    }

    /**
     * Generate predicate status
     *
     * @param status Status
     * @return Predicate
     */
    private Predicate statusPredicate(Status status) {
        return accountEntity.status.eq(status.value);
    }

    /**
     * Active Account condition
     *
     * @param accountId Long
     * @return BooleanBuilder
     */
    private BooleanBuilder activeAccountCondition(Long accountId) {
        BooleanBuilder where = new BooleanBuilder();
        where.and(accountEntity.accountId.eq(accountId));
        where.and(statusPredicate(Status.ACTIVE));
        return where;
    }
}
