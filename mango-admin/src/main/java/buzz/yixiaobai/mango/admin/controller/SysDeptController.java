package buzz.yixiaobai.mango.admin.controller;

import buzz.yixiaobai.mango.admin.model.SysDept;
import buzz.yixiaobai.mango.admin.server.ISysDeptService;
import buzz.yixiaobai.mango.core.http.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 机构管理 前端控制器
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
@RestController
@RequestMapping("dept")
public class SysDeptController {

    @Resource
    private ISysDeptService sysDeptService;

    /**
     * 保存
     * @param record
     * @return
     */
    @PostMapping("/save")
    public HttpResult save(@RequestBody SysDept record){
        return HttpResult.ok(sysDeptService.save(record));
    }

    /**
     * 删除
     * @param records
     * @return
     */
    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysDept> records){
        return HttpResult.ok(sysDeptService.delete(records));
    }

    /**
     * 部门树
     * @return
     */
    @PostMapping("/findTree")
    public HttpResult findTree(){
        return HttpResult.ok(sysDeptService.findTree());
    }

}
