package dev.knowhowto.bookingdb.importer.service;

import org.springframework.stereotype.Service;

@Service
public interface CityImporterService {

  void importCities(final String countryCode);
}
