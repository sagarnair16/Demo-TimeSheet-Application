package com.spi.timeSheet.controller;

//import com.spi.timeSheet.model.TimeSheet;
import com.spi.timeSheet.dao.UserDao;
import com.spi.timeSheet.model.TimeSheet;
import com.spi.timeSheet.model.TimeSheetData;
import com.spi.timeSheet.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

@RestController
@RequestMapping("/v1")
public class Boundaries {

    @Autowired
    UserDao userDao;


    @RequestMapping("/ping")
    public String test() {
        return "pong";
    }

    @RequestMapping("/getExampleUser")
    public User exampleUser(){

        User user = new User();
        user.setName("Sagar");
        user.setContact("123");
        user.setPassword("password");

        userDao.save(user);

        TimeSheet timeSheet = new TimeSheet();
        timeSheet.setUser(user);

        TimeSheetData timeSheetData = new TimeSheetData();
        timeSheetData.setAbsent(true);
        timeSheetData.setDayOfYear(LocalDate.now().minusDays(2));
        timeSheetData.setHalfDay(false);


        TimeSheetData timeSheetData1 = new TimeSheetData();
        timeSheetData1.setAbsent(true);
        timeSheetData1.setDayOfYear(LocalDate.now().minusDays(1));
        timeSheetData1.setHalfDay(false);

        timeSheet.setTimeSheetData(new ArrayList<>(Arrays.asList(
                timeSheetData,
                timeSheetData1
        )));

        user.setTimeSheet(timeSheet);

        return user;
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user){
        System.out.println(user.toString());
        return user;
    }
}
