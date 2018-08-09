package com.blog.param;

import java.io.Serializable;
import java.util.Date;

public class GetReadStatisticsParam implements Serializable {
    private Date startTime;
    private Date finishTime;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }
}
