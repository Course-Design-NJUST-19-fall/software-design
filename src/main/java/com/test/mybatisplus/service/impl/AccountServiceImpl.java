package com.test.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.mybatisplus.entity.Account;
import com.test.mybatisplus.enums.AccountServiceResultEnum;
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
    static final int MAX_LENGTH = 32;

    public AccountServiceResultEnum signUp(Account account){
        if(null != this.getById(account.getId()))
            return AccountServiceResultEnum.ID_ALREADY_EXISTS;
        if(MAX_LENGTH < account.getId().length())
            return AccountServiceResultEnum.ID_TOO_LONG;
        if(MAX_LENGTH < account.getNicoName().length())
            return  AccountServiceResultEnum.NICO_NAME_TOO_LONG;
        if(MAX_LENGTH < account.getPassword().length())
            return AccountServiceResultEnum.PASSWORD_TOO_LONG;

        this.save(account);
        return AccountServiceResultEnum.SUCCESS;
    }

    public AccountServiceResultEnum signIn(Account account){
        //数据库提取对应账号
        Account rightAccount = this.getById(account.getId());

        //检查正误
        if(null == rightAccount)
            return AccountServiceResultEnum.ID_NOT_EXISTS;
        if(!rightAccount.getPassword().equals(account.getPassword()))
            return AccountServiceResultEnum.PASSWORD_ERROR;
//        if(!rightAccount.getSort().equals(account.getSort()))
//            return AccountServiceResultEnum.SORT_ERROR;

        //为controller设置account类其余属性，controller可直接使用
        account.setNicoName(rightAccount.getNicoName());
        account.setPhoneNumber(rightAccount.getPhoneNumber());
        account.setListenMessage(rightAccount.getListenMessage());
        account.setSubmitNumber(rightAccount.getSubmitNumber());
        account.setAcceptNumber(rightAccount.getAcceptNumber());
        account.setRating(rightAccount.getRating());
        account.setClassId(rightAccount.getClassId());
        account.setSort(rightAccount.getSort());
        return  AccountServiceResultEnum.SUCCESS;
    }
    public Page<Account> getByPage(Integer page, Integer size){
        LambdaQueryWrapper<Account> accountLambdaQueryWrapper = Wrappers.lambdaQuery();
        accountLambdaQueryWrapper.orderByAsc(Account::getId);
        Page<Account> accountPage = new Page<>(page, size, true);
        this.page(accountPage, accountLambdaQueryWrapper);
        return accountPage;
    }
    public Page<Account> getRankByPage(Integer page, Integer size){
        LambdaQueryWrapper<Account> accountLambdaQueryWrapper = Wrappers.lambdaQuery();
        accountLambdaQueryWrapper.orderByDesc(Account::getRating);
        Page<Account> accountPage = new Page<>(page, size, true);
        this.page(accountPage, accountLambdaQueryWrapper);
        return accountPage;
    }

}
