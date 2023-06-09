package com.kodlamaio.rentalservice.api.clients;

import com.kodlamaio.commonpackage.utils.dto.ClientResponse;
import com.kodlamaio.commonpackage.utils.dto.CreateRentalPaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "payment-service", fallback = PaymentClientFallback.class)
public interface PaymentClient {
    @PostMapping(value = "/api/payments/check")
    ClientResponse processRentalPayment(@RequestBody CreateRentalPaymentRequest request);
}
