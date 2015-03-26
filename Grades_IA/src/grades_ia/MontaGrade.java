package grades_ia;

import busca.Antecessor;
import busca.Estado;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MontaGrade implements Estado, Antecessor{
    String[][] semana = new String[5][2];
    ArrayList<Disciplina> materias;
    
    public MontaGrade(String[][] semana, ArrayList<Disciplina> materias){
        this.semana = semana;
        this.materias = materias;
        
        
    }

    public String[][] getSemana() {
        return semana;
    }
    
    @Override
    public boolean ehMeta() {
        //Semana preenchida com todas as aulas
               
        return semana[0][0] != null && semana[0][1] != null &&
               semana[1][0] != null && semana[1][1] != null &&
               semana[2][0] != null && semana[2][1] != null &&
               semana[3][0] != null && semana[3][1] != null &&
               semana[4][0] != null && semana[4][1] != null;
        
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
        if(semana[disc.getDia()[0]][disc.getHorario()[0]] != null)
            return false;
        if(semana[disc.getDia()[1]][disc.getHorario()[1]] != null)
            return false;
        if((disc.getDependencia() != null) && (!disc.getDependencia().isAprovado())){
            return false;
        }
        return true;
    }    
    
    @Override
    public String toString(){
        String retorno = "";
        /*for (Disciplina disc : materias) {
            retorno += disc.toString() + "\n";
        }*/
        
        for (int i = 0; i < 5; i++) {
            retorno += numToDia(i);
            for (int j = 0; j < 2; j++) {
                retorno += this.semana[i][j];
                if(j ==0){
                    retorno += "  /  ";
                }
            }
            retorno += "\n";
        }
        return retorno;
    }
    
    public String numToDia(int dia){
        switch(dia){
            case 0:
                return "Segunda-feira:  ";
            case 1:
                return "Terça-feira:    ";
            case 2:
                return "Quarta-feira:   ";
            case 3:
                return "Quinta-feira:   ";
            case 4:
                return "Sexta-feira:    ";
        }
        return null;
    }
    
    @Override
    public boolean equals(Object o) {
        if(o instanceof MontaGrade){
            MontaGrade grade = (MontaGrade) o;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 2; j++) {
                    if(grade.getSemana()[i][j] == null){
                        return false;
                    }
                    
                    if(!grade.getSemana()[i][j].equals(this.semana[i][j])){
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Arrays.deepHashCode(this.semana);
        return hash;
    }
}
