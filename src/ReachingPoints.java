class ReachingPoints {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == sx && ty == sy) return true;
            if (tx == ty) return false;
            if (tx > ty) {
                if (tx == sx) return false;
                if ((tx - sx) % ty == 0)
                    tx = sx;
                else
                    tx %= ty;
            }
            else {
                if (ty == sy) return false;
                if ((ty - sy) % tx == 0)
                    ty = sy;
                else
                    ty %= tx;
            }
        }
        return false;
    }
}