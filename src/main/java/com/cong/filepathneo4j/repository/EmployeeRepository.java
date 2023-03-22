package com.cong.filepathneo4j.repository;

import com.cong.filepathneo4j.po.Employee;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends Neo4jRepository<Employee, String> {
    Employee findByName(@Param("name") String name);
}