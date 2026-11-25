package padroesprojeto.adapter.hospital;

public class TermometroDigital implements SensorTemperatura {

    private float leitura;

    public TermometroDigital(float leitura) {
        this.leitura = leitura;
    }

    public void setLeitura(float leitura) {
        this.leitura = leitura;
    }

    @Override
    public float getTemperaturaCelsius() {
        return leitura;
    }
}
