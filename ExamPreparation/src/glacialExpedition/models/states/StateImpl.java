package glacialExpedition.models.states;

import glacialExpedition.models.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StateImpl implements State {
    private String name;
    private List<String> exhibits;

    public StateImpl(String name) {
        this.setName(name);
        this.exhibits = new ArrayList<>();
    }

    private void setName(String name) {

        if (StringUtils.isNullOrEmpty(name)) {
            throw new NullPointerException("Invalid name!");
        }
        this.name = name;
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
