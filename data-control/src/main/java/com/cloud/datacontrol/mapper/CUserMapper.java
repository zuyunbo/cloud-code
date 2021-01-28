package com.cloud.datacontrol.mapper;




import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.datacontrol.entity.CUser;
import com.cloud.datacontrol.entity.parm.CUserParam;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 *
 * @author 2u c1111
 * @since 1.0 2021-01-25
 */
@Repository
public interface CUserMapper extends BaseMapper<CUser> {


    List<CUser> listQuery(CUserParam queryParam);

}
