package org.springdemo.bookmytrip.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TripPackageRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    @Positive(message = "Price must be positive")
    private BigDecimal price;

}
