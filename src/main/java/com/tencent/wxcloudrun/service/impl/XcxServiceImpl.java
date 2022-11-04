package com.tencent.wxcloudrun.service.impl;

import com.google.common.collect.Lists;
import com.tencent.wxcloudrun.config.Page;
import com.tencent.wxcloudrun.dao.UserMapper;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.XcxUserService;
import com.tencent.wxcloudrun.service.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Service
public class XcxServiceImpl implements XcxUserService {


    final UserMapper userMapper;

    public XcxServiceImpl(@Autowired UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public boolean addUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        user.setLifeImage(covertImageListToString(userDto.getLifeImageList()));
        Integer integer = userMapper.addUser(user);
        if(integer.equals(1)){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(Long id) {
        Integer integer = userMapper.deleteUser(id);
        if(integer.equals(1)){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(UserDto userDto) {
        if(Objects.isNull(userDto) || Objects.isNull(userDto.getId())){
            return false;
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        user.setLifeImage(covertImageListToString(userDto.getLifeImageList()));
        Integer integer = userMapper.updateUser(user);
        if(integer.equals(1)){
            return true;
        }
        return false;
    }

    @Override
    public UserDto getUser(Long userId) {
        User user = userMapper.getUser(userId);
        if(Objects.isNull(user)){
            return null;
        }
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user,userDto);
        userDto.setLifeImageList(covertImageToImagelist(user.getLifeImage()));
        if (!CollectionUtils.isEmpty(userDto.getLifeImageList())) {
            userDto.setLifeImage(userDto.getLifeImageList().get(0));
        }
        return userDto;
    }

    @Override
    public List<UserDto> getUserList(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        List<User> userList = userMapper.getUserList(user);
        return covertUserList(userList);
    }

    @Override
    public Page<UserDto> pageUserList(Integer pageNum, Integer pageSize, UserDto userDto) {
        pageNum = pageNum == null || pageNum == 0 ? 1 : pageNum;
        pageSize = pageSize == null || pageSize == 0 ? 10 : pageSize;
        Integer totalPageNum = 0;
        Page<UserDto> topicVoPage = new Page<>(pageNum, pageSize);
        topicVoPage.setPageTotal(totalPageNum);
        if(Objects.isNull(userDto)){
            return topicVoPage;
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        totalPageNum  = userMapper.countUserPageList(pageNum, pageSize, user);
        List<User> userPageList = userMapper.getUserPageList(pageNum, pageSize, user);
        topicVoPage.setList(covertUserList(userPageList));
        return topicVoPage;
    }

    private List<UserDto> covertUserList(List<User> user){
        List<UserDto> userDtoList = Lists.newArrayList();
        user.stream().forEach(k -> {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(k,userDto);
            userDto.setLifeImageList(covertImageToImagelist(k.getLifeImage()));
            userDtoList.add(userDto);
        });
        return userDtoList;
    }

    private List<String> covertImageToImagelist(String image){
            if (Objects.isNull(image) || image.equals("")) {
                return null;
            }
            String[] split = image.split(",");
            if(split == null || split.length == 0){
                return null;
            }
            return Lists.newArrayList(split);

    }
    public static String covertImageListToString(List<String> imageList){
        if(CollectionUtils.isEmpty(imageList)){
            return "";
        }
        StringBuilder image = new StringBuilder();
        imageList.stream().forEach(k -> image.append(k).append(","));
        return image.substring(0,image.length()-1);
    }
}
