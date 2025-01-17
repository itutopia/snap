package cn.itutopia.snap.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @description:
 * @author: Junchao_Lee
 * @e-mail: ljch867@163.com
 * @date: 2025/1/17 19:04
 */
public class IMHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        // 这里处理消息，例如将消息广播到其他客户端，或是保存到数据库
        System.out.println("收到消息: " + msg);
        // 发送回应消息
        ctx.writeAndFlush("消息已收到: " + msg);
    }

}
