package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {

    private static final double ENERGY = 60;

    public NaturalExplorer(String name) {
        super(name, ENERGY);
    }

    @Override
    public void search() {
        double energy = super.getEnergy();
        energy -= 7;
        if (energy < 0) {
            energy = 0;
        }
        super.setEnergy(energy);
    }
}
