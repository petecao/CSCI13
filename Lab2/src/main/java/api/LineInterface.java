package api;

import src.Point;

public interface LineInterface {
    void add(Point p);

    void clear();

    double length();

    int size();
}
