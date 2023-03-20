package com.cong.filepathneo4j.repository;

import com.cong.filepathneo4j.pojo.Organization;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends Neo4jRepository<Organization, String> {
    Organization findByName(@Param("name") String name);
}