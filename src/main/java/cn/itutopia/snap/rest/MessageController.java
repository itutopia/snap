package cn.itutopia.snap.rest;

import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: Junchao_Lee
 * @e-mail: ljch867@163.com
 * @date: 2025/1/17 20:33
 */
@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        // 这里模拟消息的发送，实际上你会在 Netty 服务器中处理和广播消息
        return "消息已发送: " + message;
    }
}
