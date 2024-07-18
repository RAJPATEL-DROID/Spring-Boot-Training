package org.springdemo.bookmytrip.service;

import org.springdemo.bookmytrip.model.FlightSegment;
import org.springdemo.bookmytrip.model.HotelSegment;

import java.util.List;

public interface HotelSegmentService {

    HotelSegment getHotelSegment(Long id);

    List<HotelSegment> getAllHotelSegments();

    HotelSegment addHotelSegment(HotelSegment hotelSegment);

    HotelSegment updateHotelSegment(Long id, HotelSegment hotelSegment);

    void deleteHotelSegment(Long id);
}
