package csc305.metrorailabdullah.ModelClasses;

import java.io.Serializable;

public class Schedule implements Serializable {
    private RouteAndFare route;
    private String source, destination, routeOption, departTime, status;
    private float fares;

    public Schedule(RouteAndFare route, String status) {
        this.route = route;
        this.source = this.route.getSource();
        this.destination = this.route.getDestination();
        this.routeOption = this.route.getRouteOption();
        this.departTime = this.route.getDepartTime();
        this.status = status;
        this.fares = this.route.getFares();
    }

    public RouteAndFare getRoute() {
        return route;
    }

    public void setRoute(RouteAndFare route) {
        this.route = route;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getFares() {
        return fares;
    }

    public void setFares(float fares) {
        this.fares = fares;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "route=" + route +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", routeOption='" + routeOption + '\'' +
                ", departTime='" + departTime + '\'' +
                ", status='" + status + '\'' +
                ", fares=" + fares +
                '}';
    }
}
