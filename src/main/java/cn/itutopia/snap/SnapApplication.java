package cn.itutopia.snap;

import cn.itutopia.snap.server.NettyServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 阅后即焚的IM应用
 * @author
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SnapApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SnapApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        new Thread(() -> {
            try {
                new NettyServer(8088).start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        }
}
