package dev.knowhowto.bookingdb.edge.model;

import java.util.List;

public record HotelPage(List<Hotel> content,
                        Integer totalPages,
                        Integer totalElements,
                        Integer size,
                        Integer number,
                        Pageable pageable) {

}
