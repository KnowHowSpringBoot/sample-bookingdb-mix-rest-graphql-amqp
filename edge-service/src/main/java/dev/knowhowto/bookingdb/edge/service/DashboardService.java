package dev.knowhowto.bookingdb.edge.service;

import dev.knowhowto.bookingdb.edge.config.ServicesProperties;
import dev.knowhowto.bookingdb.edge.model.CityPage;
import dev.knowhowto.bookingdb.edge.model.CountryPage;
import dev.knowhowto.bookingdb.edge.model.HotelPage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class DashboardService {
  private final ServicesProperties properties;

  public Mono<CountryPage> countries(Integer page, Integer size) {
    if (size == null) {
      size = 10;
    }
    final var pageSize = size;
    return WebClient.builder()
        .baseUrl(properties.dashboardService()).build().get()
        .uri(uriBuilder -> uriBuilder
            .path("/api/countries")
            .queryParam("page", page)
            .queryParam("size", pageSize)
            .build()
        )
        .retrieve()
        .bodyToMono(CountryPage.class);
  }

  public Mono<CityPage> cities(Integer page, Integer size) {
    if (size == null) {
      size = 10;
    }
    final var pageSize = size;
    return WebClient.builder()
        .baseUrl(properties.dashboardService()).build().get()
        .uri(uriBuilder -> uriBuilder
            .path("/api/cities")
            .queryParam("page", page)
            .queryParam("size", pageSize)
            .build()
        )
        .retrieve()
        .bodyToMono(CityPage.class);
  }

  public Mono<HotelPage> hotels(Integer page, Integer size) {
    if (size == null) {
      size = 10;
    }
    final var pageSize = size;
    return WebClient.builder()
        .baseUrl(properties.dashboardService()).build().get()
        .uri(uriBuilder -> uriBuilder
            .path("/api/hotels")
            .queryParam("page", page)
            .queryParam("size", pageSize)
            .build()
        )
        .retrieve()
        .bodyToMono(HotelPage.class);
  }
}
