package com.neoris.account.account.services;

import com.neoris.account.account.entities.AccountEntity;
import com.neoris.account.account.repositories.IAccountRepository;
import com.neoris.account.account.vo.CreateAccountVo;
import com.neoris.account.account.vo.UpdateAccountVo;
import com.neoris.account.common.exceptions.EntityNotFoundException;
import com.neoris.account.common.util.RandomNumberGenerator;
import com.neoris.account.common.web.Response;
import com.neoris.account.feign.ClientFeign;
import com.neoris.account.model.Client;
import com.neoris.account.movements.entities.MovementsEntity;
import com.neoris.account.movements.services.IMovementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

/**
 * {@inheritDoc}
 */
@Validated
@Lazy
@Service
@Transactional
public class AccountService implements IAccountService {

    @Lazy
    @Autowired
    private IAccountRepository accountRepository;

    @Lazy
    @Autowired
    private IMovementsService movementsService;

    @Lazy
    @Autowired
    private ClientFeign clientFeign;

    @Lazy
    @Autowired
    private RandomNumberGenerator randomNumberGenerator;

    @Override
    public AccountEntity create(CreateAccountVo createAccount) throws EntityNotFoundException{

        ResponseEntity<Response<Client>> clientResponse = clientFeign.findClientByIdentityNumber(createAccount.getIdentityNumber());
        Response<Client> responseBody = clientResponse.getBody();
        Client client = responseBody != null ? responseBody.getData() : null;
        if (client != null) {
            Long clientId = client.getClientId(); // o cualquier otra propiedad
        } else {
            //AQUI UN THROW
            System.out.println("Cliente no encontrado");
        }
        if(createAccount.getAccountNumber()==null){
            Long newAccountNumber = randomNumberGenerator.generateRandomNumber(8);
            createAccount.setAccountNumber(newAccountNumber.toString());
        }
        createAccount.setClientId(client.getClientId());
        return accountRepository.create(createAccount);
    }

    @Override
    public AccountEntity findById(Long clientId) throws EntityNotFoundException{

        return Optional.ofNullable(accountRepository.findById(clientId))
                .orElseThrow(() -> new EntityNotFoundException("No existe la cuenta con el número %s".formatted(clientId)));
    }

    @Override
    public AccountEntity findByAccounNumber(String accountNumber) throws EntityNotFoundException {
        return Optional.ofNullable(accountRepository.findByAccounNumber(accountNumber))
                .orElseThrow(() -> new EntityNotFoundException("No existe la cuenta con el número de cuenta %s".formatted(accountNumber)));
    }
    @Override
    public void updateAccount(UpdateAccountVo updateAccountVo, Long clientId) throws EntityNotFoundException{
        this.findById(clientId);
        accountRepository.updateAccount(updateAccountVo, clientId);
    }
}
