package databaseService;

import java.util.List;

/** Interface to implement the basic functions required.
 *  The other CRUD methods were not needed thus ommitted.
 *
 * @param <T> generic list of datatype T
 */
public interface ManageInterface<T> {

    void add(T t);

    List<T> findAll();

}

