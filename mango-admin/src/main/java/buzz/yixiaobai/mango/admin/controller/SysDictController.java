package buzz.yixiaobai.mango.admin.controller;

import buzz.yixiaobai.mango.admin.model.SysDict;
import buzz.yixiaobai.mango.admin.server.ISysDictService;
import buzz.yixiaobai.mango.core.http.HttpResult;
import buzz.yixiaobai.mango.core.page.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
@RestController
@RequestMapping("dict")
public class SysDictController {

    @Resource // 注入Service
    public ISysDictService sysDictService;

    /**
     * 通过画面插入数据
     * @param sysDict
     * @return
     */
    @PostMapping("/save")
    public HttpResult save(@RequestBody SysDict sysDict){
        return HttpResult.ok(sysDictService.save(sysDict));
    }

    /**
     * 删除数据
     * @param sysDict
     * @return
     */
    @PostMapping("/delete")
    public HttpResult delete(@RequestBody SysDict sysDict){
        return HttpResult.ok(sysDictService.delete(sysDict));
    }

    /**
     * 分页查询
     * @return
     */
    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest){
        return HttpResult.ok(sysDictService.findPage(pageRequest));
    }

    /**
     * 通过 label查询
     * @param label
     * @return
     */
    @PostMapping("/findByLabel")
    public HttpResult findByLabel(@RequestBody String label){
        return HttpResult.ok(sysDictService.findByLabel(label));
    }
}
