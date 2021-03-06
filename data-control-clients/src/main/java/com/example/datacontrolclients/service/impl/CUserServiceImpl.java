package com.example.datacontrolclients.service.impl;



import com.cloud.datacontrol.entity.CUser;
import com.example.datacontrolclients.entity.parm.CUserParam;
import com.example.datacontrolclients.mapper.CUserMapper;
import com.example.datacontrolclients.service.CUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${comments}
 *
 * @author 2u c1111
 * @since 1.0 2021-01-25
 */
@Service
public class CUserServiceImpl implements CUserService {


    @Autowired
    CUserMapper cUserMapper;

    @Override
    public int save(CUser entity) {
        return cUserMapper.insert(entity);
    }

    @Override
    public int update(CUser entity) {

        return cUserMapper.updateById(entity);
    }

    @Override
    public int remove(Long id) {
        if (id == null || id == 0L) {
            // 自己定义的异常方法
        }
        return cUserMapper.deleteById(id);
    }

    @Override
    public CUser getById(Long id) {
        if (id == null || id == 0L) {
            // 自己定义的异常方法
        }

        return cUserMapper.selectById(id);
    }

    @Override
    public PageInfo<CUser> pageQuery(CUserParam queryParam) {
        return PageHelper.startPage(queryParam.getPn(), queryParam.getPs())
                .doSelectPageInfo(() -> cUserMapper.listQuery(queryParam));
    }


    @Override
    public List<CUser> listQuery(CUserParam queryParam) {
        return cUserMapper.listQuery(queryParam);
    }
}
