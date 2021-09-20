package com.test.mybatisplus.mapper;

import com.test.mybatisplus.entity.Problem;
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
@Component("problemMapper")
public interface ProblemMapper extends BaseMapper<Problem> {

}
