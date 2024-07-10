import entities.Chain;
import services.ChainServices;

public class Main {
    public static void main(String[] args) {

        ChainServices cServices = new ChainServices();

        Chain c1 = cServices.createChain();
        cServices.chainOperations(c1);
    }
}