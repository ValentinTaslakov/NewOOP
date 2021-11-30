package glacialExpedition.models.explorers;

import glacialExpedition.models.StringUtils;
import glacialExpedition.models.suitcases.Suitcase;

public abstract class BaseExplorer implements Explorer {
    private String name;
    private double energy;
    private Suitcase suitcase;

    public BaseExplorer(String name, double energy) {

        this.setName(name);
        this.setEnergy(energy);

    }

    public void setName(String name) {
        if (StringUtils.isNullOrEmpty(name)) {
            throw new NullPointerException("Explorer name cannot be null or empty.");
        }
        this.name = name;
    }

    public void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException("Cannot create Explorer with negative energy.");
        }
        this.energy = energy;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public boolean canSearch() {
        return this.energy > 0;
    }

    @Override
    public Suitcase getSuitcase() {
        return null;
    }

    @Override
    public void search() {

        this.energy -= 15;
        if (this.energy < 0) {
            this.energy = 0;
        }
    }
}
