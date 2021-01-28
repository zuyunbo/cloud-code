package com.cloud.datacontrol.service.impl;


import com.cloud.datacontrol.entity.CApplication;
import com.cloud.datacontrol.entity.parm.CApplicationParam;
import com.cloud.datacontrol.mapper.CApplicationMapper;
import com.cloud.datacontrol.service.CApplicationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${comments}
 *
 * @author 2u c1111
 * @since 1.0 2021-01-27
 */
@Service
public class CApplicationServiceImpl implements CApplicationService {


    @Autowired
    CApplicationMapper cApplicationMapper;

    @Override
    public int save(CApplication entity) {
        return cApplicationMapper.insert(entity);
    }

    @Override
    public int update(CApplication entity) {

        return cApplicationMapper.updateById(entity);
    }

    @Override
    public int remove(Long id) {

        return cApplicationMapper.deleteById(id);
    }

    @Override
    public CApplication getById(Long id) {


        return cApplicationMapper.selectById(id);
    }

    @Override
    public PageInfo<CApplication> pageQuery(CApplicationParam queryParam) {
        return PageHelper.startPage(queryParam.getPn(), queryParam.getPs())
                .doSelectPageInfo(() -> cApplicationMapper.listQuery(queryParam));
    }

    @Override
    public List<CApplication> listQuery(CApplicationParam queryParam) {
        return cApplicationMapper.listQuery(queryParam);
    }
}
