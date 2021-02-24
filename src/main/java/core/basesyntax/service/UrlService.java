package core.basesyntax.service;

import core.basesyntax.model.Url;
import java.util.List;

public interface UrlService {
    Url create(Url url);

    Url get(Long id);

    List<Url> getAll();

    Url update(Url url);

    boolean delete(Long id);
}
