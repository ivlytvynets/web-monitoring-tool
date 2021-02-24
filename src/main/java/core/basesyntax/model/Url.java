package core.basesyntax.model;

public class Url {
    private Long id;
    private String urlName;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Url{"
                + "id=" + id
                + ", urlName='" + urlName + '\''
                + ", status='" + status + '\''
                + '}';
    }
}
