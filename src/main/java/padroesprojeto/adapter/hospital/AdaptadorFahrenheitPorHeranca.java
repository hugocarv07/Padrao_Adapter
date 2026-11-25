package padroesprojeto.adapter.hospital;

public class AdaptadorFahrenheitPorHeranca extends TermometroFahrenheit implements SensorTemperatura {

    public AdaptadorFahrenheitPorHeranca(float leitura) {
        super(leitura);
    }

    @Override
    public float getTemperaturaCelsius() {
        return (lerFahrenheit() - 32) * 5 / 9;
    }
}
