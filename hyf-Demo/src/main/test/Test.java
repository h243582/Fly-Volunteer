import com.heyufei.demo.Application;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= Application.class)  //启动启动类
public class Test {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @org.junit.jupiter.api.Test
    public void testSend(){
        rabbitTemplate.convertAndSend("itcast","我要红包");
    }
}
