package com.micro.user.user_service.Repository;

import com.micro.user.user_service.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
