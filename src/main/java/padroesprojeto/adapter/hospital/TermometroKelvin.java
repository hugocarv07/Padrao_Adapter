package padroesprojeto.adapter.hospital;

public class TermometroKelvin {

    private float leitura;

    public TermometroKelvin(float leitura) {
        this.leitura = leitura;
    }

    public void setLeitura(float leitura) {
        this.leitura = leitura;
    }

    public float medirKelvin() {
        return leitura;
    }
}
