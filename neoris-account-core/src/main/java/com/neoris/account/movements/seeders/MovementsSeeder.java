package com.neoris.account.movements.seeders;


import com.neoris.account.movements.services.IMovementsService;
import com.neoris.account.movements.vo.CreateMovementVo;
import com.neoris.account.common.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovementsSeeder {
    @Autowired
    IMovementsService personService;

    public void fillStartPersons (){
        /*personService.create(CreateMovementVo.builder()
            .name("Jose")
            .surname("Lema")
            .gender("M")
            .birthDate(DateUtil.currentDate())
            .identificationNumber("123567891")
            .address("Otavalo sn y principal")
            .phone("0985871145")
            .status("1")
            .createdByUser(1001L)
            .lastModifiedDate(DateUtil.currentDate())
            .createdFromIp("192.168.0.1")
            .updatedFromIp("192.168.0.1")
            .build());

        personService.create(CreateMovementVo.builder()
                .name("Marianela")
                .surname("Montalvo")
                .gender("F")
                .birthDate(DateUtil.currentDate())
                .identificationNumber("123567892")
                .address("Amazonas y NNUU")
                .phone("0984147741")
                .status("1")
                .createdByUser(1001L)
                .lastModifiedDate(DateUtil.currentDate())
                .createdFromIp("192.168.0.1")
                .updatedFromIp("192.168.0.1")
                .build());

        personService.create(CreateMovementVo.builder()
                .name("Juan")
                .surname("Osorio")
                .gender("M")
                .birthDate(DateUtil.currentDate())
                .identificationNumber("123567893")
                .address("13 junio y Equinoccial")
                .phone("0963251147")
                .status("1")
                .createdByUser(1001L)
                .lastModifiedDate(DateUtil.currentDate())
                .createdFromIp("192.168.0.1")
                .updatedFromIp("192.168.0.1")
                .build());*/
    }
}
