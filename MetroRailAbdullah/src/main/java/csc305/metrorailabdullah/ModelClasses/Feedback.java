package csc305.metrorailabdullah.ModelClasses;

import java.io.Serializable;

public class Feedback implements Serializable {
    private String route, rating, comment;

    public Feedback(String route, String rating, String comment) {
        this.route = route;
        this.rating = rating;
        this.comment = comment;
    }

    public Feedback(String route, String rating) {
        this.route = route;
        this.rating = rating;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "route='" + route + '\'' +
                ", rating='" + rating + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
