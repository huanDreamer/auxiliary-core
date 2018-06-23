package top.sillyfan.auxiliaryplatform.common;

import top.sillyfan.auxiliaryplatform.dao.mapper.BaseMapper;

import java.io.Serializable;
import java.util.Optional;


public interface BaseService<T, I extends Serializable, M extends BaseMapper> {

    /**
     * Create new resource.
     *
     * @param resource Resource to create
     * @return new resource
     */
    T create(T resource);

    /**
     * Update existing resource.
     *
     * @param resource Resource to update
     * @return resource updated
     */
    T update(T resource);

    T updateSelective(T resource);

    /**
     * save resource data
     *
     * @param id
     * @param resource
     * @return resource saved
     */
    T saveSelective(I id, T resource);

    /**
     * Delete existing resource.
     *
     * @param id Resource id
     */
    void delete(I id);

    /**
     * Find resource by id.
     *
     * @param id Resource id
     * @return resource
     */
    T findOne(I id);

    /**
     * Find resource by id
     *
     * @param id Resource id
     * @return
     */
    Optional<T> getOne(I id);
}
