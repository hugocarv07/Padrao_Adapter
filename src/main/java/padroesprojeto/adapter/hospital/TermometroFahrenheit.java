package padroesprojeto.adapter.hospital;

public class TermometroFahrenheit {

    private float leitura;

    public TermometroFahrenheit(float leitura) {
        this.leitura = leitura;
    }

    public void setLeitura(float leitura) {
        this.leitura = leitura;
    }

    public float lerFahrenheit() {
        return leitura;
    }
}
