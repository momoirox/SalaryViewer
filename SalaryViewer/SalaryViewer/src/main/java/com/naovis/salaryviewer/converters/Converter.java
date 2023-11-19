package com.naovis.salaryviewer.converters;

import com.naovis.salaryviewer.entities.EntityBase;
import com.naovis.salaryviewer.models.Model;

import java.util.List;


public interface Converter<TEntity extends EntityBase, TModel extends Model> {

    /**
     * Converts from Entity to Model
     *
     * @param entity
     * @return Model
     */
    TModel convert(TEntity entity);

    /**
     * Converts from Model to Entity
     *
     * @param model
     * @return Entity
     */
    TEntity convert(TModel model);

    /**
     * Converts list of Entities to a list of Models
     * @param entities list that needs to be converted
     * @return models list
     */
    List<TModel> convert(List<TEntity> entities);

}
