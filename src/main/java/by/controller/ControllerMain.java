package by.controller;

import by.entity.ReportsEntity;
import by.service.ReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;


@Controller
public class ControllerMain {

    @Autowired
    ReportsService reportsService;

    @RequestMapping("/index")
    public ModelAndView index(@RequestParam(value = "startDate", required = false, defaultValue = "Jan 1,1970") String paramStart,
                              @RequestParam(value = "endDate", required = false, defaultValue = "Dec 31,2100") String paramEnd,
                              @RequestParam(value = "perf", required = false) String paramPerfom,
                              @RequestParam(value = "push", required = false) String submit,
                              ModelAndView model) {
        if (submit != null) {
            List<ReportsEntity> entityList = reportsService.getPerformersByDate(paramStart, paramEnd, paramPerfom);
            model.addObject("entityList", entityList);
        }
        Set<String> listPerfomer = reportsService.getAllPerformers();
        model.addObject("performers", listPerfomer);
        model.setViewName("index");
        return model;
    }
}
