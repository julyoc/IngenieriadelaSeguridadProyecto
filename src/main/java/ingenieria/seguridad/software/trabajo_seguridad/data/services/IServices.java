package ingenieria.seguridad.software.trabajo_seguridad.data.services;

import java.util.List;

public interface IServices<T> {
    public List<T> getAll();

    public void save(T data);

    public void delete(T data);

    public T getById(T data);

    public T getById(long id);
}
