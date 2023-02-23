package com.sky.basic.repository;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.sky.basic.entity.BasicOperationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
@Transactional
public interface BasicOperationsRepository extends JpaRepository<BasicOperationsEntity, Long> {

}
