package com.cong.filepathneo4j.repository;

import com.cong.filepathneo4j.pojo.Group;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends Neo4jRepository<Group, String> {
    Group findByName(@Param("name") String name);
}