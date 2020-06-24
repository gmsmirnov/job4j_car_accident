package ru.gsmirnov.police.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gsmirnov.police.model.Authority;

/**
 * The repository which provides access to {@link Authority} entities in data base.
 *
 * @author Gregory Smirnov (gsmirnov <gsmirnov@callinsight.ru>)
 * @version 0.1
 * @since 2020-06-21
 */
public interface AuthorityRepository extends CrudRepository<Authority, Integer> {
    /**
     * Finds an authority in database by the specified authority name.
     *
     * @param authorityName the specified authority name.
     * @return an authority which is mapped to the specified authority name.
     */
    Authority findByAuthorityName(String authorityName);
}