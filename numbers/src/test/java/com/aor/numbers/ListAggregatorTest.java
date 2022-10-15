package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {

    public List<Integer> list;
    @Test
    public void sum() {
        //List<Integer> list = Arrays.asList(1,2,4,2,5);
        helper();
        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        //List<Integer> list = Arrays.asList(1,2,4,2,5);
        helper();
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void max_bug_7263(){
        //helper();
        List<Integer> lista=Arrays.asList(-1,-4,-5);
        ListAggregator aggregator=new ListAggregator();
        int max =aggregator.max(lista);

        Assertions.assertEquals(-1,max);
    }

    @Test
    public void min() {
        //List<Integer> list = Arrays.asList(1,2,4,2,5);
        helper();
        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        //List<Integer> list = Arrays.asList(1,2,4,2,5);
        helper();
        ListSorter sorter=new ListSorter();
        ListAggregator aggregator = new ListAggregator();
        //ListDeduplicator deduplicator=new ListDeduplicator(sorter);
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        int distinct = aggregator.distinct(list, deduplicator);

        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));
        //Assertions.assertEquals(4, distinct);
    }

    @Test
    public void bug_report_8726(){
        List<Integer> lista=Arrays.asList(1,2,4,2);
        ListAggregator aggregator = new ListAggregator();
        //int distinct=aggregator.distinct(lista);
        ListSorter sorter=new ListSorter();
        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        int distinct = aggregator.distinct(Arrays.asList(1, 2, 4, 2), deduplicator);

        Assertions.assertEquals(3,distinct);
    }

    public void helper(){list=Arrays.asList(1,2,4,2,5);}
}
