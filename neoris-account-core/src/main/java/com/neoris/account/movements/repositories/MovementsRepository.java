package com.neoris.account.movements.repositories;

import com.neoris.account.account.entities.AccountEntity;
import com.neoris.account.common.enums.MovementType;
import com.neoris.account.common.repositories.JPAQueryDslBaseRepository;
import com.neoris.account.common.util.DateUtil;
import com.neoris.account.movements.entities.MovementsEntity;
import com.neoris.account.common.enums.Status;
import com.neoris.account.movements.vo.CreateMovementVo;
import com.neoris.account.movements.vo.UpdateMovementVo;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAUpdateClause;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import static com.neoris.account.movements.entities.QMovementsEntity.movementsEntity;

/**
 * {@inheritDoc}
 */
@Repository
public class MovementsRepository extends JPAQueryDslBaseRepository<MovementsEntity> implements IMovementsRepository {
    public MovementsRepository(){
        super(MovementsEntity.class);
    }

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public MovementsEntity create(CreateMovementVo createMovementVo, AccountEntity accountEntity) {
        MovementsEntity entity = MovementsEntity.builder()
                .movementDate(DateUtil.currentDate())
                //Quiere decir que cuando se hace un depósito el valor 1 mientras que si se hace un retiro es 0
                .movementType(createMovementVo.getTransactionValue()>0? MovementType.DEPOSITO.value : MovementType.RETIRO.value)
                .transactionValue(createMovementVo.getTransactionValue())
                .balance(createMovementVo.getBalance())
                .accountEntity(accountEntity)
                .status(createMovementVo.getStatus())
                .createdByUser(createMovementVo.getCreatedByUser())
                .lastModifiedDate(createMovementVo.getLastModifiedDate())
                .createdFromIp(createMovementVo.getCreatedFromIp())
                .updatedFromIp(createMovementVo.getUpdatedFromIp())
                .build();
        this.save(entity);
        return entity;
    }

    @Override
    public MovementsEntity findById(Long movementId) {
        return from(movementsEntity)
                .where(this.activeMovementCondition(movementId))
                .fetchFirst();
    }

    @Override
    public List<MovementsEntity> findByAccountNumber(String accountNumber) {
        return from(movementsEntity)
                .where(movementsEntity.accountEntity.accountNumber.eq(accountNumber))
                .where(movementsEntity.accountEntity.status.eq(Status.ACTIVE.value))
                .where(movementsEntity.status.eq(Status.ACTIVE.value))
                .fetch();
    }


    @Override
    public void updateMovement(UpdateMovementVo updateMovementVo, Long movementId) {
        JPAUpdateClause updateClause = new JPAUpdateClause(entityManager, movementsEntity);
        updateClause.where(this.activeMovementCondition(movementId));

        /*
         * Used to logical delete
         * */
        if (updateMovementVo.getStatus() != null) {
            updateClause.set(movementsEntity.status, updateMovementVo.getStatus());
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
        return movementsEntity.status.eq(status.value);
    }

    /**
     * Active Client condition
     *
     * @param movementId Long
     * @return BooleanBuilder
     */
    private BooleanBuilder activeMovementCondition(Long movementId) {
        BooleanBuilder where = new BooleanBuilder();
        where.and(movementsEntity.movementId.eq(movementId));
        where.and(movementsEntity.status.eq(Status.ACTIVE.value));
        return where;
    }
}
