package com.basic.repository;

import javax.transaction.Transactional;

import com.basic.entity.BasicOperationsEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
@Transactional
public interface BasicOperationsRepository extends JpaRepository<BasicOperationsEntity, Long> {

}
