package com.example.mobilefix.repository;

import com.example.mobilefix.model.RepairOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairOrderRepository extends JpaRepository<RepairOrder,Long> {
}
