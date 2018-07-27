package ar.com.tecnosoftware.somos.user.repository;

import ar.com.tecnosoftware.somos.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Serializable> {

    public abstract UserEntity findByUserName(String username);
}
