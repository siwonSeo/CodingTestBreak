class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        Set<Point> container = new HashSet<>();
        // add each rectangle area to totalArea
        int totalArea = 0;
        // A rectangle has four points, if a point appears twice, it will be deleted it from the set
        for (int[] rectangle : rectangles) {
            totalArea += (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);
            Point p1 = new Point(rectangle[0], rectangle[1]);
            Point p2 = new Point(rectangle[2], rectangle[1]);
            Point p3 = new Point(rectangle[2], rectangle[3]);
            Point p4 = new Point(rectangle[0], rectangle[3]);
            if (container.contains(p1)) container.remove(p1);
            else container.add(p1);
            if (container.contains(p2)) container.remove(p2);
            else container.add(p2);
            if (container.contains(p3)) container.remove(p3);
            else container.add(p3);
            if (container.contains(p4)) container.remove(p4);
            else container.add(p4);
        }
        // A perfect rectangle must has four points
        if (container.size() != 4) return false;

        // these four points represent the last perfect rectangle, check this rectangle area to the totalArea
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        Iterator<Point> iter = container.iterator();
        while (iter.hasNext()) {
            Point p = iter.next();
            minX = Math.min(minX, p.x);
            maxX = Math.max(maxX, p.x);
            minY = Math.min(minY, p.y);
            maxY = Math.max(maxY, p.y);
        }
        return totalArea == (maxX - minX) * (maxY - minY);
    }

    private class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point Point = (Point) o;
            return x == Point.x &&
                    y == Point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}