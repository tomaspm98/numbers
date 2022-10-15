package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    public List<Integer> list;

    @Test
    public void deduplicate() {
        List<Integer> list = Arrays.asList(1,2,4,2,5);
        List<Integer> expected = Arrays.asList(1,2,4,5);


        ListSorter sorter=new ListSorter();
        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> distinct = deduplicator.deduplicate(list);

        Assertions.assertEquals(expected, distinct);
    }

    @Test
    public void deduplicate2(){
        List<Integer> list=Arrays.asList(1,2,4,2);
        List<Integer> expected=Arrays.asList(1,2,4);

        ListSorter sorter=new ListSorter();
        //ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        List<Integer> distinct = deduplicator.deduplicate(list);

        Assertions.assertEquals(expected, distinct);
    }

    public void helper(){list=Arrays.asList(1,2,4,2,5);}
}
