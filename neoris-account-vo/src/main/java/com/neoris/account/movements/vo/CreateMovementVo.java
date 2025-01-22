package com.neoris.account.movements.vo;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateMovementVo {
    @NotBlank
    private String accountNumber;

    @NotBlank
    private Long transactionValue;

    //Campos no requeridos en el body
    private Long balance;


    //Campos de auditoria
    private String status;
    private Long createdByUser;
    private Date lastModifiedDate;
    private String createdFromIp;
    private String updatedFromIp;
}
