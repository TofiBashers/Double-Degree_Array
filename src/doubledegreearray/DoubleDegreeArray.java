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
public class DoubleDegreeArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        HashSet<Integer> AdjList[];
        BufferedReader reader = new BufferedReader(new FileReader("rosalind_ddeg.txt"));
        FileWriter writer = new FileWriter(new File("output.txt"));
        String Nums[] = reader.readLine().split(" ");
        int V = Integer.parseInt(Nums[0]);
        AdjList = new HashSet[V+1];
        for(int i = 0; i<V+1; i++)
        {
            AdjList[i] = new HashSet();
        }
        int E = Integer.parseInt(Nums[1]);
        while(reader.ready())
        {
            String str[] = reader.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            AdjList[a].add(b);
            AdjList[b].add(a);
        }
        for(int i = 1; i <= V; i++)
        {
            int NeighboursDegrees = 0;
            Iterator<Integer> it = AdjList[i].iterator();
            while(it.hasNext())
            {
                NeighboursDegrees += AdjList[it.next()].size();
            }
            writer.write(NeighboursDegrees + " ");
            writer.flush();
        }
        writer.close();
    }
}
