/**
 * Copyright (C), 2015-2020, LSTAR
 * FileName: FriendLinkRespository
 * Author:   OneStar
 * Date:     2020/3/12 21:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * oneStar           修改时间           版本号              描述
 */
package com.ydh.blogapi.dao;

import com.ydh.blogapi.po.FriendLink;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *

 * @create 2020/3/12
 * @since 1.0.0
 */
public interface FriendLinkRespository extends JpaRepository<FriendLink,Long> {

    FriendLink findByBlogname(String blogname);
}