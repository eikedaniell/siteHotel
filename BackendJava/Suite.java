import java.util.List;

/**
 * @author Luís G. C. Barbos
 */

public class Suite {

    private String nome;
    private int numeroDeQuartos;
    private int numeroDeBanheiros;
    private boolean temArCondicionado;
    private boolean temWifi;
    private double precoPorNoite;
    private boolean disponivel;

    private List<Reserva> reservas;

    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNumeroDeQuartos(int numeroDeQuartos) {
        this.numeroDeQuartos = numeroDeQuartos;
    }

    public int getNumeroDeQuartos() {
        return numeroDeQuartos;
    }

    public void setNumeroDeBanheiros(int numeroDeBanheiros) {
        this.numeroDeBanheiros = numeroDeBanheiros;
    }

    public int getNumeroDeBanheiros() {
        return numeroDeBanheiros;
    }

    public void setTemArCondicionado(boolean temArCondicionado) {
        this.temArCondicionado = temArCondicionado;
    }

    public boolean isTemArCondicionado() {
        return temArCondicionado;
    }

    public void setTemWifi(boolean temWifi) {
        this.temWifi = temWifi;
    }

    public boolean isTemWifi() {
        return temWifi;
    }

    public void setPrecoPorNoite(double precoPorNoite) {
        this.precoPorNoite = precoPorNoite;
    }

    public double getPrecoPorNoite() {
        return precoPorNoite;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public Suite(String nome, int numeroDeQuartos, int numeroDeBanheiros,
                 boolean temArCondicionado, boolean temWifi, double precoPorNoite) {
        this.nome = nome;
        this.numeroDeQuartos = numeroDeQuartos;
        this.numeroDeBanheiros = numeroDeBanheiros;
        this.temArCondicionado = temArCondicionado;
        this.temWifi = temWifi;
        this.precoPorNoite = precoPorNoite;
        this.disponivel = true;
    }

    public String getDescricaoCompleta() {
        return String.format("Suíte %s - Quartos: %d, Banheiros: %d, Ar-Condicionado: " +
                "%s, Wifi: %s, R$ %.2f/noite", nome, numeroDeQuartos, numeroDeBanheiros,
                temArCondicionado ? "Sim" : "Não", temWifi ? "Sim" : "Não", precoPorNoite);
    }
}
