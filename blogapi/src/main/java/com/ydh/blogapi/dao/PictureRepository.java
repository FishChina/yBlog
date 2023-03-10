/**
 * Copyright (C), 2015-2020, LSTAR
 * FileName: PictureRepository
 * Author:   OneStar
 * Date:     2020/3/20 9:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * oneStar           修改时间           版本号              描述
 */
package com.ydh.blogapi.dao;


import com.ydh.blogapi.po.Picture;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *

 * @create 2020/3/20
 * @since 1.0.0
 */
public interface PictureRepository extends JpaRepository<Picture,Long> {
    List<Picture> findAll(Sort Sort);
}