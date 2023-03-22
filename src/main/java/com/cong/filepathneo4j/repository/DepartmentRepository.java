package com.cong.filepathneo4j.repository;

import com.cong.filepathneo4j.po.Department;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends Neo4jRepository<Department, String> {
    Department findByName(@Param("name") String name);
}