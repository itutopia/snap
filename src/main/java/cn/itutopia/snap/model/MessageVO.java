package cn.itutopia.snap.model;

import lombok.Data;

/**
 * @description:
 * @author: Junchao_Lee
 * @e-mail: ljch867@163.com
 * @date: 2025/1/17 23:42
 */
@Data
public class MessageVO {

    private  Long sender;
    private  Long receiver;
    private  String content;
}
