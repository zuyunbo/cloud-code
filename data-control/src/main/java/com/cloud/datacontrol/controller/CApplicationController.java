package com.cloud.datacontrol.controller;


import com.cloud.datacontrol.conf.SimpleBatchHandler;
import com.cloud.datacontrol.entity.CApplication;
import com.cloud.datacontrol.entity.parm.CApplicationParam;
import com.cloud.datacontrol.service.CApplicationService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * ${comments}
 *
 * @author 2u c1111
 * @since 1.0 2021-01-27
 */
@RestController
@RequestMapping("/api/cApplication")
public class CApplicationController {
    @Autowired
    private CApplicationService cApplicationService;


    @Autowired
    private SimpleBatchHandler simpleBatchHandler;

    @GetMapping("page")
    public Object page(CApplicationParam queryParam) {
        simpleBatchHandler.startHandle();
        PageInfo pageInfo = cApplicationService.pageQuery(queryParam);

        return pageInfo;
    }

    @DeleteMapping(value = "/{id}")
    public Object remove(@PathVariable long id) {
        int result = cApplicationService.remove(id);

        if (result > 0) {
            return result;
        } else {
            return result;
        }
    }


    @PostMapping(value = "/save")
    public Object save(@RequestBody CApplication entity) {
        int result = cApplicationService.save(entity);

        if (result > 0) {
            return result;
        } else {
            return result;
        }
    }

    @PutMapping(value = "/update")
    public Object update(@RequestBody CApplication entity) {
        int result = cApplicationService.update(entity);

        if (result > 0) {
            return result;
        } else {
            return result;
        }
    }


    @GetMapping(value = "/{id}/detail")
    public Object detail(@PathVariable long id) {
        CApplication entity = cApplicationService.getById(id);
        return entity;
    }


}
