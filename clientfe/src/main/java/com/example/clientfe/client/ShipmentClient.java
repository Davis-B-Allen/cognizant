package com.example.clientfe.client;

import com.example.clientfe.model.Shipment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("shipment")
public interface ShipmentClient {
    @GetMapping("/shipment/{trackingNumber}")
    Shipment findShipmentByTrackingNumber(@PathVariable Long trackingNumber);

    @PostMapping("/shipment/addshipment")
    Shipment create(@RequestBody Shipment shipment);
}
