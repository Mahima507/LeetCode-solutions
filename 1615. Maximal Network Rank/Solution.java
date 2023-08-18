class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int ans = 0;
        
        int[] degrees = new int[n];
        Set<List<Integer>> edges = new HashSet<>();
        
        for (int[] road : roads) {
            if (road[0] > road[1]) {
                int temp = road[0];
                road[0] = road[1];
                road[1] = temp;
            }
            List<Integer> roadList = new ArrayList<>();
            roadList.add(road[0]);
            roadList.add(road[1]);
            edges.add(roadList);
            degrees[road[0]]++;
            degrees[road[1]]++;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int connected = edges.contains(Arrays.asList(i, j)) ? 1 : 0;
                ans = Math.max(ans, degrees[i] + degrees[j] - connected);
            }
        }
        
        return ans;
    }
}
