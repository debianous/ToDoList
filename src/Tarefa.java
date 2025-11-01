import java.time.LocalDate;

public class Tarefa {
    private String titulo;
    private String descricao;
    private LocalDate dataEntrega;
    private boolean status;

    public Tarefa (String titulo, String descricao, LocalDate dataEntrega, boolean status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo (String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao (String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega (LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus (boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "Titulo: '" + titulo + '\'' +
                ", Descricao: " + descricao + '\'' +
                ", Data de Entrega: " + dataEntrega +
                ", Status: " + status +
                '}';
    }

    public void concluir() {
        this.status = true;
    }
}