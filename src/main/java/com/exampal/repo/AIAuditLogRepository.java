package com.exampal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exampal.model.AIAuditLog;

@Repository
public interface AIAuditLogRepository extends JpaRepository<AIAuditLog, Long> {
    List<AIAuditLog> findByTypeOrderByTimestampDesc(String type);
}