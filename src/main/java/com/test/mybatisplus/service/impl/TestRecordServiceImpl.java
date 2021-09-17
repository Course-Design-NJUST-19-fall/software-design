package com.test.mybatisplus.service.impl;

import com.test.mybatisplus.entity.TestRecord;
import com.test.mybatisplus.mapper.TestRecordMapper;
import com.test.mybatisplus.service.TestRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author team
 * @since 2021-09-16
 */
@Service
public class TestRecordServiceImpl extends ServiceImpl<TestRecordMapper, TestRecord> implements TestRecordService {

}
