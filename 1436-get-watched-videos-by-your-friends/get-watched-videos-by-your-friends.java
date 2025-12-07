class Solution {
    public List<String> watchedVideosByFriends(
            List<List<String>> watchedVideos,
            int[][] friends,
            int id, 
            int level) {

        int n = friends.length;
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(id);
        vis[id] = true;
        int curLevel = 0;

        while (!q.isEmpty() && curLevel < level) {
            int size = q.size();
            while (size-- > 0) {
                int u = q.poll();
                for (int v : friends[u]) {
                    if (!vis[v]) {
                        vis[v] = true;
                        q.add(v);
                    }
                }
            }
            curLevel++;
        }

        Map<String, Integer> freq = new HashMap<>();

        // All nodes remaining in queue = exact level
        while (!q.isEmpty()) {
            int u = q.poll();
            for (String video : watchedVideos.get(u)) {
                freq.put(video, freq.getOrDefault(video, 0) + 1);
            }
        }

        List<String> result = new ArrayList<>(freq.keySet());
        result.sort((a, b) -> freq.get(a) == freq.get(b)
                ? a.compareTo(b)
                : freq.get(a) - freq.get(b));

        return result;
    }
}
