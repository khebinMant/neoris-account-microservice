package com.neoris.account.feign;

import com.neoris.account.common.web.Response;
import com.neoris.account.feign.fallback.ClientFallback;
import com.neoris.account.model.Client;
import com.neoris.account.model.vo.UpdateClientVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name="customer-microservice", path = "/customerApi/clientes", url = "http://localhost:8080", fallback = ClientFallback.class)
@FeignClient(name="customer-microservice", url = "http://localhost:8080/customerApi/clientes")
public interface ClientFeign {

    @GetMapping(value="/{clientId}")
    public ResponseEntity<Response<Client>> findClientById(@PathVariable Long clientId);

    @PatchMapping(value="/{clientId}")
    public ResponseEntity<Response<Void>> update(@PathVariable Long clientId, @RequestBody UpdateClientVo updateClientVo);

    @GetMapping(value="/identityNumber/{identityNumber}")
    public ResponseEntity<Response<Client>> findClientByIdentityNumber(@PathVariable Long identityNumber);

}
