import java.util.ArrayList;
import java.util.Stack;

public class AsteroidCollision {
    Stack<Integer> right_moving = new Stack<>();
    ArrayList<Integer> left_moving = new ArrayList<>();

    public int[] asteroidCollision(int[] asteroids) {
        for (int planet: asteroids) {
            if (planet > 0)
                right_moving.push(planet);
            else {
                if (right_moving.size() != 0) {
                    while (planet != 0 && right_moving.size() != 0) {
                        if (right_moving.peek() == -planet) {
                            planet = 0;
                            right_moving.pop();
                        }
                        else if (right_moving.peek() < -planet) {
                            right_moving.pop();
                        }
                        else {
                            planet = 0;
                        }
                    }
                    if (planet != 0)
                        left_moving.add(planet);
                }
                else
                    left_moving.add(planet);
            }
        }
        int[] ans = new int[left_moving.size() + right_moving.size()];
        for (int i = 0; i < left_moving.size(); i++) {
            ans[i] = left_moving.get(i);
        }
        for (int j = ans.length - 1; j >= left_moving.size(); j--) {
            ans[j] = right_moving.pop();
        }
        return ans;
    }
}
