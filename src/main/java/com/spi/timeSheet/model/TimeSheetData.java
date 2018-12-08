package com.spi.timeSheet.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TIME_SHEET_DATA")
public class TimeSheetData {

    @Id
    @Column(name = "TIME_SHEET_DATA_ID")
    private Long id;

    @Column(name = "DAY_OF_YEAR")
    private LocalDate dayOfYear;

    @Column(name = "ABSENT")
    private boolean absent;

    @Column(name = "HALF_DAY")
    private boolean halfDay;

    @ManyToOne
    private TimeSheet timeSheet;

    public LocalDate getDayOfYear() {
        return dayOfYear;
    }

    public void setDayOfYear(LocalDate dayOfYear) {
        this.dayOfYear = dayOfYear;
    }

    public boolean isAbsent() {
        return absent;
    }

    public void setAbsent(boolean absent) {
        this.absent = absent;
    }

    public boolean isHalfDay() {
        return halfDay;
    }

    public void setHalfDay(boolean halfDay) {
        this.halfDay = halfDay;
    }
}
