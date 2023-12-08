/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group1.dao;

import java.util.List;

/**
 *
 * @author numpa
 */
abstract public class CafeDAO<EntityType, KeyType> {
    abstract public void insert(EntityType entity);

    abstract public void update(EntityType entity);

    abstract public void delete(KeyType id);
    

    abstract public EntityType selectById(KeyType id);
    abstract public List<EntityType> FindById(KeyType id);

    abstract public List<EntityType> selectAll();

    abstract protected List<EntityType> selectBySQL(String sql, Object... args);
    
    abstract public void Xoa(int mact, KeyType manl);
}
