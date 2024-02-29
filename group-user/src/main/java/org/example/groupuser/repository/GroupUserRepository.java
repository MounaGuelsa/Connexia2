package org.example.groupuser.repository;

import org.example.groupuser.entity.GroupUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupUserRepository extends JpaRepository<GroupUser,Long> {
    List<GroupUser> findByDeletedFalse();
    List<GroupUser> findGroupUserByUserId(Long userId);
}
