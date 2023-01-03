package com.example.jpql.repository;

import com.example.jpql.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Test extends JpaRepository<Member, Long> {

    @Query("select m from Member m where m.age > (select avg(m2.age) from Member m2)")
    List<Member> queryAll();
    
}
