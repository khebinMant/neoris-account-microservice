package com.neoris.account.movements.services;

import com.neoris.account.account.entities.AccountEntity;
import com.neoris.account.account.services.IAccountService;
import com.neoris.account.account.vo.UpdateAccountVo;
import com.neoris.account.common.exceptions.AccountException;
import com.neoris.account.movements.entities.MovementsEntity;
import com.neoris.account.common.exceptions.EntityNotFoundException;
import com.neoris.account.movements.repositories.IMovementsRepository;
import com.neoris.account.movements.vo.CreateMovementVo;
import com.neoris.account.movements.vo.UpdateMovementVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

/**
 * {@inheritDoc}
 */
@Validated
@Lazy
@Service
@Transactional
public class MovementsService implements IMovementsService {

    @Lazy
    @Autowired
    private IMovementsRepository movementsRepository;

    @Lazy
    @Autowired
    private IAccountService accountService;

    @Override
    public MovementsEntity create(CreateMovementVo createMovementVo) throws EntityNotFoundException {

        AccountEntity foundedAccount =  accountService.findByAccounNumber(createMovementVo.getAccountNumber());

        if(foundedAccount.getOpeningBalance()+(createMovementVo.getTransactionValue())<0){
            throw new AccountException("No se puede retirar la cantidad deseada, no tiene dinero suficiente" +
                    "en la cuenta" );
        }
        else{
            createMovementVo.setBalance(foundedAccount.getOpeningBalance());
            UpdateAccountVo updateAccountVo = UpdateAccountVo.builder()
                    .balance(foundedAccount.getOpeningBalance()+(createMovementVo.getTransactionValue()))
                    .build();
            accountService.updateAccount(updateAccountVo, foundedAccount.getAccountId());
        }
        return movementsRepository.create(createMovementVo, foundedAccount);
    }

    @Override
    public MovementsEntity findById(Long movement_id) throws EntityNotFoundException {
        return Optional.ofNullable(movementsRepository.findById(movement_id))
                .orElseThrow(() -> new EntityNotFoundException("No existe la persona con el id %s".formatted(movement_id)));
    }

    @Override
    public List<MovementsEntity> findByAccountNumber(String accountNumber) {
        return movementsRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public void updateMovement(UpdateMovementVo updateMovementVo, Long movementId) throws EntityNotFoundException {
        this.findById(movementId);
        movementsRepository.updateMovement(updateMovementVo, movementId);
    }
}
