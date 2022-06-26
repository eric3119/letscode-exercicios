package repository;

import java.util.List;

import models.BaseModel;

public interface BaseRepository<ModelType extends BaseModel<IDType>, IDType> {

    default void save(ModelType entity) {
        persist(entity);
    }

    void persist(ModelType entity);

    void update(ModelType entity);

    ModelType getById(IDType id);

    List<ModelType> getAll();

    void delete(ModelType entity);

}
