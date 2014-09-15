package com.test;

import com.algorithm.datastructure.Heap;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by biswac on 9/4/2014.
 */
public class HeapTest {

    @Test
    public void testHeapAdd(){
        Heap<MusicAlbum> heap = new Heap<MusicAlbum>();
        MusicAlbum m0 = new MusicAlbum("Zerich", "A111"); heap.add(m0);
        MusicAlbum m1 = new MusicAlbum("Kishore Kumar", "RD Burman"); heap.add(m1);
        MusicAlbum m2 = new MusicAlbum("Anand Kumar", "Amar"); heap.add(m2);
        String result = "Anand Kumar ; Amar : Zerich ; Sumanta : Kishore Kumar ; RD Burman : ";
        Assert.assertEquals(heap.toString(), result);
        System.out.println("Heap - "+heap);
    }



    public static class MusicAlbum implements Comparable {
        String name;
        String musicDirector;

        public MusicAlbum(String name, String musicDirector){
            this.name = name;
            this.musicDirector = musicDirector;
        }

        public String getMusicDirector() {
            return musicDirector;
        }

        public String getName() {
            return name;
        }


        @Override
        public int compareTo(Object obj) {
            if (!(obj instanceof MusicAlbum)) {
                throw new IllegalArgumentException("Obj is not an instance of MusicAlbum");
            }
            if (obj == this) return 0;
            MusicAlbum m1 = (MusicAlbum)obj;
            return m1.name.compareTo(this.name);

        }

        @Override
        public String toString() {
            String str = this.name + " ; "+ this.musicDirector;
            return str;
        }
    }
}
