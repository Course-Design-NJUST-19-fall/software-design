package com.test.mybatisplus.mapper;

import com.test.mybatisplus.entity.TestRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author team
 * @since 2021-09-16
 */
@Component("testRecordMapper")
public interface TestRecordMapper extends BaseMapper<TestRecord> {

}
