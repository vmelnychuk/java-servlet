package model;

public class UrlVisiting {
    int userId;
    String url;
    int count = 0;

    public UrlVisiting(int userId, String url, int count) {
        this.userId = userId;
        this.url = url;
        this.count = count;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
