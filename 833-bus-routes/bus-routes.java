class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {

        if (source == target) return 0;

        int n = routes.length;

        // stop -> which buses pass through it
        Map<Integer, List<Integer>> stopToBus = new HashMap<>();

        for (int bus = 0; bus < n; bus++) {
            for (int stop : routes[bus]) {
                stopToBus.putIfAbsent(stop, new ArrayList<>());
                stopToBus.get(stop).add(bus);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visitedBus = new boolean[n];
        Set<Integer> visitedStop = new HashSet<>();

        // Start from the source stop
        visitedStop.add(source);
        q.add(source);

        int buses = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            buses++;

            while (size-- > 0) {
                int stop = q.poll();

                // Try all buses passing through this stop
                for (int bus : stopToBus.getOrDefault(stop, new ArrayList<>())) {
                    if (visitedBus[bus]) continue;
                    visitedBus[bus] = true;

                    // Check all stops reachable by this bus
                    for (int nextStop : routes[bus]) {
                        if (nextStop == target) return buses;
                        if (!visitedStop.contains(nextStop)) {
                            visitedStop.add(nextStop);
                            q.add(nextStop);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
