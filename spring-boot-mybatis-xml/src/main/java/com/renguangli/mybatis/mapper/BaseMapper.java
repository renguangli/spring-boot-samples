package com.renguangli.mybatis.mapper;

import java.util.List;

/**
 * BaseMapper
 *
 * @author renguangli 2018/8/31 17:39
 * @since JDK 1.8
 */
public interface BaseMapper<T, ID> {

    T get(ID id);

    List<T> list();

    int save(T pojo);

    int batchSave(List<T> pojos);

    int delete(ID id);

    int batchDelete(ID[] ids);

    int update(T pojo);
}
