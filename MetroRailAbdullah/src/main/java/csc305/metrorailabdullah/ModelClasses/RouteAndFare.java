package csc305.metrorailabdullah.ModelClasses;

import java.io.Serializable;

public class RouteAndFare implements Serializable {

    private String source, destination, routeOption, departTime;
    private float fares;

    public RouteAndFare(String source, String destination, String routeOption, String departTime, float fares) {
        this.source = source;
        this.destination = destination;
        this.routeOption = routeOption;
        this.departTime = departTime;
        this.fares = fares;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getRouteOption() {
        return routeOption;
    }

    public void setRouteOption(String routeOption) {
        this.routeOption = routeOption;
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public float getFares() {
        return fares;
    }

    public void setFares(float fares) {
        this.fares = fares;
    }

    @Override
    public String toString() {
        return "RouteAndFare{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", routeOption='" + routeOption + '\'' +
                ", departTime='" + departTime + '\'' +
                ", fares=" + fares +
                '}';
    }
}
