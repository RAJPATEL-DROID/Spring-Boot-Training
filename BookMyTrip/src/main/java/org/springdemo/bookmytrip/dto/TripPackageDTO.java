package org.springdemo.bookmytrip.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springdemo.bookmytrip.model.Itinerary;
import org.springdemo.bookmytrip.model.Review;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TripPackageDTO {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    @Positive(message = "Price must be positive")
    private BigDecimal price;

    @NotEmpty(message = "At least one itinerary is required")
    @Valid
    private List<ItineraryDTO> itineraries;

    public TripPackageDTO(Long id, String title, String description, BigDecimal price, List<ItineraryDTO> itineraries, List<Review> reviews) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.itineraries= itineraries;

    }
}
