package core.basesyntax.controller;

import core.basesyntax.lib.Injector;
import core.basesyntax.model.Url;
import core.basesyntax.service.UrlService;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("core.basesyntax");
    private static UrlService urlService = (UrlService) injector.getInstance(UrlService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        Url url1 = new Url();
        long start1 = System.currentTimeMillis();
        URL url_1 = new URL("http://www.google.com");
        long finish1 = System.currentTimeMillis();
        HttpURLConnection connection = (HttpURLConnection) url_1.openConnection();
        url1.setCodeResponse(connection.getResponseCode());
        url1.setPing((int) (finish1 - start1));
        url1.setUrlName("http://www.google.com");
        url1.setContentSize(1.5f);
        urlService.create(url1);
        List<Url> urls = urlService.getAll();
        req.setAttribute("urls", urls);
        req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
    }
}
