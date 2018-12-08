package com.spi.timeSheet.dao;

import com.spi.timeSheet.model.TimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSheetDao extends JpaRepository<TimeSheet,Long> {
}
