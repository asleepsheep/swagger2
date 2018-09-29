package com.jf.swagger.controller;

import com.jf.swagger.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: jiangfan
 * @CreateTime 2018/9/29 上午10:46
 */
@Api("用户信息管理")
@RestController
@RequestMapping("/user/*")
public class UserController {

    private final static List<User> userList = new ArrayList<>();

    {
        userList.add(new User("1", "admin", "123456"));
        userList.add(new User("2", "tom", "111111"));
    }

    @ApiOperation("获取列表")
    @GetMapping("list")
    public List userList() {
        return userList;
    }

    @ApiOperation("新增用户")
    @PostMapping("save")
    public boolean save(User user) {
        return userList.add(user);
    }

    @ApiOperation("更新用户")
    @PutMapping("update")
    @ApiImplicitParam(name = "user", value = "单个用户信息", dataType = "User")
    public boolean update(User user) {
        return userList.remove(user) && userList.add(user);
    }

    @ApiOperation("批量删除")
    @ApiImplicitParam(name = "users", value = "多个用户信息", dataType = "List<Users>")
    @DeleteMapping("delete")
    public boolean delete(@RequestBody List<User> users) {
        return userList.removeAll(users);
    }
}
