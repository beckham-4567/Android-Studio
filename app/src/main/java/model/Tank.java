package model;

public class Tank {
    private String name;
    private String country;
    private int rating;
    private String imageUrl;

    public Tank(String name, String country, int rating, String imageUrl) {
        this.name = name;
        this.country = country;
        this.rating = rating;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getRating() {
        return rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
