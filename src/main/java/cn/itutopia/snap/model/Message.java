package cn.itutopia.snap.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: Junchao_Lee
 * @e-mail: ljch867@163.com
 * @date: 2025/1/17 21:21
 */
@Entity
@Table(name = "messages")  // 指定数据库中的表名
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long sender;    // 发送者
    private Long receiver;  // 接收者
    private String content;    // 消息内容
    private LocalDateTime timestamp; // 消息时间戳
    @Enumerated(EnumType.STRING)
    private MessageType messageType; // 消息类型（文本、图片等）
    @Enumerated(EnumType.STRING)
    private MessageStatus status;    // 消息状态（已读、未读）

    // 构造函数
    public Message(Long sender, Long receiver, String content, MessageType messageType) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.messageType = messageType;
        this.timestamp = LocalDateTime.now();
        this.status = MessageStatus.SENT;
    }

    public Message() {

    }

    // 枚举消息类型
    public enum MessageType {
        TEXT, IMAGE, FILE
    }

    // 消息状态枚举
    public enum MessageStatus {
        SENT, DELIVERED, READ
    }

    // getter 和 setter 方法

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public Long getReceiver() {
        return receiver;
    }

    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

}
