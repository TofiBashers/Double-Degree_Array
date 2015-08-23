/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doubledegreearray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author TofixXx
 */

/** Solution for the Double Degree problem. 
 * Source graph save in array of HashSet
 */
public class DoubleDegreeArray {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("rosalind_ddeg.txt"));
                FileWriter writer = new FileWriter(new File("output.txt"))) {
            String[] nums = reader.readLine().split(" ");
            int V = Integer.parseInt(nums[0]);
            HashSet<Integer>[] adjList = new HashSet[V + 1];
            for (int i = 0; i < V + 1; i++) {
                adjList[i] = new HashSet();
            }
            int E = Integer.parseInt(nums[1]);
            while (reader.ready()) {
                String str[] = reader.readLine().split(" ");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);
                adjList[a].add(b);
                adjList[b].add(a);
            }
            for (int i = 1; i <= V; i++) {
                int neighboursDegrees = 0;
                Iterator<Integer> it = adjList[i].iterator();
                while (it.hasNext()) {
                    neighboursDegrees += adjList[it.next()].size();
                }
                writer.write(neighboursDegrees + " ");
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
