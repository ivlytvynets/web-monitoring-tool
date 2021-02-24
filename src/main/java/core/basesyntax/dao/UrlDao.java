package core.basesyntax.dao;

import core.basesyntax.model.Url;
import java.util.List;
import java.util.Optional;

public interface UrlDao {
    Url create(Url url);

    Optional<Url> get(Long id);

    List<Url> getAll();

    Url update(Url url);

    boolean delete(Long id);
}
