package com.kodlamaio.rentalservice.business.dto.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateRentalRequest {
    @NotNull
    private UUID carId;
    @Min(1)
    private double dailyPrice;
    @Min(1)
    private int rentedForDays;

    @NotBlank(message = "Kart numarası boş bırakılamaz")
    @Length(min = 16, max = 16, message = "Kart numarası 16 haneli olmak zorunda")
    private String cardNumber;

    @NotBlank
    @Length(min = 5)
    private String cardHolder;

    @Min(value = 2023)
    private int cardExpirationYear;

    @Min(value = 1)
    @Max(value = 12)
    private int cardExpirationMonth;

    @Length(min = 3, max = 3)
    @NotBlank
    @NotNull
    private String cardCvv;
}

