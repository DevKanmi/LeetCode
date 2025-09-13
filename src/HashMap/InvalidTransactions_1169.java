package HashMap;
import java.util.*;

/*
TC: o(n^2) ->  Building hashmap => o(n), validating tx = o(n^2) a worst case of where a single name has all the transactions
we have to go through the whole string array in the worst case.

SC:o(n)

Approach: We create a transaction class where we split each transaction into name, time,amount and city after doing so
we can then group each name and the transactions under that name into a list using a hashmap and when we do that,
we can simply check if that transaction is valid with the 2 conditions of if amount being <1000 and we the time
taking for a different transaction in a different city is >60 then that particular tx is true.
 */



class Transaction{
    String name;
    int time;
    int amount;
    String city;

    public Transaction(String transaction){
        String[] s = transaction.split(",");
        this.name = s[0];
        this.time = Integer.parseInt(s[1]);
        this.amount = Integer.parseInt(s[2]);
        this.city = s[3];
    }
}

public class InvalidTransactions_1169 {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> res = new ArrayList<>();

        //Map to group txn by "name"
        Map<String, List<Transaction>> map = new HashMap<>();

        //Group transactions
        for(String tx : transactions){
            Transaction transaction = new Transaction(tx);
            map.putIfAbsent(transaction.name, new ArrayList<>());
            map.get(transaction.name).add(transaction);
        }

        //Now check each transaction and it list to compare based on conditions
        for(String txn : transactions){
            Transaction transaction = new Transaction(txn);
            if(!isValid(transaction, map.getOrDefault(transaction.name, new ArrayList<>()))){
                res.add(txn);
            }
        }

        return res;
    }

    private boolean isValid(Transaction t, List<Transaction> txns){
        if(t.amount > 1000) return false;

        for(Transaction tx : txns){
            if((Math.abs(t.time - tx.time) <= 60) && !tx.city.equals(t.city)) return false;
        }

        return true;
    }
}
