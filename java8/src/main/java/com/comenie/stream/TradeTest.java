package com.comenie.stream;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by zkp2p-apple on 17/4/7.
 */
public class TradeTest {
    public static void main(String[] args) {
        List<Transaction> transactions = transactions().stream()
                .filter(s -> s.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        List<String> where = transactions.stream()
                .map(s -> s.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        Set<String> where2 = transactions.stream()
                .map(s -> s.getTrader().getCity())
                .collect(Collectors.toSet());

        List<String> p3 = transactions.stream()
                    .filter(s -> s.getTrader().getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(s->s.getTrader().getName()))
                .map(s -> s.getTrader().getName())
                .collect(Collectors.toList());

        Boolean isMilan = transactions().stream()
                .anyMatch(s->s.getTrader().getCity().equals("Milan"));

        List<Integer>  jiaoyi = transactions.stream()
                .filter(s -> s.getTrader().getCity().equals("Cambridge"))
                .map(transaction -> transaction.getValue())
                .collect(Collectors.toList());
         Integer max = transactions.stream()
                .max(Comparator.comparing(s -> s.getValue())).get().getValue();

    }


    public static List<Trader> traders(){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        return  Lists.newArrayList(raoul,mario,alan,brian);
    }

    public static   List<Transaction> transactions (){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        return  transactions;
    }
}
