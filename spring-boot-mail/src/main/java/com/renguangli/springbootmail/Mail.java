package com.renguangli.springbootmail;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Mail
 *
 * @author renguangli 2018/8/29 17:32
 * @since JDK 1.8
 */
@Entity
@Table(name = "sb_mail")
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    @Column(name = "send_to")
    private String to;

    private String subject;

    private String text;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendDate;

    private boolean success = true;

    private long sendTime;

    private String message = "邮件发送成功！";

    public Mail(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "id=" + id +
                ", username=" + username +
                ", to=" + to +
                ", subject=" + subject +
                ", text=" + text +
                ", sendDate=" + sendDate +
                ", success=" + success +
                ", sendTime=" + sendTime +
                ", message=" + message +
                "}";
    }
}
