package com.renguangli.springbootmail;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Arrays;
import java.util.Date;

/**
 * Mail
 *
 * @author renguangli 2018/8/29 17:32
 * @since JDK 1.8
 */
public class Mail {

    private Integer mailId;

    private String username;

    private String[] to;

    private String subject;

    private String text;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendDate;

    private boolean success = true;

    private long sendTime;

    private int retry;

    public Mail(){}

    public Integer getMailId() {
        return mailId;
    }

    public void setMailId(Integer mailId) {
        this.mailId = mailId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String... to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public long getSendTime() {
        return sendTime;
    }

    public void setSendTime(long sendTime) {
        this.sendTime = sendTime;
    }

    public int getRetry() {
        return retry;
    }

    public void setRetry(int retry) {
        this.retry = retry;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "mailId=" + mailId +
                ", username=" + username +
                ", to=" + Arrays.toString(to) +
                ", subject=" + subject +
                ", text=" + text +
                ", sendDate=" + sendDate +
                ", success=" + success +
                ", sendTime=" + sendTime +
                ", retry=" + retry +
                "}";
    }
}
