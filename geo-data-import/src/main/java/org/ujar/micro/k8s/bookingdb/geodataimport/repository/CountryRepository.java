package org.ujar.micro.k8s.bookingdb.geodataimport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.ujar.micro.k8s.bookingdb.geodataimport.entity.Country;

public interface CountryRepository
    extends PagingAndSortingRepository<Country, Long>, JpaRepository<Country, Long> {

}