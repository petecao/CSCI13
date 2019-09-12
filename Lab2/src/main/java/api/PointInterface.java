package api;

import src.Point;

public interface PointInterface {
    double getX();

    double getY();

    double distance(Point p);

    @Override
    String toString();
}
