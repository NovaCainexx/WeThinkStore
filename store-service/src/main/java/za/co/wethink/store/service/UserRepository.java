package za.co.wethink.store.service;

import java.util.Optional;

import za.co.wethink.store.models.UserEntity;


public interface UserRepository {
	Optional<UserEntity> findByUsername(String username);
	Boolean existsByUsername(String username);
}
