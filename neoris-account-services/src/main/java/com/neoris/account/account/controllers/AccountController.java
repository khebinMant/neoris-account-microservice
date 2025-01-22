package com.neoris.account.account.controllers;


import com.neoris.account.account.entities.AccountEntity;
import com.neoris.account.account.services.IAccountService;
import com.neoris.account.account.vo.CreateAccountVo;
import com.neoris.account.account.vo.ReportAccountVo;
import com.neoris.account.account.vo.UpdateAccountVo;
import com.neoris.account.common.web.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Controller for Account
 *
 * @author Kevin
 * @version 1.0
 */
@RestController
@RequestMapping("cuentas")
@Lazy
@Tag(name = "cuentas", description = "Accounts API")
public class AccountController {

    @Lazy
    @Autowired
    private IAccountService accountService;

    /**
     * Add a new Account
     *
     * @param createAccount Account to create
     * @return Status code
     */
    @PostMapping
    @Operation(summary = "Create new Account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Account Object has been created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Account Object already exists")
    })
    public ResponseEntity<Response<AccountEntity>> create(@RequestBody CreateAccountVo createAccount) {
        return new ResponseEntity<>(Response.<AccountEntity>builder()
                .data(this.accountService.create(createAccount))
                .message("Objeto fue creado").build(), HttpStatus.CREATED);
    }

    /**
     * Find account value by ID
     *
     * @param accountNumber String
     * @return Catalogue value entity
     */
    @GetMapping("accountNumber/{accountNumber}")
    @Operation(summary = "Find account by accountNumber")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Find account by accountId"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<Response<AccountEntity>> findById(@NotBlank @PathVariable String accountNumber) {
        return new ResponseEntity<>(Response.<AccountEntity>builder()
                .data(this.accountService.findByAccounNumber(accountNumber)).build(), HttpStatus.OK);
    }

    /**
     * Find account value by ID
     *
     * @param accountId String
     * @return Catalogue value entity
     */
    @GetMapping("{accountId}")
    @Operation(summary = "Find account by accountId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Find account by accountId"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<Response<AccountEntity>> findAccountByAccountId(@NotBlank @PathVariable Long accountId) {
        return new ResponseEntity<>(Response.<AccountEntity>builder()
                .data(this.accountService.findById(accountId)).build(), HttpStatus.OK);
    }

    /**
     * Update Account.
     *
     * @param accountNumber String
     * @param updateAccountVo UpdateAccount
     * @return Status code
     */
    @PatchMapping("/{accountNumber}")
    @Operation(summary = "Update Account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated"),
            @ApiResponse(responseCode = "404", description = "Account not found"),
    })
    public ResponseEntity<Response<Void>> update(@NotBlank @PathVariable String accountNumber, @RequestBody UpdateAccountVo updateAccountVo) {
        this.accountService.updateAccount(updateAccountVo, accountNumber);
        return new ResponseEntity<>(Response.<Void>builder().message("Actualizado con éxito").build(), HttpStatus.OK);
    }

    /**
     * Find all Accounts.
     *
     * @return Status code
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get all Accounts")
    @ApiResponses(value = { @ApiResponse(responseCode =  "200", description = "List of flow objects")})
    public ResponseEntity<Response<List<AccountEntity>>> findAll(){
        return new ResponseEntity<>(Response.<List<AccountEntity>>builder()
                .data(accountService.findAllAccounts())
                .message("SUCCESS")
                .build(),
                HttpStatus.OK);
    }

    /**
     * Find all Accounts of Client.
     *
     * @return Status code
     */
    @GetMapping("client/{clientId}")
    @Operation(summary = "Get all Accounts")
    @ApiResponses(value = { @ApiResponse(responseCode =  "200", description = "List of flow objects")})
    public ResponseEntity<Response<List<AccountEntity>>> findAllByClientId(@PathVariable Long clientId){
        System.out.println(clientId);
        return new ResponseEntity<>(Response.<List<AccountEntity>>builder()
                .data(accountService.findAllAccountsByClientId(clientId))
                .message("SUCCESS")
                .build(),
                HttpStatus.OK);
    }

    @GetMapping("/reportes")
    public ResponseEntity<Response<List<ReportAccountVo>>>  getReportes(
            @RequestParam("minDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date minDate,
            @RequestParam("maxDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date maxDate,
            @RequestParam("identityNumber") Long identityNumber) {


        return new ResponseEntity<>(Response.<List<ReportAccountVo>>builder()
                .data(accountService.generateReportAccountState(identityNumber, minDate, maxDate))
                .message("SUCCESS")
                .build(),
                HttpStatus.OK);
    }
}
