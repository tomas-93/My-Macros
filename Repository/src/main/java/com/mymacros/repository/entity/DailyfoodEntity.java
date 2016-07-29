package com.mymacros.repository.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Tomas on 29/07/2016.
 */
@Entity
@Table(name = "dailyfood", schema = "mymacros")
public class DailyfoodEntity
{
    private long id;
    private int numberFood;
    private Timestamp time;
    private DailyEntity dailyByIdDaily;

    @Id
    @Column(name = "id", nullable = false)
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "numberFood", nullable = false)
    public int getNumberFood()
    {
        return numberFood;
    }

    public void setNumberFood(int numberFood)
    {
        this.numberFood = numberFood;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public Timestamp getTime()
    {
        return time;
    }

    public void setTime(Timestamp time)
    {
        this.time = time;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DailyfoodEntity that = (DailyfoodEntity) o;

        if (id != that.id) return false;
        if (numberFood != that.numberFood) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + numberFood;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idDaily", referencedColumnName = "id")
    public DailyEntity getDailyByIdDaily()
    {
        return dailyByIdDaily;
    }

    public void setDailyByIdDaily(DailyEntity dailyByIdDaily)
    {
        this.dailyByIdDaily = dailyByIdDaily;
    }
}
