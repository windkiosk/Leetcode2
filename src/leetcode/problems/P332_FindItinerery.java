package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class P332_FindItinerery {

    public static void main(String[] args) {
        P332_FindItinerery itinerery = new P332_FindItinerery();
        String[][] tickets = {
                {"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}
        };

        itinerery.findItinerary(tickets);
    }

    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;

    public List<String> findItineraryOptimal(String[][] tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");
        return path;
    }

    public void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        path.addFirst(departure);
    }

    public List<String> findItinerary(String[][] tickets) {
        ItinereryGraph graph = new ItinereryGraph();
        graph.init(tickets);
        List<List<String>> jfk = graph.findItineraryWithStart("JFK");
        return jfk.get(0);
    }

    static class ItinereryGraph {
        Map<String, List<String>> nei;
        Set<String> isV;

        public ItinereryGraph() {
            nei = new HashMap<>();
            isV = new HashSet<>();
        }

        void init(String[][] tickets) {
            for (String[] ticket : tickets) {
                String ori = ticket[0];
                String dest = ticket[1];
                isV.add(ori + dest);
                List<String> dests = nei.get(ori);
                if(dests == null) {
                    dests = new ArrayList<>();
                    nei.put(ori, dests);
                }
                dests.add(dest);
            }
        }

        List<List<String>> findItineraryWithStart(String start) {
            List<List<String>> ret = new ArrayList<>();
            List<String> curr = new ArrayList<>();
            curr.add(start);
            findUtil(start, curr, ret);
            return ret;
        }

        private void findUtil(String start, List<String> curr, List<List<String>> ret) {
            for(String dest : nei.get(start)) {
                if (isV.contains(start + dest)) {
                    isV.remove(start + dest);
                    curr.add(dest);
                    if (isV.isEmpty()) {
                        ret.add(new ArrayList<>(curr));
                    } else {
                        findUtil(dest, curr, ret);
                    }
                    curr.remove(curr.size() - 1);
                    isV.add(start + dest);
                }
            }
        }
    }
}
