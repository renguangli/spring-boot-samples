package com.renguangli.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * BaseMapper
 *
 * @author renguangli 2018/8/31 17:39
 * @since JDK 1.8
 */
public interface BaseMapper<T, ID> {

    T get(@Param("id") ID id);

    List<T> list();

    int save(@Param("pojo") T pojo);

    int batchSave(@Param("pojos")List<T> pojos);

    int delete(@Param("id") ID id);

    int batchDelete(@Param("ids") ID[] ids);

    int update(@Param("pojo") T pojo);
}
