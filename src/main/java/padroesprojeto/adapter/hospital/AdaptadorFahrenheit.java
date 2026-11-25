package padroesprojeto.adapter.hospital;

public class AdaptadorFahrenheit implements SensorTemperatura {

    private final TermometroFahrenheit termometro;

    public AdaptadorFahrenheit(TermometroFahrenheit termometro) {
        this.termometro = termometro;
    }

    @Override
    public float getTemperaturaCelsius() {
        return (termometro.lerFahrenheit() - 32) * 5 / 9;
    }
}
