package com.example.Dividend.persist;

import java.util.Optional;

import com.example.Dividend.persist.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findByUsername(String username);

    boolean existsByUsername(String username);
}
