package grades_ia;

import busca.Estado;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
