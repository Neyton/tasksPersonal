package by.repository;


import by.entity.ReportsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface ReportsRepository extends JpaRepository<ReportsEntity, Integer> {

    @Query(value = "select performer from reports;", nativeQuery = true)
    Set<String> getPerformer();

    @Query(value = "select * from reports where start >= ? and end <= ?;", nativeQuery = true)
    List<ReportsEntity> getReportsQueryTwoDate(Date date1, Date date2);

    @Query(value = "select * from reports where start >= ? and end <= ? and performer = ?;", nativeQuery = true)
    List<ReportsEntity> getReportsFullQuery(Date dateStart, Date dateEnd, String performer);

}
