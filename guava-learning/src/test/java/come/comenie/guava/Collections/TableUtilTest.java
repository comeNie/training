package come.comenie.guava.Collections;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

/**
 * Created by 波 on 2017/1/20.
 */
public class TableUtilTest {
    @Test
    public void testRow() {
        Table<String,String,Integer> table = HashBasedTable.create();
        table.put("v1","v2",20);
        table.put("v1","v3",30);
        table.put("v2","v3",40);
        Map<String,Integer> rowResult = Maps.newHashMap();
        rowResult.put("v2",20);
        rowResult.put("v3",30);
        Assert.assertEquals(rowResult,table.row("v1"));
    }

    @Test
    public void testColumn() {
        Table<String,String,Integer> table = HashBasedTable.create();
        table.put("v1","v2",20);
        table.put("v1","v3",30);
        table.put("v2","v3",40);
        Map<String,Integer> rowResult = Maps.newHashMap();
        rowResult.put("v1",30);
        rowResult.put("v2",40);
        Assert.assertEquals(rowResult,table.column("v3"));
    }

    @Test
    public void testCellSet() {
        Table<String,String,Integer> table = HashBasedTable.create();
        table.put("v1","v2",20);
        table.put("v1","v3",30);
        table.put("v2","v3",40);
        Set<Table.Cell<String,String,String>> cellSet = Sets.newHashSet(
                new Table.Cell[]{ Tables.immutableCell("v1","v2",20),
                        Tables.immutableCell("v1","v3",30),
                        Tables.immutableCell("v2","v3",40)}
        );

        Assert.assertEquals(cellSet,table.cellSet());
    }

}