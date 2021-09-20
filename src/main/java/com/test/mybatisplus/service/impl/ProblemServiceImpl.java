package com.test.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.mybatisplus.entity.Account;
import com.test.mybatisplus.entity.Problem;
import com.test.mybatisplus.entity.TestRecord;
import com.test.mybatisplus.enums.ResultEnum;
import com.test.mybatisplus.mapper.ProblemMapper;
import com.test.mybatisplus.service.ProblemService;
import com.test.mybatisplus.tool.JudgeHost;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

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
    static final String codeAndProgramPath = "/home/codes/";
    static final String codeFileName = "code.cpp";

    @Resource
    private TestRecordServiceImpl testRecordService;
    @Resource
    private AccountServiceImpl accountService;

    public void ProblemJudge(Integer problemId, Account submitter, String code){
        //获取相关信息，初始化
        TestRecord testRecord = new TestRecord(null,problemId,submitter.getId());
        Problem problem = this.getById(problemId);
        if(null == problem)
            return;

        //存储代码文件
        File codeFile = ProblemServiceImpl.generateDirectionAndFile();
        if(null == codeFile)
            return;
        if(!ProblemServiceImpl.writeCodeToFile(codeFile, code))
            return;
        //judge
        JudgeHost judgeHost = new JudgeHost(problem, codeFile);
        if(!judgeHost.startJudge(testRecord))
            return;

        //数据更新,扫尾
        testRecordService.save(testRecord);
        submitter.addSubmitNumber(1);
        problem.addSubmitNumber(1);
        if(ResultEnum.ACCEPT==testRecord.getResult()) {
            problem.addAcceptNumber(1);
            submitter.addAcceptNumber(1);
            submitter.addRating(problem.getRating());
        }
        this.updateById(problem);
        accountService.updateById(submitter);
    }

    static private boolean writeCodeToFile(File codeFile, String code){
        try{
            if(!codeFile.exists())
                if(!codeFile.createNewFile())
                    return false;
            if(!codeFile.canWrite())
                return false;

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(codeFile));
            bufferedWriter.write(code);
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    static private File generateDirectionAndFile(){
        File dir = new File(codeAndProgramPath + LocalDateTime.now().toString().replace(' ','-').replace(':','-'));
        if(!dir.mkdir())
            return null;

        return new File(dir.getAbsolutePath() + "/" + codeFileName);
    }
}
