package grades_ia;

public class Disciplina {
    private String nome;
    private int[] horario;
    private String[] dia;
    private Disciplina dependencia;
    private boolean aprovado;
    
    public Disciplina(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int[] getHorario() {
        return horario;
    }

    public String[] getDia() {
        return dia;
    }

    public Disciplina getDependencia() {
        return dependencia;
    }

    public void setDependencia(Disciplina dependencia) {
        this.dependencia = dependencia;
    }

    public void setHorario(int[] horario) {
        this.horario = horario;
    }

    public void setDia(String[] dia) {
        this.dia = dia;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Disciplina){
            Disciplina disAux = (Disciplina) obj;
            if(disAux.getNome().equalsIgnoreCase(this.nome))
                return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        String retorno;
        retorno = "Nome: " + this.nome + "\n" +
                  "Horario 1: " + Integer.toString(this.horario[0]) + "\n" +
                  "Dia 1: " + this.dia[0] + "\n" +
                  "Horario 2: " + Integer.toString(this.horario[1]) + "\n" +
                  "Dia 2: " + this.dia[1] + "\n" +
                  "Aprovado: " + Boolean.toString(aprovado) + "\n"; 
        if(this.dependencia != null){
            retorno += "Dependente de: " + dependencia.getNome();
        }
        return retorno;
    }
}
