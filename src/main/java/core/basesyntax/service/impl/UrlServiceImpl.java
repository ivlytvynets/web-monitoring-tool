package core.basesyntax.service.impl;

import core.basesyntax.dao.UrlDao;
import core.basesyntax.exception.DataProcessingException;
import core.basesyntax.lib.Inject;
import core.basesyntax.lib.Service;
import core.basesyntax.model.Url;
import core.basesyntax.service.UrlService;
import java.util.List;

@Service
public class UrlServiceImpl implements UrlService {
    @Inject
    private UrlDao urlDao;

    @Override
    public Url create(Url url) {
        if (url.getPing() > Url.GOOD_PING && url.getPing() <= Url.WARNING_PING) {
            url.setStatus("WARNING");
        } else if (url.getCodeResponse() < Url.MIN_CODE_RESPONSE
                || url.getCodeResponse() > Url.MAX_CODE_RESPONSE
                || url.getPing() > Url.WARNING_PING
                || url.getContentSize() < Url.MIN_CONTENT_SIZE
                && url.getContentSize() > Url.MAX_CONTENT_SIZE) {
            url.setStatus("CRITICAL");
        } else {
            url.setStatus("OK");
        }
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
