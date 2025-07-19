import java.time.LocalDateTime;

public class Encargo{
    private int id;
    private LocalDateTime date;
    private String valor;

    public Encargo(int id, String valor) {
        this.id = id;
        this.valor = valor;
        this.date=LocalDateTime.now();
        Cliente.anyadirArrayList(this);
    }

    @Override
    public String toString() {
        return "Encargo [id=" + id + ", date=" + date + ", valor=" + valor + "]";
    }
}
