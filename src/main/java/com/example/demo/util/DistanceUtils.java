package com.example.demo.util;

public class DistanceUtils {
    private static final double EARTH_RADIUS = 6371000.0; // meters

    public static int distanceToBarrier(
            double trainLat,
            double trainLon,
            double barrierLat,
            double barrierLon) {

        double lat1 = Math.toRadians(trainLat);
        double lon1 = Math.toRadians(trainLon);

        double lat2 = Math.toRadians(barrierLat);
        double lon2 = Math.toRadians(barrierLon);

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a =
                Math.sin(dLat / 2) * Math.sin(dLat / 2)
                        + Math.cos(lat1) * Math.cos(lat2)
                        * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.asin(Math.sqrt(a));

        return (int)(EARTH_RADIUS * c);
    }
}
