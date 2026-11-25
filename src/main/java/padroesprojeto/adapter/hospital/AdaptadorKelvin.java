package padroesprojeto.adapter.hospital;

public class AdaptadorKelvin implements SensorTemperatura {

    private final TermometroKelvin termometro;

    public AdaptadorKelvin(TermometroKelvin termometro) {
        this.termometro = termometro;
    }

    @Override
    public float getTemperaturaCelsius() {
        return termometro.medirKelvin() - 273.15f;
    }
}
