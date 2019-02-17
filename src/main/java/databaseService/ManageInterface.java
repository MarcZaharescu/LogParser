package databaseService;

import java.util.List;

public interface ManageInterface<T> {

    void add(T t);

    List<T> findAll();

}

