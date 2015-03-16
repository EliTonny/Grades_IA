package grades_ia;

import busca.Estado;
import java.util.LinkedList;
import java.util.List;

public class MontaGrade implements Estado{
    String[][] semana = new String[5][5];
    
    @Override
    public boolean ehMeta() {
        //Semana preenchida com todas as aulas
        return ! "".equals(semana[0][0]) && ! "".equals(semana[0][1]) &&
               ! "".equals(semana[1][0]) && ! "".equals(semana[1][1]) &&
               ! "".equals(semana[2][0]) && ! "".equals(semana[2][1]) &&
               ! "".equals(semana[3][0]) && ! "".equals(semana[3][1]) &&
               ! "".equals(semana[4][0]) && ! "".equals(semana[4][1]);
    }

    @Override
    public int custo() {
        return 1;
    }

    @Override
    public List<Estado> sucessores() {
        List<Estado> suc = new LinkedList<Estado>(); //Lista de sucessores
        /*
          loop de pegar uma matéria e ver se ela se encaixa, pelo menos eu acho
        */
        return suc;
    }
    
    public boolean ehValido(int dia1, int horario1, int dia2, int horario2){
        if(!semana[dia1][horario1].equalsIgnoreCase(""))
            return false;
        if(!semana[dia2][horario2].equalsIgnoreCase(""))
            return false;
        return true;
    }
    
}
