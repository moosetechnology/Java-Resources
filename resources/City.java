package resources;

public class City<B extends Building> {

    B[] buildings;

    public City(B[] buildings) {
        this.buildings = buildings;
    }

    public B[] getBuildings() {
        return buildings;
    }
}