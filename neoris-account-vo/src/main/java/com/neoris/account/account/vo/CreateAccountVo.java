package com.neoris.account.account.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountVo {
    @NotBlank
    private Long identityNumber;
    @NotBlank
    @Pattern(regexp = "^(AHORRO|CORRIENTE)$", message = "El tipo de cuenta debe ser 'AHORRO' o 'CORRIENTE'.")
    private String accountType;

    @NotBlank
    private Long openingBalance;



    @NotBlank
    private Long createdByUser;
    @NotBlank
    private Date lastModifiedDate;
    @NotBlank
    private String createdFromIp;
    @NotBlank
    private String updatedFromIp;

    /*Campos no requeridos en el body*/
    private String accountNumber;
    private Long clientId;
}
