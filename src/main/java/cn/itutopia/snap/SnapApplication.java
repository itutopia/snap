package cn.itutopia.snap;

import cn.itutopia.snap.config.NettyConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 阅后即焚的IM应用
 * @author
 */
@SpringBootApplication
public class SnapApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnapApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(NettyConfig nettyConfig) {
        return args -> {
            // 启动 Netty 服务器
            new Thread(() -> {
                try {
                    nettyConfig.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        };
    }
}
