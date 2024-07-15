package org.springdemo.bookmytrip.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springdemo.bookmytrip.model.Itinerary;
import org.springdemo.bookmytrip.model.Review;

import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TripPackageDTO {

    public Long id;
    public String tripName;
    public String description;
    public BigDecimal price;

    public List<Itinerary> itineraries;

    public List<Review> reviews;
}
