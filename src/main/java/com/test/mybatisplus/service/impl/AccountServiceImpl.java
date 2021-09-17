package com.test.mybatisplus.service.impl;

import com.test.mybatisplus.entity.Account;
import com.test.mybatisplus.mapper.AccountMapper;
import com.test.mybatisplus.service.AccountService;
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
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

}
