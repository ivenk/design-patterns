import java.util.List;

public interface IRepository<T> {
    T getById();
    List<T> getList();
    void add(T entity);
    void delete(T entity);
    void edit(T entity);
}
