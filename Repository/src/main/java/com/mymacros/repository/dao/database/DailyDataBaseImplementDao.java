package com.mymacros.repository.dao.database;


import com.mymacros.repository.dao.entity.DailyEntity;
import com.mymacros.repository.dao.entity.DailyRepositoryDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;


/**
 * @author Tomas Yussef
 */
@Repository
public class DailyDataBaseImplementDao implements DailyRepositoryDao
{
     private Session session;

     @Inject
     public DailyDataBaseImplementDao(Session session)
     {
          this.session = session;
     }

     /**
      * <h1>getAllDaily</h1>
      * <p>Se obtienen todos lo usuarios de la base de datso</p>
      *
      * @return Retorna una lista del objecto DailyDto
      */
     @Override
     @SuppressWarnings("unchecked")
     public List<DailyEntity> getAllDaily(long idDaily)
     {
          return (List<DailyEntity>)
                  this.session.createQuery("from DailyEntity where DailyEntity.id = :idUser")
                  .setParameter("idUser", idDaily)
                  .list();
     }

     /**
      * <h1>getDaily</h1>
      * <p>Se obtiene un objecto especifico de la base de datos</p>
      *
      * @param id Este parametro es el valor del id de objecto que se quiere obtener
      * @return El objecto que se obtuvo de la base detos
      */
     @Override
     public DailyEntity getDaily(long id) {
          return this.session.load(DailyEntity.class, id);
     }

     /**
      * <h1>createDaily</h1>
      * <p>Se almacena un objeto DailyDto a la base de datos</p>
      *
      * @param dailyEntity entidad que sera almacenado en la base de datos
      */
     @Override
     public void createDaily(DailyEntity dailyEntity)
     {
          this.session.save(dailyEntity);
     }

     /**
      * <h1>deleteDaily</h1>
      * <p>Elimina un objeto diario de la base de datos</p>
      *
      * @param id indetificador de la entidad que sera eliminada
      */
     @Override
     public void deleteDaily(long id)
     {
          DailyEntity dailyEntity = this.session.load(DailyEntity.class, id);
          if (dailyEntity != null)
               this.session.remove(id);
     }

     /**
      * <h1>updateDaily</h1>
      * <p>Actualiza un objeto de la base de datos</p>
      *
      * @param dailyEntity entidad que contendra los datos actualizados
      */
     @Override
     public void updateDaily(DailyEntity dailyEntity)
     {
         if (this.session.load(DailyEntity.class, dailyEntity.getId()) != null)
             this.session.update(dailyEntity);
     }
}
