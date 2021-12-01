package glacialExpedition.repositories;

import glacialExpedition.models.states.StateImpl;

import java.util.Collection;
import java.util.List;

public class StateRepository implements Repository{

    private List<StateImpl> states;


    @Override
    public Collection getCollection() {
        return states;
    }

    @Override
    public void add(Object entity) {
        states.add((StateImpl) entity);

    }

    @Override
    public boolean remove(Object entity) {
        return states.remove(entity);
    }

    @Override
    public Object byName(String name) {
        for (StateImpl state : states) {
            if (state.getName().equals(name)){
                return state;
            }
        }
        return null;
    }
}
