package estm.dsic.jee.dal;

import java.util.List;


public interface Repository<T,I>{
       boolean create(T entity);
      // User auth(T entity);
       T find(I index);
       boolean delete(I index);
       boolean update(T entity , I index);
       List<T> getAll();
      // boolean validateUser(I index);
}
