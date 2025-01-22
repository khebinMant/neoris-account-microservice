package com.neoris.account.account.seeders;

import com.neoris.account.account.services.IAccountService;
import com.neoris.account.account.vo.CreateAccountVo;
import com.neoris.account.common.util.RandomNumberGenerator;
import com.neoris.account.movements.services.IMovementsService;
import com.neoris.account.common.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class AccountSeeder {

    @Autowired
    IAccountService accountService;
    @Autowired
    IMovementsService movementsService;

    @Lazy
    @Autowired
    private RandomNumberGenerator randomNumberGenerator;

    public void fillStartAccounts (){

        accountService.create(CreateAccountVo.builder()
            .identityNumber(1235678910L)
            .accountNumber("478758")
            .accountType("AHORRO")
            .openingBalance(2000L)
            .createdByUser(1001L)
            .lastModifiedDate(DateUtil.currentDate())
            .createdFromIp("192.168.0.1")
            .updatedFromIp("192.168.0.1")
            .build());

        accountService.create(CreateAccountVo.builder()
            .identityNumber(1235678911L)
            .accountNumber("495878")
            .accountType("AHORRO")
            .openingBalance(0L)
            .createdByUser(1001L)
            .lastModifiedDate(DateUtil.currentDate())
            .createdFromIp("192.168.0.1")
            .updatedFromIp("192.168.0.1")
            .build());

        accountService.create(CreateAccountVo.builder()
            .identityNumber(1235678912L)
            .accountNumber("225487")
            .accountType("CORRIENTE")
            .openingBalance(100L)
            .createdByUser(1001L)
            .lastModifiedDate(DateUtil.currentDate())
            .createdFromIp("192.168.0.1")
            .updatedFromIp("192.168.0.1")
            .build());

        accountService.create(CreateAccountVo.builder()
            .identityNumber(1235678911L)
            .accountNumber("496825")
            .accountType("AHORRO")
            .openingBalance(540L)
            .createdByUser(1001L)
            .lastModifiedDate(DateUtil.currentDate())
            .createdFromIp("192.168.0.1")
            .updatedFromIp("192.168.0.1")
            .build());
    }
}
