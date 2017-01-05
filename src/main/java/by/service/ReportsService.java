package by.service;


import by.entity.ReportsEntity;

import java.util.List;
import java.util.Set;

public interface ReportsService  {

    ReportsEntity getById(int id);
    List<ReportsEntity> getAll();
    Set<String> getAllPerformers();
    List<ReportsEntity> getPerformersByDate(String date1, String date2, String performer);
}
