package za.ac.cput.Service;

import org.springframework.stereotype.Service;

@Service
public interface IService<T,ID> {
    T  create(T t);
    T read(ID id);
    T update(T t);
}
