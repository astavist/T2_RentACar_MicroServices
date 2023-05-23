package com.kodlamaio.paymentservice.business.abstracts;

import com.kodlamaio.commonpackage.utils.dto.ClientResponse;
import com.kodlamaio.commonpackage.utils.dto.CreateRentalPaymentRequest;
import com.kodlamaio.paymentservice.business.dto.request.CreatePaymentRequest;
import com.kodlamaio.paymentservice.business.dto.request.UpdatePaymentRequest;
import com.kodlamaio.paymentservice.business.dto.response.CreatePaymentResponse;
import com.kodlamaio.paymentservice.business.dto.response.GetAllPaymentsResponse;
import com.kodlamaio.paymentservice.business.dto.response.GetPaymentResponse;
import com.kodlamaio.paymentservice.business.dto.response.UpdatePaymentResponse;

import java.util.List;
import java.util.UUID;

public interface PaymentService {
    List<GetAllPaymentsResponse> getAll();

    GetPaymentResponse getById(UUID id);

    CreatePaymentResponse add(CreatePaymentRequest request);

    UpdatePaymentResponse update(UUID id, UpdatePaymentRequest request);

    void delete(UUID id);
    ClientResponse processRentalPayment(CreateRentalPaymentRequest request);

}
