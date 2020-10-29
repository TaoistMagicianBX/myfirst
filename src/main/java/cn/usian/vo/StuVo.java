package cn.usian.vo;

import cn.usian.pojo.Student;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class StuVo  extends Student {


    private Date startTime;

    private Date endTime;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
