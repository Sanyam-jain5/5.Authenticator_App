package com.example.authenticatorapp;

public class Image {
    private String title;
    private String i_d;
    private String albumId;
    private String thumbnailUrl;
    private String ImageURL;

    public Image() {}
    public Image(String title, String id, String albumId, String thumbnailUrl, String imageURL) {
        this.title = title;
        this.i_d = id;
        this.albumId = albumId;
        this.thumbnailUrl = thumbnailUrl;
        ImageURL = imageURL;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setI_d(String i_d) {
        this.i_d = i_d;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public String getI_d() {
        return i_d;
    }

    public String getAlbumId() {
        return albumId;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getImageURL() {
        return ImageURL;
    }
}
