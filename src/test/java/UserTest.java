
import com.alibaba.fastjson.JSONArray;
import com.blog.applocation.Application;
import com.blog.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserTest {

    @Resource
    UserService userService;
    @Test
    public void testGetAllUser(){
        System.out.print("*********************"+JSONArray.toJSONString(userService.getAllUser()));
    }


}