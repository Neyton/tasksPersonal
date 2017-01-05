package by.entity;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "reports", schema = "dbtestpro")
public class ReportsEntity {
    private int id;
    private Date start;
    private Date end;
    private String performer;
    private String activity;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "start", nullable = true)
    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    @Basic
    @Column(name = "end", nullable = true)
    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Basic
    @Column(name = "performer", nullable = true, length = 45)
    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    @Basic
    @Column(name = "activity", nullable = true, length = 45)
    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReportsEntity that = (ReportsEntity) o;

        if (id != that.id) return false;
        if (start != null ? !start.equals(that.start) : that.start != null) return false;
        if (end != null ? !end.equals(that.end) : that.end != null) return false;
        if (performer != null ? !performer.equals(that.performer) : that.performer != null) return false;
        if (activity != null ? !activity.equals(that.activity) : that.activity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        result = 31 * result + (performer != null ? performer.hashCode() : 0);
        result = 31 * result + (activity != null ? activity.hashCode() : 0);
        return result;
    }
}
