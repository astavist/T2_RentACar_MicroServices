package com.kodlamaio.paymentservice.api;

import com.kodlamaio.commonpackage.utils.dto.ClientResponse;
import com.kodlamaio.commonpackage.utils.dto.CreateRentalPaymentRequest;
import com.kodlamaio.paymentservice.business.abstracts.PaymentService;
import com.kodlamaio.paymentservice.business.dto.request.CreatePaymentRequest;
import com.kodlamaio.paymentservice.business.dto.request.UpdatePaymentRequest;
import com.kodlamaio.paymentservice.business.dto.response.CreatePaymentResponse;
import com.kodlamaio.paymentservice.business.dto.response.GetAllPaymentsResponse;
import com.kodlamaio.paymentservice.business.dto.response.GetPaymentResponse;
import com.kodlamaio.paymentservice.business.dto.response.UpdatePaymentResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService service;


    @GetMapping
    public List<GetAllPaymentsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetPaymentResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }
    @PostMapping("/process-rental-payment")
    public ClientResponse processRentalPayment(@RequestBody CreateRentalPaymentRequest request)
    {
        return service.processRentalPayment(request);
    }
    @PostMapping
    public CreatePaymentResponse add(@Valid @RequestBody CreatePaymentRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdatePaymentResponse update(@PathVariable UUID id, @Valid @RequestBody UpdatePaymentRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
