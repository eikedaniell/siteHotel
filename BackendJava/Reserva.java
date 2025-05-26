import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author Luís G. C. Barbosa
 */

public class Reserva {

    // Atributos para realização da reserva
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Suite suite;
    private Cliente cliente;
    private boolean ativa;
    private Pagamento pagamento;

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setSuit(Suite suite) {
        this.suite = suite;
    }

    public Suite getSuite() {
        return suite;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public Reserva(LocalDate checkIn, LocalDate checkOut, Suite suite, Cliente cliente) {
        if (!suite.isDisponivel()) {
            throw new IllegalArgumentException("A suíte já está reservada.");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.suite = suite;
        this.cliente = cliente;
        this.ativa = true;

        suite.setDisponivel(false); //ao realizar uma reserva a suite fica automaticamente indisponivel para outras reservas
    }

    public void cancelarReserva() {
        this.ativa = false;
        suite.setDisponivel(true); // O cancelamento de uma reserva deixa a suite disponível para outras reservas
        System.out.println("Reserva cancelada");
    }

    public void alterarDatas(LocalDate novoCheckIn, LocalDate novoCheckOut) {
        if (ativa) {
            this.checkIn = novoCheckIn;
            this.checkOut = novoCheckOut;
            System.out.println("As datas da reserva foram alteradas");
        } else {
            System.out.println("Não é possível alterar uma reserva cancelada");
        }
    }

    public long getNumeroDeNoites() {
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public double calcularValorTotal() {
        if (suite != null) {
            return suite.getPrecoPorNoite() * getNumeroDeNoites();
        } else {
            return 0.0;
        }
    }

    public double calcularValorTotal(String formaDePagamento) {
        double valorTotal = calcularValorTotal();
        this.pagamento = new Pagamento(valorTotal, formaDePagamento);
        System.out.printf("Valor total a ser pago: R$ %f", valorTotal);
        return valorTotal;
    }

}
