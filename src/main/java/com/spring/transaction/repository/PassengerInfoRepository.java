package com.spring.transaction.repository;

import com.spring.transaction.entity.PasengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository<PasengerInfo,Long> {
}
