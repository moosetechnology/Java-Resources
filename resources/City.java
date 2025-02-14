package resources;

import java.util.ArrayList;

public class City<B extends Building> {

    ArrayList<B> buildings = new ArrayList<>();

    public City(){
    }

    public ArrayList<B> getBuildings() {
        return buildings;
    }

    public void addBuilding(B building) {
        this.buildings.add(building);
    }
}