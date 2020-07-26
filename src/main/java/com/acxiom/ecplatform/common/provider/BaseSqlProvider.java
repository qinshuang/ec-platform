package com.acxiom.ecplatform.common.provider;


import com.acxiom.ecplatform.common.annotation.Exclude;
import com.acxiom.ecplatform.common.annotation.PrimaryKey;
import com.acxiom.ecplatform.common.utils.MybatisUtil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.jdbc.SQL;

public class BaseSqlProvider<T> {
    public BaseSqlProvider() {
    }

    @Options
    public String add(T bean) {
        SQL sql = new SQL();
        Class clazz = bean.getClass();
        String tableName = clazz.getSimpleName();
        String realTableName = MybatisUtil.humpToLine(tableName).replaceAll("_entity", "").substring(1);
        sql.INSERT_INTO(realTableName);
        List<Field> fields = this.getFields(clazz);
        Iterator var7 = fields.iterator();

        while(var7.hasNext()) {
            Field field = (Field)var7.next();
            field.setAccessible(true);
            String column = field.getName();
            System.out.println("column:" + MybatisUtil.humpToLine(column));
            sql.VALUES(MybatisUtil.humpToLine(column), String.format("#{" + column + ",jdbcType=VARCHAR}"));
        }

        return sql.toString();
    }

    public String delete(T bean) {
        SQL sql = new SQL();
        Class clazz = bean.getClass();
        String tableName = clazz.getSimpleName();
        String realTableName = MybatisUtil.humpToLine(tableName).replaceAll("_entity", "").substring(1);
        sql.DELETE_FROM(realTableName);
        List<Field> primaryKeyField = this.getPrimarkKeyFields(clazz);
        if (primaryKeyField.isEmpty()) {
            sql.WHERE(" 1= 2");
            throw new RuntimeException("对象中未包含PrimaryKey属性");
        } else {
            Iterator var7 = primaryKeyField.iterator();

            while(var7.hasNext()) {
                Field pkField = (Field)var7.next();
                pkField.setAccessible(true);
                sql.WHERE(pkField.getName() + "=" + String.format("#{" + pkField.getName() + "}"));
            }

            return sql.toString();
        }
    }

    private List<Field> getPrimarkKeyFields(Class clazz) {
        List<Field> primaryKeyField = new ArrayList();
        List<Field> fields = this.getFields(clazz);
        Iterator var4 = fields.iterator();

        while(var4.hasNext()) {
            Field field = (Field)var4.next();
            field.setAccessible(true);
            PrimaryKey key = (PrimaryKey)field.getAnnotation(PrimaryKey.class);
            if (key != null) {
                primaryKeyField.add(field);
            }
        }

        return primaryKeyField;
    }

    private List<Field> getFields(Class clazz) {
        List<Field> fieldList = new ArrayList();
        Field[] fields = clazz.getDeclaredFields();
        Field[] var4 = fields;
        int var5 = fields.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Field field = var4[var6];
            field.setAccessible(true);
            Exclude key = (Exclude)field.getAnnotation(Exclude.class);
            if (key == null) {
                fieldList.add(field);
            }
        }

        return fieldList;
    }

    public String get(T bean) {
        SQL sql = new SQL();
        Class clazz = bean.getClass();
        String tableName = clazz.getSimpleName();
        String realTableName = MybatisUtil.humpToLine(tableName).replaceAll("_entity", "").substring(1);
        ((SQL)sql.SELECT("*")).FROM(realTableName);
        List<Field> primaryKeyField = this.getPrimarkKeyFields(clazz);
        if (primaryKeyField.isEmpty()) {
            sql.WHERE(" 1= 2");
            throw new RuntimeException("对象中未包含PrimaryKey属性");
        } else {
            Iterator var7 = primaryKeyField.iterator();

            while(var7.hasNext()) {
                Field pkField = (Field)var7.next();
                pkField.setAccessible(true);
                sql.WHERE(pkField.getName() + "=" + String.format("#{" + pkField.getName() + "}"));
            }

            System.out.println("getSql:" + sql.toString());
            return sql.toString();
        }
    }

    public String update(T bean) {
        SQL sql = new SQL();
        Class clazz = bean.getClass();
        String tableName = clazz.getSimpleName();
        String realTableName = MybatisUtil.humpToLine(tableName).replaceAll("_entity", "").substring(1);
        sql.UPDATE(realTableName);
        List<Field> fields = this.getFields(clazz);
        Iterator var7 = fields.iterator();

        while(var7.hasNext()) {
            Field field = (Field)var7.next();
            field.setAccessible(true);
            String column = field.getName();
            if (!column.equals("id")) {
                System.out.println(MybatisUtil.humpToLine(column));
                sql.SET(MybatisUtil.humpToLine(column) + "=" + String.format("#{" + column + ",jdbcType=VARCHAR}"));
            }
        }

        List<Field> primaryKeyField = this.getPrimarkKeyFields(clazz);
        if (primaryKeyField.isEmpty()) {
            sql.WHERE(" 1= 2");
            throw new RuntimeException("对象中未包含PrimaryKey属性");
        } else {
            Iterator var11 = primaryKeyField.iterator();

            while(var11.hasNext()) {
                Field pkField = (Field)var11.next();
                pkField.setAccessible(true);
                sql.WHERE(pkField.getName() + "=" + String.format("#{" + pkField.getName() + "}"));
            }

            System.out.println("updateSql:" + sql.toString());
            return sql.toString();
        }
    }
}
