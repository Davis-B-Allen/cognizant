package com.example.shipment.service;

import com.example.shipment.model.Shipment;

public interface ShipmentService {

    Shipment findShipmentByTrackingNumber(Long trackingNumber);

    Shipment create(Shipment shipment);
}
