package cn.itutopia.snap.jpa;

import cn.itutopia.snap.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: Junchao_Lee
 * @e-mail: ljch867@163.com
 * @date: 2025/1/17 21:57
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    // 查询某个发送者和接收者的所有消息
    @Query("SELECT m FROM Message m WHERE m.sender = :sender AND m.receiver = :receiver")
    List<Message> findBySenderAndReceiver(Long sender, Long receiver);

    // 根据消息状态查询
    List<Message> findByStatus(Message.MessageStatus status);

}
