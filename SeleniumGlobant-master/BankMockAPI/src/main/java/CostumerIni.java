import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CostumerIni {
    public List<CostumerPOJO> costumers = new ArrayList<>();
    public List<CostumerPOJO> MakeTenCostumers(){
        Random rand = new Random();
        for(int i = 0; i < 10; i++){
            CostumerPOJO costumer = new CostumerPOJO();
            costumers.add(costumer);

        }
        for (int j = 0; j < costumers.size(); j++){
            costumers.get(j).setUsername("JohnDoe"+j);
            costumers.get(j).setPassword("pass"+j);
            costumers.get(j).setEmail(costumers.get(j).getUsername()+j);
            costumers.get(j).setAccountBalance(rand.nextInt(10-500));
        }
        return costumers;
    }
}
