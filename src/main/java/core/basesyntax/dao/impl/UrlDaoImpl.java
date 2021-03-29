package core.basesyntax.dao.impl;

import core.basesyntax.dao.UrlDao;
import core.basesyntax.exception.DataProcessingException;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Url;
import core.basesyntax.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Dao
public class UrlDaoImpl implements UrlDao {
    @Override
    public Url create(Url url) {
        String queryInsert = "INSERT INTO urls (url_name, status, ping, code_response, "
                + "content_size) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement stInsert = connection.prepareStatement(queryInsert,
                        Statement.RETURN_GENERATED_KEYS);) {
            stInsert.setString(1, url.getUrlName());
            stInsert.setString(2, url.getStatus());
            stInsert.setInt(3, url.getPing());
            stInsert.setInt(4, url.getCodeResponse());
            stInsert.setFloat(5, url.getContentSize());
            stInsert.execute();
            ResultSet resultSet = stInsert.getGeneratedKeys();
            if (resultSet.next()) {
                url.setId(resultSet.getObject("GENERATED_KEY", Long.class));
            }
            return url;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't insert url to database: "
                    + url.getUrlName(), e);
        }
    }

    @Override
    public Optional<Url> get(Long id) {
        String querySelectUrl = "SELECT * FROM urls WHERE id=?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement stSelect = connection.prepareStatement(querySelectUrl)) {
            Url url = null;
            stSelect.setLong(1, id);
            ResultSet resultSet = stSelect.executeQuery();
            if (resultSet.next()) {
                url = getUrlFromResultSet(resultSet);
            }
            return Optional.ofNullable(url);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't select url with id: " + id, e);
        }
    }

    @Override
    public List<Url> getAll() {
        String querySelectAll = "SELECT * FROM urls";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement stSelectAll = connection.prepareStatement(querySelectAll)) {
            List<Url> urls = new ArrayList<>();
            ResultSet resultSet = stSelectAll.executeQuery();
            while (resultSet.next()) {
                urls.add(getUrlFromResultSet(resultSet));
            }
            return urls;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all urls", e);
        }
    }

    @Override
    public Url update(Url url) {
        String queryUpdate = "UPDATE urls SET urlName=?, status=?, ping=?, code_response=?, "
                + "content_size=? WHERE id=?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement stUpdate = connection.prepareStatement(queryUpdate)) {
            stUpdate.setString(1, url.getUrlName());
            stUpdate.setString(2, url.getStatus());
            stUpdate.setInt(3, url.getPing());
            stUpdate.setInt(4, url.getCodeResponse());
            stUpdate.setFloat(5, url.getContentSize());
            stUpdate.setLong(6, url.getId());
            stUpdate.executeUpdate();
            return url;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update url: " + url, e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String queryDelete = "UPDATE urls SET deleted=TRUE WHERE id=?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement stDelete = connection.prepareStatement(queryDelete)) {
            stDelete.setLong(1, id);
            return stDelete.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete url with id: " + id, e);
        }
    }

    private Url getUrlFromResultSet(ResultSet resultSet) throws SQLException {
        Url url = new Url();
        url.setId(resultSet.getObject("id", Long.class));
        url.setUrlName(resultSet.getString("url_name"));
        url.setStatus(resultSet.getString("status"));
        url.setPing(resultSet.getObject("ping", Integer.class));
        url.setCodeResponse(resultSet.getObject("code_response", Integer.class));
        url.setContentSize(resultSet.getObject("content_size", Float.class));
        return url;
    }
}
