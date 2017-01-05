package by.service.Impl;

import by.entity.ReportsEntity;
import by.repository.ReportsRepository;
import by.service.ReportsService;
import by.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ReportsServiceImpl implements ReportsService {

    @Autowired
    ReportsRepository reportsRepository;

    @Override
    @Transactional
    public ReportsEntity getById(int id) {
        return reportsRepository.findOne(id);
    }

    @Override
    public List<ReportsEntity> getAll() {
        return reportsRepository.findAll();
    }

    @Override
    public Set<String> getAllPerformers() {
        return reportsRepository.getPerformer();
    }

    @Override
    public List<ReportsEntity> getPerformersByDate(String date1, String date2, String performer) {

        Date dateStart = Util.getDateToString(date1);
        Date dateEnd = Util.getDateToString(date2);
        if (performer != null && !performer.equals("All Performers")) {
            return reportsRepository.getReportsFullQuery(dateStart, dateEnd, performer);
        } else
        {
            return reportsRepository.getReportsQueryTwoDate(dateStart, dateEnd);
        }
    }
}
