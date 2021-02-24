package core.basesyntax.service.impl;

import core.basesyntax.dao.UrlDao;
import core.basesyntax.exception.DataProcessingException;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Url;
import core.basesyntax.service.UrlService;
import java.util.List;

public class UrlServiceImpl implements UrlService {
    @Inject
    private UrlDao urlDao;

    @Override
    public Url create(Url url) {
        return urlDao.create(url);
    }

    @Override
    public Url get(Long id) {
        return urlDao.get(id).orElseThrow(() ->
                new DataProcessingException("Can't get url with id: " + id));
    }

    @Override
    public List<Url> getAll() {
        return urlDao.getAll();
    }

    @Override
    public Url update(Url url) {
        return urlDao.update(url);
    }

    @Override
    public boolean delete(Long id) {
        return urlDao.delete(id);
    }
}
