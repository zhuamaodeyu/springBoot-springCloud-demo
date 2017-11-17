package com.springboot.demo.controller;

import com.springboot.demo.domain.User;
import com.springboot.demo.repository.UserRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


//此注解是专为 REST ful API 设计的注解，其封装的是 Controller ResponseBody 注解
/**
 * IndexController class
 *
 * @author niezi
 * @date 2017/11/15
 */
@RestController
@Api(value = "product 商品操作API")
@RequestMapping("/product")
public class IndexController {

    /**
     * 1. 获取列表
     * 2. 显示单个的信息
     * 3. 添加
     * 4. 更新
     * 5. 删除
     */

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    /**
     * value 对应的是接口名称
     * notes 对应的是接口描述
     */
    @ApiOperation(value = "首页",notes = "测试代码", tags = {"测试服务是否正常"}, response = String.class)
    public  String index()
    {
        return  "index";
    }


    @GetMapping("/list")
    @ApiOperation(value = "获取全部数据列表", notes = "获取数据列表")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    public Iterable list()
    {
        return  userRepository.findAll();
    }

    @GetMapping("/get_user_message")
    @ApiOperation(value = "获取用户详情信息", notes = "根据用户ID 来获取用户的详细信息")
    @ApiImplicitParam(name = "userId",value = "用户ID",defaultValue = "1",required = true,dataType = "String")
    public User getUserMessage(String userId)
    {
        return  userRepository.findOne(userId);
    }


    @PostMapping("/save")
    @ApiOperation(value = "保存用户数据")
    @ApiImplicitParam(name = "user", value = "用户对象",required = true, dataTypeClass = User.class)
    public String save(@RequestBody User user)
    {
        if (user == null)
        {
            return  "false";
        }
        user.setUuid(UUID.randomUUID());
        userRepository.save(user);
        return  "true";
    }

    @PutMapping("/update/{userId}")
    @ApiOperation(value = "更新用户数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户的ID", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "user", value = "用户对象", required = true, dataTypeClass = User.class)
    })

    public ResponseEntity updateUserMessage(@PathVariable String userId, @RequestBody User user)
    {
        User user1 = userRepository.findOne(userId);
        user1.setAddress(user.getAddress());


        userRepository.save(user1);
        return  new ResponseEntity("更新数据成功", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    @ApiOperation(value = "根据用户ID 删除用户数据")
    @ApiImplicitParam(name = "删除用户数据",value = "",required = true, dataType = "String")
    public  ResponseEntity deleteUser(@PathVariable String userId)
    {
        userRepository.delete(userId);
        return new ResponseEntity("删除用户数据", HttpStatus.OK);
    }




}
