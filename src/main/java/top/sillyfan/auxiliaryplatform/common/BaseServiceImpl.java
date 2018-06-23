package top.sillyfan.auxiliaryplatform.common;

import org.springframework.transaction.annotation.Transactional;
import top.sillyfan.auxiliaryplatform.dao.mapper.BaseMapper;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

public class BaseServiceImpl<T, I extends Serializable, E extends BaseMapper>
        implements BaseService<T, I, E> {

    protected E repository;

    /**
     * @param repository the repository to set
     */
    public void setRepository(E repository) {
        this.repository = repository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = false)
    public T create(T resource) {
        repository.insertSelective(resource);
        return resource;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = false)
    public T update(T resource) {
        repository.updateByPrimaryKeySelective(resource);
        return resource;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = false)
    public T updateSelective(T resource) {
        repository.updateByPrimaryKeySelective(resource);
        return resource;
    }

    /**
     * save resource data
     *
     * @param id
     * @param resource
     * @return resource saved
     */
    @Override
    @Transactional(readOnly = false)
    public T saveSelective(I id, T resource) {

        if (Objects.isNull(id)) {

            create(resource);

        } else {
            updateSelective(resource);
        }
        return resource;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(I id) {
        repository.deleteByPrimaryKey(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public T findOne(I id) {

        T entity = (T) repository.selectByPrimaryKey(id);
        return entity;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<T> getOne(I id) {

        T entity = (T) repository.selectByPrimaryKey(id);

        return Optional.ofNullable(entity);
    }

}
