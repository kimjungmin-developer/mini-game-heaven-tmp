package com.olbimacoojam.heaven.yutnori.point;

import com.olbimacoojam.heaven.yutnori.Route;
import com.olbimacoojam.heaven.yutnori.yut.Yut;

public interface Point {

    default void findRoute(Route route, Yut yut) {
        route.add(this);

        if (yut.isBackDo()) {
            route.add(getPreviousPoint());
        }

        if (yut.canMove(route)) {
            Point nextPoint = findNextDestination(route, yut);
            nextPoint.findRoute(route, yut);
        }
    }

    default void addInflectPoint(Point inflectionPoint) {
        throw new UnsupportedOperationException();
    }

    Point findNextDestination(Route route, Yut yut);

    Point getPreviousPoint();

    PointName getPointName();

    int getPosition();

    default boolean isRightDiagonal() {
        return false;
    }

    void makeConnection(Point previousPoint, Point nextPoint);

    Point getNextPoint();

    default Point getInflectPoint() {
        throw new UnsupportedOperationException();
    }

    ;
}

