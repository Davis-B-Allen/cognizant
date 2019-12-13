package com.example.shipment.repository;

import com.example.shipment.model.Shipment;
import org.springframework.data.repository.CrudRepository;

public interface ShipmentRepository extends CrudRepository<Shipment, Long> {

    Shipment findByTrackingNumber(Long trackingNumber);
}
