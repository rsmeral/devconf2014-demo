package rsmeral.devconf2014.demo;

import java.util.Date;

public class SimpleTweet {

    private String username;
    private Date postedAt;
    private String avatarUrl;
    private String text;

    public SimpleTweet() {
    }

    public SimpleTweet(String username, Date postedAt, String avatarUrl, String text) {
        this.username = username;
        this.postedAt = postedAt;
        this.avatarUrl = avatarUrl;
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.username != null ? this.username.hashCode() : 0);
        hash = 71 * hash + (this.postedAt != null ? this.postedAt.hashCode() : 0);
        hash = 71 * hash + (this.text != null ? this.text.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SimpleTweet other = (SimpleTweet) obj;
        if ((this.username == null) ? (other.username != null) : !this.username.equals(other.username)) {
            return false;
        }
        if (this.postedAt != other.postedAt && (this.postedAt == null || !this.postedAt.equals(other.postedAt))) {
            return false;
        }
        if ((this.text == null) ? (other.text != null) : !this.text.equals(other.text)) {
            return false;
        }
        return true;
    }

}
