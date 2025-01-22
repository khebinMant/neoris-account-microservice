package com.neoris.account.account.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Vo for Report
 *
 * @author Kevin
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportAccountVo {

    Date movementDate;
    String clientFullName;
    String accountNumber;
    String accountType;
    Long openingBalance;
    String status;

    Long movement;

    //Columna calculada en tiempo de ejecución
    //balance-transaction value
    Long availableBalance;

}
