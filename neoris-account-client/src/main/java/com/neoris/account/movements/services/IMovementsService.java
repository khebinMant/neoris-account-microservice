package com.neoris.account.movements.services;

import com.neoris.account.common.exceptions.EntityNotFoundException;
import com.neoris.account.movements.entities.MovementsEntity;
import com.neoris.account.movements.vo.CreateMovementVo;
import com.neoris.account.movements.vo.UpdateMovementVo;

import java.util.List;

/**
 * PersonService
 *
 * @author Kevin
 * @version 1.0
 */
public interface IMovementsService {
    /**
     * Create Person.
     *
     * @author Kevin on 20/01/2025
     * @param createPerson CreatePerson
     * @return PersonEntity
     */
    MovementsEntity create(CreateMovementVo createPerson) throws EntityNotFoundException;

    /**
     * Get a Person given an ID.
     *
     * @author Kevin on 20/01/2025
     * @param movementId Long
     * @return a PersonEntity
     */
    MovementsEntity findById(Long movementId) throws EntityNotFoundException;

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
