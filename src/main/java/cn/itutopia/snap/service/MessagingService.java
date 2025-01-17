package cn.itutopia.snap.service;

import cn.itutopia.snap.jpa.MessageRepository;
import cn.itutopia.snap.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Junchao_Lee
 * @e-mail: ljch867@163.com
 * @date: 2025/1/17 21:19
 */
@Service
public class MessagingService {

    @Autowired
    private MessageRepository messageRepository;

    public String sendMessage(Long sender, Long receiver, String content) {
        // 创建消息对象
        Message message = new Message(sender, receiver, content, Message.MessageType.TEXT);
        // 保存消息到数据库
        messageRepository.save(message);
        // 返回消息发送成功信息
        return "Message sent: " + message.getContent();
    }

    // 获取指定发送者和接收者之间的消息
    public List<Message> getMessages(Long sender, Long receiver) {
        return messageRepository.findBySenderAndReceiver(sender, receiver);
    }

    // 更新消息状态为已读
    public String markMessageAsRead(Long messageId) {
        Message message = messageRepository.findById(messageId).orElse(null);
        if (message != null) {
            message.setStatus(Message.MessageStatus.READ);
            messageRepository.save(message);  // 更新数据库中的消息
            return "Message marked as read.";
        }
        return "Message not found.";
    }

}
