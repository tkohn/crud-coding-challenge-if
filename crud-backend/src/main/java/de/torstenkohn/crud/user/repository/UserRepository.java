package de.torstenkohn.crud.user.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import de.torstenkohn.crud.user.model.User;

public interface UserRepository extends ElasticsearchRepository<User, String> {

}
