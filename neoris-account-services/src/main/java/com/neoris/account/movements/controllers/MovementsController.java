package com.neoris.account.movements.controllers;

import com.neoris.account.common.web.Response;
import com.neoris.account.movements.entities.MovementsEntity;
import com.neoris.account.movements.services.IMovementsService;
import com.neoris.account.movements.vo.CreateMovementVo;
import com.neoris.account.movements.vo.UpdateMovementVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for Movement
 *
 * @author Kevin
 * @version 1.0
 */
@RestController
@RequestMapping("movimientos")
@Lazy
@Tag(name = "Movimientos", description = "Movimientos API")
public class MovementsController {
    @Lazy
    @Autowired
    private IMovementsService movementsService;

    /**
     * Add a new Movement
     *
     * @param createMovement Movement to create
     * @return Status code
     */
    @PostMapping
    @Operation(summary = "Create new Movement")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Movement Object has been created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Movement Object already exists")
    })
    public ResponseEntity<Response<MovementsEntity>> create(@RequestBody CreateMovementVo createMovement) {
        return new ResponseEntity<>(Response.<MovementsEntity>builder()
                .data(this.movementsService.create(createMovement))
                .message("Objeto fue creado").build(), HttpStatus.CREATED);
    }

    /**
     * Find movement value by ID
     *
     * @param movementId String
     * @return MovementEntity
     */
    @GetMapping("{movementId}")
    @Operation(summary = "Find movement by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Find movement by Id"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<Response<MovementsEntity>> findValueById(@NotBlank @PathVariable Long movementId) {
        return new ResponseEntity<>(Response.<MovementsEntity>builder()
                .data(this.movementsService.findById(movementId)).build(), HttpStatus.OK);
    }

    /**
     * Find all movements by accountNumber
     *
     * @param accountNumber String
     * @return MovementEntity
     */
    @GetMapping("all/{accountNumber}")
    @Operation(summary = "Find movements by accountNumber")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Find movement by Id"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<Response<List<MovementsEntity>>> findMovementsByAccountNumber(@NotBlank @PathVariable String accountNumber) {
        return new ResponseEntity<>(Response.<List<MovementsEntity>>builder()
                .data(this.movementsService.findByAccountNumber(accountNumber)).build(), HttpStatus.OK);
    }

    /**
     * Update Movement.
     *
     * @param movementId Long ID
     * @param updateMovementVo UpdateMovement
     * @return Status code
     */
    @PatchMapping("/{movementId}")
    @Operation(summary = "Update Movement")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated"),
            @ApiResponse(responseCode = "404", description = "Movement not found"),
    })
    public ResponseEntity<Response<Void>> update(@NotBlank @PathVariable Long movementId, @RequestBody UpdateMovementVo updateMovementVo) {
        this.movementsService.updateMovement(updateMovementVo, movementId);
        return new ResponseEntity<>(Response.<Void>builder().message("Actualizado con éxito").build(), HttpStatus.OK);
    }

}
