import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class BusiestServers {

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int maxServerNum = 0;
        int curTime = 0;
        int initServer = 0;
        int[] servedNum = new int[k];
        List<Integer> ans = new ArrayList<>();;
        PriorityQueue<Integer> servers = new PriorityQueue<>();
        PriorityQueue<int[]> loading = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i < k; i++)
            servers.add(i);
        for (int i = 0; i < arrival.length; i++) {
            curTime = arrival[i];
            initServer = i % k;
            // 定义当 servers 中的编号小于当前时间时，会变得 unavailable
            while (!servers.isEmpty() && servers.peek() < i)
                servers.poll();
            // 定义 loading 里的时间一到，server 就会变得 available
            while (!loading.isEmpty() && loading.peek()[1] <= curTime) {
                int availableServer = loading.poll()[0];
                int delta = availableServer - initServer;
                if (delta < 0)
                    delta += k;
                servers.add(i + delta);
            }
            // 无 server 可用
            if (servers.isEmpty()) continue;
            // 有 server 可用
            int toUse = servers.poll() % k;
            loading.add(new int[]{toUse, curTime + load[i]});
            servedNum[toUse]++;
            if (servedNum[toUse] > maxServerNum) {
                maxServerNum = servedNum[toUse];
                ans = new ArrayList<>();
                ans.add(toUse);
            }
            else if (servedNum[toUse] == maxServerNum)
                ans.add(toUse);
        }
        return ans;
    }
}