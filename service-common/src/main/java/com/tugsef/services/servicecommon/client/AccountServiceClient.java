package com.tugsef.services.servicecommon.client;




import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tugsef.services.servicecommon.client.contract.AccountResponse;

@FeignClient("account-service")
public interface AccountServiceClient {

    @RequestMapping("/account/{id}")
    ResponseEntity<AccountResponse> get(@PathVariable("id") String id);
}
