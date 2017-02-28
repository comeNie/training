package com.comenie.springboot.swagger.controller;

import com.comenie.springboot.swagger.entity.User;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by 波 on 2017/2/21.
 *  注解           	属性      	        值             	    备注
 *   @Api	        value	           字符串	    可用在class头上,class描述
 *                  description	       字符串
 *                                                  @Api(value = "xxx", description = "xxx")
 *
 *   @ApiOperation	value	           字符串	    可用在方法头上.参数的描述容器
 *                  notes	           字符串
 *                                                  @ApiOperation(value = "xxx", notes = "xxx")
 *   @ApiImplicitParams	{}	    @ApiImplicitParam数组	可用在方法头上.参数的描述容器
 *                                                  @ApiImplicitParams({@ApiImplicitParam1,@ApiImplicitParam2,...})
 *   @ApiImplicitParam name	           字符串 与参数命名对应	可用在@ApiImplicitParams里
 *                     value	       字符串	             参数中文描述
 *                     required	       布尔值	            true/false
 *                     dataType	       字符串	            参数类型
 *                     paramType	   字符串	            参数请求方式:query/path
 *                                                          query:对应@RequestParam?传递
 *                                                          path: 对应@PathVariable{}path传递
 *                     defaultValue    字符串	            在api测试中默认值
 *                                                           用例参见项目中的设置
 *   @ApiResponses	{}	        @ApiResponse数组	            可用在方法头上.参数的描述容器
 *                                                          @ApiResponses({@ApiResponse1,@ApiResponse2,...})
 *   @ApiResponse	code	            整形	                可用在@ApiResponses里
 *                  message	            字符串	            错误描述
 *                                                          @ApiResponse(code = 200, message = "Successful")
 *
 *
 *
 *
 */
@Api(value = "用户管理接口",description = "用户管理接口详情",tags = "用户")
@RestController
@RequestMapping("/users")
public class UserController {

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value={""}, method= RequestMethod.GET)
    public List<User> getUserList() {
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="", method=RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return "success";
    }
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }
    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }
    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }
}
