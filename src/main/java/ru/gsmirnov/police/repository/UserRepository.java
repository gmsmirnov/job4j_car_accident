package ru.gsmirnov.police.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gsmirnov.police.model.User;

/**
 * The repository which provides access to {@link User} entities in data base.
 *
 * @author Gregory Smirnov (gsmirnov <gsmirnov@callinsight.ru>)
 * @version 0.1
 * @since 2020-06-21
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}