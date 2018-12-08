package com.spi.timeSheet.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TIMESHEET")
public class TimeSheet {

    @Id
    @Column(name = "TIMESHEET_ID")
    private Long id;

    @OneToOne
    @JsonBackReference
    private User user;

    @OneToMany
    @Column(name = "TIME_SHEET_DATA")
    List<TimeSheetData> timeSheetData = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TimeSheetData> getTimeSheetData() {
        return timeSheetData;
    }

    public void setTimeSheetData(List<TimeSheetData> timeSheetData) {
        this.timeSheetData = timeSheetData;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
