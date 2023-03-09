/**
 * Copyright (C), 2015-2020, LSTAR
 * FileName: FriendLinkServiceImpl
 * Author:   OneStar
 * Date:     2020/3/12 21:37
 * Description: 友链接口实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * oneStar           修改时间           版本号              描述
 */
package com.ydh.blogapi.service;

import com.ydh.blogapi.NotFoundException;
import com.ydh.blogapi.dao.FriendLinkRespository;
import com.ydh.blogapi.po.FriendLink;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Fish 23-03-07
 */
@Service
public class FriendLinkServiceImpl implements FriendLinkService {

    @Autowired
    private FriendLinkRespository friendLinkRespository;

    @Transactional
    @Override
    public List<FriendLink> listFriendlinks() {
        return friendLinkRespository.findAll();
    }

    @Transactional
    @Override
    public FriendLink saveFriendLink(FriendLink friendLink) {
        return friendLinkRespository.save(friendLink);
    }

    @Transactional
    @Override
    public FriendLink getFriendLink(Long id) {
        return friendLinkRespository.getOne(id);
    }

    @Transactional
    @Override
    public Page<FriendLink> listFriendLink(Pageable pageable) {
        Sort sort = Sort.by(Sort.Direction.DESC,"createTime");
        return friendLinkRespository.findAll(pageable);
    }

    @Transactional
    @Override
    public FriendLink updateFriendLink(Long id, FriendLink friendLink) {
        FriendLink F = friendLinkRespository.getOne(id);
        if(F == null){
            throw new NotFoundException("不存在该友链");
        }
        BeanUtils.copyProperties(friendLink,F);
        return friendLinkRespository.save(F);
    }

    @Transactional
    @Override
    public void deleteFriendLink(Long id) {
        friendLinkRespository.deleteById(id);
    }
}