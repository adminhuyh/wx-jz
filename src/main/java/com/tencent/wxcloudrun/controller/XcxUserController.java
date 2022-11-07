package com.tencent.wxcloudrun.controller;


import com.google.common.collect.Lists;
import com.tencent.wxcloudrun.config.Page;
import com.tencent.wxcloudrun.config.RestResultData;
import com.tencent.wxcloudrun.controller.request.PageUserParam;
import com.tencent.wxcloudrun.controller.request.RequsetUserParam;
import com.tencent.wxcloudrun.dto.CounterRequest;
import com.tencent.wxcloudrun.service.XcxUserService;
import com.tencent.wxcloudrun.service.dto.UserDto;
import com.tencent.wxcloudrun.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/xcx/api")
public class XcxUserController {

    final Logger logger;

    @Autowired
    private XcxUserService xcxService;

    public XcxUserController() {
        this.logger = LoggerFactory.getLogger(CounterController.class);
    }
    /**
     *
     */
    @GetMapping(value = "/getUser")
    RestResultData getUserInfo(@RequestParam Long userId) {
        UserVo userVo = new UserVo();
        UserDto user = xcxService.getUser(userId);
        if (Objects.isNull(user)){
            return RestResultData.failed("用户不存在");
        }
        BeanUtils.copyProperties(user,userVo);
        return RestResultData.successed(userVo);
    }

    /**
     *
     */
    @PostMapping(value = "/addUser")
    RestResultData addUserInfo(@RequestBody RequsetUserParam userParam) {
        //return RestResultData.successed(true);
//        System.out.println("userParam="+userParam);
//        return RestResultData.successed(true);
        if(Objects.isNull(userParam.getPhoneNumber()) || "".equals(userParam.getPhoneNumber())){
            return RestResultData.failed("手机号码不能为空");
        }
        splitAddress(userParam);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userParam,userDto);

        boolean b = xcxService.addUser(userDto);
        return RestResultData.successed(b);
    }

    /**
     *
     */
    @PostMapping(value = "/updateUser")
    RestResultData updateUserInfo(@RequestBody RequsetUserParam userParam) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userParam,userDto);
        boolean b = xcxService.updateUser(userDto);
        return RestResultData.successed(b);
    }


    /**
     *
     */
    @GetMapping(value = "/deleteUser")
    RestResultData deleteUserInfo(@RequestParam Long userId) {
        boolean b = xcxService.deleteUser(userId);
        return RestResultData.successed(b);
    }

    /**
     *
     */
    @PostMapping(value = "/getUserList")
    RestResultData<Page<UserVo>> getUserInfoList(@RequestBody PageUserParam pageUserParam) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(pageUserParam,userDto);
        Page userDtoPage = xcxService.pageUserList(pageUserParam.getPageNum(), pageUserParam.getPageSize(), userDto);
        List<UserDto> list = userDtoPage.getList();
        if(CollectionUtils.isEmpty(list)){
            RestResultData.successed();
        }
        List<UserVo> userVoList = Lists.newArrayList();
        list.stream().forEach(k -> {
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(k,userVo);
            if (!CollectionUtils.isEmpty(userVo.getLifeImageList())) {
                userVo.setMainImage(userVo.getLifeImageList().get(0));
            }
            userVoList.add(userVo);
        });
        userDtoPage.setList(userVoList);
        return RestResultData.successed(userDtoPage);
    }



    private RequsetUserParam splitAddress(RequsetUserParam userParam){
        List<String> workAddress = userParam.getWorkAddress();
        if (!CollectionUtils.isEmpty(workAddress)) {
             if (workAddress.size()>0) {
                 userParam.setWorkProvinceName(workAddress.get(0));
             }
             if (workAddress.size()>1){
                 userParam.setWorkCityName(workAddress.get(1));
             }
             if (workAddress.size()>2){
                 userParam.setWorkAreaName(workAddress.get(2));
             }
        }
        List<String> nativeAddress = userParam.getNativeAddress();
        if (!CollectionUtils.isEmpty(nativeAddress)) {
            if (nativeAddress.size()>0) {
                userParam.setNativeProvinceName(nativeAddress.get(0));
            }
            if (nativeAddress.size()>1){
                userParam.setNativeCityName(nativeAddress.get(1));
            }
            if (nativeAddress.size()>2){
                userParam.setNativeAreaName(nativeAddress.get(2));
            }
        }
        return userParam;
    }




}
