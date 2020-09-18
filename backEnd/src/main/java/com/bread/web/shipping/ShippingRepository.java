package com.bread.web.shipping;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShippingRepository extends JpaRepository<Shipping, Long>, CustomShippingRepository {
    List<Shipping> findByShippingName(String shippingName);
}
