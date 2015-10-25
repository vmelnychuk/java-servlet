package service;

import model.UrlVisiting;

import java.util.ArrayList;
import java.util.List;

public class HintServiceCollection implements HintService {
    private List<UrlVisiting> visits;

    public HintServiceCollection() {
        visits = new ArrayList<UrlVisiting>();
    }

    public List<UrlVisiting> getVisits() {
        return visits;
    }

    public void setVisits(List<UrlVisiting> visits) {
        this.visits = visits;
    }

    @Override
    public void add(UrlVisiting visit) {

    }
}
