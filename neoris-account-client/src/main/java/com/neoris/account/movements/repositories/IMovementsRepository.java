package com.neoris.account.movements.repositories;

import com.neoris.account.account.entities.AccountEntity;
import com.neoris.account.common.exceptions.EntityNotFoundException;
import com.neoris.account.movements.entities.MovementsEntity;
import com.neoris.account.movements.vo.CreateMovementVo;
import com.neoris.account.movements.vo.UpdateMovementVo;
import com.neoris.account.common.repositories.IQueryDslBaseRepository;

import java.util.List;


/**
 * PersonRepository
 *
 * @author Kevin
 * @version 1.0
 */
public interface IMovementsRepository extends IQueryDslBaseRepository<MovementsEntity> {

    /**
     * Create Person.
     *
     * @author Kevin on 20/01/2025
     * @param createMovementVo CreateMovementVo
     * @return MovementsEntity
     */
    MovementsEntity create(CreateMovementVo createMovementVo, AccountEntity accountEntity);

    /**
     * Get a Person given an ID.
     *
     * @author Kevin on 20/01/2025
     * @param movementId Long
     * @return a MovementsEntity
     */
    MovementsEntity findById(Long movementId);

    /**
     * Get a Person given an Identification Person.
     *
     * @author Kevin on 20/01/2025
     * @param accountNumber String
     * @return <List>MovementsEntity
     */
    List<MovementsEntity> findByAccountNumber(String accountNumber);

    /**
     * Update Movement
     * is also used to inactivate (delete)
     * (logical delete not physically delete)
     * @author Kevin on 20/01/2025
     * @param updateMovementVo UpdateMovementVo
     * @param movementId Long
     */
    void updateMovement(UpdateMovementVo updateMovementVo, Long movementId) throws EntityNotFoundException;
}
