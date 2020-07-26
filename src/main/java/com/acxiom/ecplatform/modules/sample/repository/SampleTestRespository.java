package com.acxiom.ecplatform.modules.sample.repository;

import java.util.List;
import java.util.Map;

import com.acxiom.ecplatform.modules.sample.domain.SampleTestEO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface SampleTestRespository extends JpaRepository<SampleTestEO, Long>, JpaSpecificationExecutor {

    @Query(value = " select id,name,type from user_test where name = ?1 ", nativeQuery = true)
    List<Map<String,Object>> getUserByName(String name);
}
