package org.springdemo.bookmytrip.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springdemo.bookmytrip.enums.SegmentType;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = FlightSegmentDTO.class, name = "FLIGHT"),
        @JsonSubTypes.Type(value = HotelSegmentDTO.class, name = "HOTEL")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class TripSegmentDTO {
    private SegmentType segmentType;

}