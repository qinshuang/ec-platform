//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.acxiom.ecplatform.common.mapper;

import com.acxiom.ecplatform.common.provider.BaseSqlProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

public interface BaseMapper<T> {
    @InsertProvider(
            method = "add",
            type = BaseSqlProvider.class
    )
    @Options(
            useGeneratedKeys = true
    )
    int add(T bean);

    @DeleteProvider(
            method = "delete",
            type = BaseSqlProvider.class
    )
    int delete(T bean);

    @SelectProvider(
            method = "get",
            type = BaseSqlProvider.class
    )
    T get(T bean);

    @UpdateProvider(
            method = "update",
            type = BaseSqlProvider.class
    )
    int update(T bean);
}
