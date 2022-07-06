package org.ujar.micro.k8s.bookingdb.importer.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.ujar.micro.k8s.bookingdb.importer.service.GeoDataImporterService;
import org.ujar.micro.k8s.bookingdb.jobs.ImportJobParameters;
import org.ujar.micro.k8s.bookingdb.jobs.JobType;

@Component
@RequiredArgsConstructor
@Slf4j
public class GeoDataImportConsumer {
  private final GeoDataImporterService importer;

  public void consume(ImportJobParameters message) {
    log.info("Received message: {}", message);
    if (message.getType() == JobType.IMPORT_CITIES) {
      importer.importCities();
    } else {
      importer.importCountries();
    }
  }
}