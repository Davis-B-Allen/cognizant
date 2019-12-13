package com.example.clientfe.controller;

import com.example.clientfe.model.Shipment;
import com.example.clientfe.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientfe")
public class ShipmentController {

    @Autowired
    ShipmentService shipmentService;

    @GetMapping("/shipment/{trackingNumber}")
    public Shipment findShipmentByTrackingNumber(@PathVariable Long trackingNumber) {
        return shipmentService.findShipmentByTrackingNumber(trackingNumber);
    }

    @PostMapping("/addshipment")
    public Shipment create(@RequestBody Shipment shipment) {
        return shipmentService.create(shipment);
    }

}
