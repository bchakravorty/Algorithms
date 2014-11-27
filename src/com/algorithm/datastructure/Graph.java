package com.algorithm.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by biswac on 11/19/2014.
 */
public class Graph {
    private char[] vertices;
    private List<Character>[] edges;
    public static int CHARACTER_STARTINDEX = 65;
    private int size;

    public int getSize() {
        return size;
    }

    public Graph(int numberOfVertices) {
        size = numberOfVertices;
       vertices = new char[numberOfVertices];
       edges = new List[numberOfVertices];

       for(int i = 0; i < numberOfVertices; i++) {
            vertices[i] = (char)(CHARACTER_STARTINDEX + i);
            edges[i] =  new ArrayList<Character>();
       }
    }

    public void addEdge(char src, char dest) {
        int srcIndex = getIndex(src);
        int destIndex = getIndex(dest);
        edges[srcIndex].add(dest);
        edges[destIndex].add(src);
    }

    public static int getIndex(char src) {
        return src - CHARACTER_STARTINDEX;
    }


    public List<Character> getNeighbours(char src) {
        int srcIndex = getIndex(src);
        return edges[srcIndex];
    }


}
