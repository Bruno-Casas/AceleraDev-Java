package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Estacionamento {
    List<Carro> vagas = new ArrayList<>();

    public void estacionar(Carro carro) {
        if(Objects.isNull(carro.getMotorista()))
            throw new EstacionamentoException("Não são permitidos carros autonomos.");
        
        if(carro.getMotorista().getIdade() < 18)
            throw new EstacionamentoException("Não são permitidos motoristas menorres de idade.");

        if(carro.getMotorista().getPontos() > 20)
            throw new EstacionamentoException("Não são permitidos motoristas com habilitação suspensa.");
        
        if(vagas.size() < 10)
            vagas.add(carro);
        else if (liberarVagaSePossivel())
            vagas.add(carro);
        else
        throw new EstacionamentoException("Não existem mais vagas disponiveis.");

    }

    public int carrosEstacionados() {
        return vagas.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return vagas.contains(carro);
    }

    private boolean liberarVagaSePossivel(){
        for (Carro carro : vagas) {
            if(carro.getMotorista().getIdade() <= 55){
                vagas.remove(carro);
                return true;
            }
        }

        return false;
    }
}
