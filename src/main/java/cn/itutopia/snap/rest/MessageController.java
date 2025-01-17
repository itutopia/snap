package cn.itutopia.snap.rest;

import cn.itutopia.snap.model.Message;
import cn.itutopia.snap.model.MessageVO;
import cn.itutopia.snap.service.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: Junchao_Lee
 * @e-mail: ljch867@163.com
 * @date: 2025/1/17 20:33
 */
@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessagingService messagingService;

    @PostMapping("/send")
    public String sendMessage(@RequestBody MessageVO messageVO) {
        // 使用 MessagingService 发送消息
        return messagingService.sendMessage(messageVO.getSender(), messageVO.getReceiver(), messageVO.getContent());
    }

    // 获取指定发送者和接收者之间的消息
    @GetMapping("/history")
    public List<Message> getMessages(@RequestParam Long sender, @RequestParam Long receiver) {
        return messagingService.getMessages(sender, receiver);
    }

    // 标记消息为已读
    @PostMapping("/read")
    public String markMessageAsRead(@RequestParam Long messageId) {
        return messagingService.markMessageAsRead(messageId);
    }

}
