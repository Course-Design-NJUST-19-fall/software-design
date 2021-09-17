package handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject,"submitTime", Timestamp.class,new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public void updateFill(MetaObject metaObject) {
//        this.setFieldValByName("submitTime",new Date(),metaObject);
//        this.strictUpdateFill(metaObject,"submitTime",Date.class,new Date());
    }
}
