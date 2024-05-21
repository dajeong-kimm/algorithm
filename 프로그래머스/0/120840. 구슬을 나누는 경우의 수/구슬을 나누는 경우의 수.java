import java.math.*;
class Solution {
    public BigInteger solution(int balls, int share) {
        return factor(balls).divide(factor(balls - share).multiply(factor(share)));
    }
    public BigInteger factor(int num){
        BigInteger ret = new BigInteger("1");
        BigInteger from = new BigInteger("1");
        BigInteger to = new BigInteger(String.valueOf(num));
        for(BigInteger i = from; i.compareTo(to) <= 0; i = i.add(BigInteger.ONE)){
            ret = ret.multiply(i);
        }
        return ret;
    }
}