package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.Collection;
import java.util.List;

public class ExplorerRepository implements Repository{
    private List<Explorer> explorers;



    @Override
    public Collection getCollection() {
        return null;
    }

    @Override
    public void add(Object entity) {
        explorers.add((Explorer) entity);
    }

    @Override
    public boolean remove(Object entity) {
        return false;
    }

    @Override
    public Object byName(String name) {
        return null;
    }
}
