package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.Collection;
import java.util.List;

public class ExplorerRepository implements Repository{
    private List<Explorer> explorers;



    @Override
    public Collection getCollection() {
        return this.explorers;
    }

    @Override
    public void add(Object entity) {

        explorers.add((Explorer) entity);
    }

    @Override
    public boolean remove(Object entity) {

        return explorers.remove(entity);

    }

    @Override
    public Object byName(String name) {
        for (Explorer explorer : explorers) {
            if (explorer.getName().equals(name)) {

                return explorer;
            }
        }
        return null;
    }
}
