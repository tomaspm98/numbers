package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {
    @Test
    public void filter(){
        GenericListFilter filter = Mockito.mock(GenericListFilter.class);
        Mockito.when(filter.accept(1)).thenReturn(true);
        Mockito.when(filter.accept(2)).thenReturn(false);
        Mockito.when(filter.accept(3)).thenReturn(true);
        Mockito.when(filter.accept(4)).thenReturn(false);
        Mockito.when(filter.accept(5)).thenReturn(true);

        ListFilterer filterer = new ListFilterer(filter);
        Assertions.assertEquals(Arrays.asList(1, 3, 5), filterer.filter(Arrays.asList(1, 2, 3, 4, 5)));

        PositiveFilter filter1=Mockito.mock(PositiveFilter.class);
        Mockito.when(filter1.accept(1)).thenReturn(true);
        Mockito.when(filter1.accept(5)).thenReturn(true);
        Mockito.when(filter1.accept(-1)).thenReturn(false);
        Mockito.when(filter1.accept(-3)).thenReturn(false);

        DivisibleByFilter filter2=new DivisibleByFilter(2);
        List<Integer> lista1=Arrays.asList(2,6,8,10,14,68);
        List<Integer> lista2=Arrays.asList(1,7,9,97,65,79);

        for (int n:lista1){
            Assertions.assertTrue(filter2.accept(n));
        }

        for (int n:lista2){
            Assertions.assertFalse(filter2.accept(n));
        }

        PositiveFilter filter3=new PositiveFilter();
        List<Integer> lista3= Arrays.asList(1,5,7,8,9,10,15,89);

        for (int n:lista3){
            Assertions.assertTrue(filter3.accept(n));
        }

        List<Integer> lista4=Arrays.asList(-1,-6,-7,-10,-50);

        for (int n:lista4){
            Assertions.assertFalse(filter3.accept(n));
        }

    }
}
