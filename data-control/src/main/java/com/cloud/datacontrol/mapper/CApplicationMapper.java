package com.cloud.datacontrol.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.datacontrol.entity.CApplication;
import com.cloud.datacontrol.entity.parm.CApplicationParam;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 *
 * @author 2u c1111
 * @since 1.0 2021-01-27
 */
@Repository
public interface CApplicationMapper extends BaseMapper<CApplication> {


    List<CApplication> listQuery(CApplicationParam queryParam);

}
