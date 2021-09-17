package mapper;

import entity.Account;
import enums.SortsEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = com.test.mybatisplus.MybatisplusApplication.class)
class AccountMapperTest {
     @Autowired
         private AccountMapper mapper;
     @Test
    void test(){
         mapper.selectList(null).forEach(System.out::println);
     }
     @Test
    void save(){
         Account account = new Account("lxc","123456","my son",SortsEnum.STUDENT,"15902351277", SortsEnum.STUDENT,false);
         mapper.insert(account);
         mapper.selectList(null).forEach(System.out::println);
     }
}