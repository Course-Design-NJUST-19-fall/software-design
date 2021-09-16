package service.impl;

import entity.Problem;
import mapper.ProblemMapper;
import service.ProblemService;
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
public class ProblemServiceImpl extends ServiceImpl<ProblemMapper, Problem> implements ProblemService {

}
