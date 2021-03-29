package core.basesyntax.model;

public class Url {
    public static final int MIN_CONTENT_SIZE = 1;
    public static final int MAX_CONTENT_SIZE = 3;
    public static final int GOOD_PING = 200;
    public static final int WARNING_PING = 400;
    public static final int MIN_CODE_RESPONSE = 200;
    public static final int MAX_CODE_RESPONSE = 299;
    private Long id;
    private String urlName;
    private String status;
    private int ping;
    private int codeResponse;
    private float contentSize;

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

    public int getPing() {
        return ping;
    }

    public void setPing(int ping) {
        this.ping = ping;
    }

    public int getCodeResponse() {
        return codeResponse;
    }

    public void setCodeResponse(int codeResponse) {
        this.codeResponse = codeResponse;
    }

    public float getContentSize() {
        return contentSize;
    }

    public void setContentSize(float contentSize) {
        this.contentSize = contentSize;
    }

    @Override
    public String toString() {
        return "Url{"
                + "id=" + id
                + ", urlName='" + urlName + '\''
                + ", status='" + status + '\''
                + ", ping=" + ping
                + ", codeResponse=" + codeResponse
                + ", contentSize=" + contentSize
                + '}';
    }
}
