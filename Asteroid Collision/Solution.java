class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                list.add(asteroid);
            } else {
                while (!list.isEmpty() && list.get(list.size() - 1) > 0 && list.get(list.size() - 1) < -asteroid) {
                    list.remove(list.size() - 1);
                }
                if (list.isEmpty() || list.get(list.size() - 1) < 0) {
                    list.add(asteroid);
                } else if (list.get(list.size() - 1) == -asteroid) {
                    list.remove(list.size() - 1);
                } // else do nothing, asteroid gets destroyed.
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
