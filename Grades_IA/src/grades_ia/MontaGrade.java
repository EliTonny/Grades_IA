package grades_ia;

import busca.Antecessor;
import busca.Estado;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MontaGrade implements Estado, Antecessor{
    String[][] semana = new String[5][2];
    ArrayList<Disciplina> materias;
    
    public MontaGrade(String[][] semana, ArrayList<Disciplina> materias){
        this.semana = semana;
        this.materias = materias;
    }
    
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
          loop de pegar uma matéria e ver se ela se encaixa
        */
        
        for (Disciplina disciplina : materias) {
            if(ehValido(disciplina)){
                String[][] semanaNova = semana.clone();
                
                semanaNova[disciplina.getDia()[0]][disciplina.getHorario()[0]] = disciplina.getNome();
                semanaNova[disciplina.getDia()[1]][disciplina.getHorario()[1]] = disciplina.getNome();
                
                ArrayList<Disciplina> materiasNovas = new ArrayList<>();
                materiasNovas.addAll(materias);
                materiasNovas.remove(disciplina);
                MontaGrade novoEstado = new MontaGrade(semanaNova, materiasNovas);
                suc.add(novoEstado);
            }
        }
        return suc;
    }
    
    /** Lista de antecessores, para busca bidirecional */
    public List<Estado> antecessores(){
        return sucessores();
    }
    
    public boolean ehValido(Disciplina disc){        
        if(!semana[disc.getDia()[0]][disc.getHorario()[0]].equalsIgnoreCase(""))
            return false;
        if(!semana[disc.getDia()[1]][disc.getHorario()[1]].equalsIgnoreCase(""))
            return false;
        if((disc.getDependencia() != null) && (!disc.getDependencia().isAprovado())){
            return false;
        }
        return true;
    }    
    
    @Override
    public String toString(){
        String retorno = "";
        for (Disciplina disc : materias) {
            retorno += disc.toString() + "\n";
        }
        return retorno;
    }
}
