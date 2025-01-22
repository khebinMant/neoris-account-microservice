package com.neoris.account.feign.fallback;

import com.neoris.account.common.web.Response;
import com.neoris.account.feign.ClientFeign;
import com.neoris.account.model.Client;
import com.neoris.account.model.vo.UpdateClientVo;
import org.springframework.http.ResponseEntity;

public class ClientFallback implements ClientFeign {
    @Override
    public ResponseEntity<Response<Client>> findClientById(Long clientId) {
        return null;
    }

    @Override
    public ResponseEntity<Response<Void>> update(Long clientId, UpdateClientVo updateClientVo) {
        return null;
    }

    @Override
    public ResponseEntity<Response<Client>> findClientByIdentityNumber(Long identityNumber) {
        return null;
    }
}
