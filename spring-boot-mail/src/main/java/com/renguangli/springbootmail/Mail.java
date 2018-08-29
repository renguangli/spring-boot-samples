package com.renguangli.springbootmail;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
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

    public Mail(){}

    public Mail(Integer mailId, String username, String[] to, String subject, String text, Date sendDate, boolean success) {
        this.mailId = mailId;
        this.username = username;
        this.to = to;
        this.subject = subject;
        this.text = text;
        this.sendDate = sendDate;
        this.success = success;
    }

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

    @Override
    public String toString() {
        return "Mail{" +
                "mailId=" + mailId +
                ", username=" + username +
                ", to=" + to +
                ", subject=" + subject +
                ", text=" + text +
                ", sendDate=" + sendDate +
                ", success=" + success +
                "}";
    }
}
