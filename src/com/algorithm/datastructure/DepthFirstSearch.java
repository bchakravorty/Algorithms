package com.algorithm.datastructure;

import java.util.List;

/**
 * Created by biswac on 11/19/2014.
 */
public class DepthFirstSearch {
    private Graph graph;
    private char[] from;
    private boolean[] isExplored;
    private char source;

    public DepthFirstSearch(Graph g, char source) {
        graph = g;
        from = new char[g.getSize()];
        isExplored = new boolean[g.getSize()];
        this.source = source;
        DFS(source);
    }

    private void DFS(char src) {
        int srcIndex = Graph.getIndex(src);
        isExplored[srcIndex] = true;
        List<Character> edges = graph.getNeighbours(src);
        for (Character edge : edges) {
            char dest = edge.charValue();
            int destIndex = Graph.getIndex(dest);
            if (!isExplored[destIndex]) {
                from[destIndex] = src;
                DFS(dest);
            }
        }
    }

    public void printFrom(){
        for (int i = 0 ; i < from.length; i++){
            char destination = (char)(i + Graph.CHARACTER_STARTINDEX);
            char source =  from[i];
            System.out.println("destination - "+destination+" - "+source);
        }
    }


    public static void main(String[] args) {
//        Graph g = new Graph(8);
//        g.addEdge('A', 'B'); g.addEdge('A', 'F');g.addEdge('A', 'E');
//        g.addEdge('B', 'G');
//        g.addEdge('C','G'); g.addEdge('C', 'D'); g.addEdge('C', 'H');
//        g.addEdge('E','F');
//        g.addEdge('G', 'H');

        Graph g = new Graph(8);
        g.addEdge('A', 'E'); g.addEdge('A', 'B');
        g.addEdge('B', 'F');g.addEdge('B', 'G');
        g.addEdge('C','H'); g.addEdge('C', 'G'); g.addEdge('C', 'D');
        g.addEdge('E','F');
        g.addEdge('G', 'H');

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(g, 'A');
        depthFirstSearch.printFrom();

    }

}
