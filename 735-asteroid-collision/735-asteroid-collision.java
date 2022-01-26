class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> curAsteroids = new ArrayList<>();
        boolean isCoollision = true;

        for(int asteroid : asteroids) {
            curAsteroids.add(asteroid);
        }

        while(isCoollision) {
            isCoollision = false;
            
            for(int i = 0; i < curAsteroids.size() - 1; i++) {
                int cur = curAsteroids.get(i);
                int next = curAsteroids.get(i + 1);
                if(cur > 0 && next < 0) {
                    if(Math.abs(cur) > Math.abs(next)) {
                        curAsteroids.set(i + 1, cur);
                    } else if(Math.abs(cur) < Math.abs(next)) {
                        curAsteroids.set(i + 1, next);
                    } else {
                        curAsteroids.remove(i + 1);
                    }
                    curAsteroids.remove(i);
                    isCoollision = true;
                } 
            }
        }
    
        return curAsteroids.stream().mapToInt(Integer::intValue).toArray();
    }
}