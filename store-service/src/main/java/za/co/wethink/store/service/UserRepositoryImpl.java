package za.co.wethink.store.service;

import java.util.Optional;

import za.co.wethink.store.models.UserEntity;

public class UserRepositoryImpl implements UserRepository{

	private String key;

	public UserRepositoryImpl() {
		super();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public Optional<UserEntity> findByUsername(String username) {
		return Optional.ofNullable(new UserEntity(username, key));
	}

	@Override
	public Boolean existsByUsername(String username) {
		return true;
	}
}
