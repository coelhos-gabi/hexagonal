package br.com.hexagonal.adapters.db;

import br.com.hexagonal.domain.entity.UserEntity;
import br.com.hexagonal.domain.valueobjects.Email;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(Email email);

    Page<UserEntity> findAll(Pageable pageable);
}
